package com.loonxi.mail.api;

import com.loonxi.mail.api.inter.MailAbstractApi;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailProtocolEnum;
import com.loonxi.mail.entity.EmailMessage;
import com.loonxi.mail.entity.EmailMessageVO;
import com.loonxi.mail.entity.UserAuthentication;
import com.loonxi.mail.util.MailConvetor;
import com.loonxi.mail.util.MailParser;
import com.onloon.scrm.common.beans.Result;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.util.logging.MailHandler;
import org.apache.commons.lang3.StringUtils;

import javax.mail.*;
import javax.mail.search.SearchTerm;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public class MailReceiveApi  extends MailAbstractApi {

    protected  MailReceiveApi(UserAuthentication userAuthentication, EmailEnum emailEnum){
        super(userAuthentication,emailEnum);
    }

    public Result<EmailMessageVO> mailList(EmailLabelEnum labelEnum,String uid) {
        Result<EmailMessageVO> result = null;
        Store store = null;
        Folder emailFolder = null;
        try{
            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.IMAP);

            //获取session
            Session emailSession = Session.getDefaultInstance(properties);
            //create the IMAP store object and connect with the pop server
            store = emailSession.getStore("imap");
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            //获取floder对象并打开它
            emailFolder = store.getFolder((String)this.menuProperties.get(labelEnum.getDesc()));
            //以只读方式打开
            emailFolder.open(Folder.READ_ONLY);
            IMAPFolder inbox = (IMAPFolder) emailFolder;
            Message[] messages = emailFolder.getMessages();
            EmailMessageVO messageVO = new EmailMessageVO();
            messageVO.setType((String)this.menuProperties.get(labelEnum.getDesc()));
            messageVO.setTotalCount(emailFolder.getMessageCount());
            messageVO.setUnreadCount(emailFolder.getUnreadMessageCount());
            List<EmailMessage> emailMessages = new ArrayList<>();
            for(Message message : messages){
                String messageUid = Long.toString(inbox.getUID(message));
                if(messageUid.compareTo(uid == null ? "" : uid) > 0){
                    MailParser mailParser = MailConvetor.messageToMailParser(message);
                    EmailMessage  emailMessage = new EmailMessage();
                    emailMessage.setMessageId(Long.toString(inbox.getUID(message)));
                    emailMessage.setMessageNum(message.getMessageNumber());
                    emailMessage.setCc(mailParser.getMailAddress("cc"));
                    emailMessage.setBcc(mailParser.getMailAddress("bcc"));
                    emailMessage.setBody(mailParser.getBodyText());
                    emailMessage.setFrom(mailParser.getFrom());
                    emailMessage.setHasRed(mailParser.isNew());
                    emailMessage.setHasReplySign(mailParser.getReplySign());
                    emailMessage.setSendDate(mailParser.getSentDate());
                    emailMessage.setSubject(mailParser.getSubject());
                    emailMessage.setTo(mailParser.getMailAddress("to"));
                    emailMessage.setAttachMap(mailParser.getAttachMap());
                    emailMessage.setReceiveDate(mailParser.getReceiveDate());
                    emailMessage.setBodyHtml(mailParser.getBodyHtml());
                    emailMessages.add(emailMessage);
                }else{
                    messageVO.setTotalCount(messageVO.getTotalCount()-1);
                }

            }
            Comparator<EmailMessage> comparator = (h1, h2) -> h1.getReceiveDate().compareTo(h2.getReceiveDate());
            //emailMessages.sort(comparator.reversed());
            emailMessages  = emailMessages.parallelStream().sorted(comparator.reversed()).collect(Collectors.toList());
            messageVO.setEmailMessageList(emailMessages);
            result = Result.success(messageVO);
        }catch (Exception exception){
            logger.error(String.format(" fetch  email fail  msg:[ %s ]",exception.getMessage()));
            result = Result.failure(exception.getMessage());
        }finally {
            try {
                if(emailFolder != null){
                    emailFolder.close(false);
                }
                if(store != null){
                        store.close();
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Result<List<EmailMessageVO>> mailList(String uid) {
        Result<List<EmailMessageVO>> result = null;
        try{
            List<EmailMessageVO> emailMessageVOList = new ArrayList<>();
            Result<EmailMessageVO> emailMessageVOResult = null;
            for(EmailLabelEnum emailLabelEnum : EmailLabelEnum.values()){
                emailMessageVOResult = this.mailList(emailLabelEnum,uid);
                if(emailMessageVOResult.getCode() == 0){
                    emailMessageVOList.add(emailMessageVOResult.getData());
                }
            }
            result = Result.success(emailMessageVOList);
        }catch (Exception exception){
            logger.error(String.format(" fetch  email fail  msg:[ %s ]",exception.getMessage()));
            result = Result.failure(exception.getMessage());
        }
        return  result;
    }


}

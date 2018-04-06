package com.loonxi.mail.api;

import com.loonxi.mail.api.inter.MailClientInter;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailStatusEnum;
import com.loonxi.mail.entity.EmailMessageVO;
import com.loonxi.mail.entity.UserAuthentication;
import com.onloon.scrm.common.beans.Result;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.Flags;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件操作客户端类
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 5/1/17
 * @since 1.0
 */

public class MailClientApi  implements MailClientInter {

    private UserAuthentication userAuthentication;
    private EmailEnum emailEnum;

    //发送邮件实体对象
    private MailSenderApi mailSenderApi;
    //邮件检查对象
    private MailOtherApi mailCheckApi;
    //邮件收取对象
    private MailReceiveApi mailReceiveApi;


    public MailClientApi(UserAuthentication userAuthentication, EmailEnum emailEnum ){
        this.userAuthentication = userAuthentication;
        this.emailEnum = emailEnum;
        mailSenderApi = new MailSenderApi(userAuthentication,emailEnum);
        mailCheckApi = new MailOtherApi(userAuthentication,emailEnum);
        mailReceiveApi = new MailReceiveApi(userAuthentication,emailEnum);

    }

    @Override
    public Result checkAuth() {
        return mailCheckApi.checkAuth();
    }

    @Override
    public Result sendSimple(SimpleMailMessage simpleMailMessage) {
        return mailSenderApi.sendSimple(simpleMailMessage);
    }

    @Override
    public Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage, File[] files) {
        return mailSenderApi.sendAttachmentsMail(simpleMailMessage,files);
    }

    @Override
    public Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage, File file) {
        return this.sendAttachmentsMail(simpleMailMessage,new File[]{file});
    }

    @Override
    public Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage, ArrayList<File> files) {
        return this.sendAttachmentsMail(simpleMailMessage,(File [])files.toArray());
    }

    @Override
    public Result<EmailMessageVO> mailList(EmailLabelEnum labelEnum,String uid) {
      return mailReceiveApi.mailList(labelEnum,uid);
    }

    @Override
    public Result<List<EmailMessageVO>> mailList(String uid) {
        return mailReceiveApi.mailList(uid);
    }

    @Override
    public Result replyMail(String messageId,String text,EmailLabelEnum emailLabelEnum) {
        return mailSenderApi.replyEmail(messageId,text,emailLabelEnum);
    }

    @Override
    public Result fowardMail(String messageId,String []  to,String text,EmailLabelEnum emailLabelEnum) {
        return mailSenderApi.fowardMail(messageId,to,text,emailLabelEnum);
    }

    @Override
    public Result deleteMail(String messageId, EmailLabelEnum emailLabelEnum) {
        return mailCheckApi.deleteMail(messageId,emailLabelEnum);
    }

    @Override
    public Result changeMail(String messageId, EmailLabelEnum emailLabelEnum, EmailStatusEnum emailStatusEnum) {
        Flags.Flag flag = null;
        if(EmailStatusEnum.UNREAD.getCode().equals(emailStatusEnum.getCode())){
            flag = Flags.Flag.RECENT;
        }
        if(EmailStatusEnum.READ.getCode().equals(emailStatusEnum.getCode())){
            flag = Flags.Flag.SEEN;
        }
        if(EmailStatusEnum.DELETE.getCode().equals(emailStatusEnum.getCode())){
            flag = Flags.Flag.DELETED;
        }
        return mailCheckApi.changeMail(messageId,emailLabelEnum,flag);
    }

    @Override
    public Result moveEmail(EmailLabelEnum sourceEnum, EmailLabelEnum targetEnum, String[] uid) {
        return mailCheckApi.moveEmail(sourceEnum,targetEnum,uid);
    }

    @Override
    public Result mailIsExists(String messageId, EmailLabelEnum emailLabelEnum) {
        return this.mailCheckApi.mailIsExists(messageId,emailLabelEnum);
    }


}

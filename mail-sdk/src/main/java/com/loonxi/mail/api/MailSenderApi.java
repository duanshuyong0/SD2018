package com.loonxi.mail.api;

import com.loonxi.mail.api.inter.MailAbstractApi;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailProtocolEnum;
import com.loonxi.mail.entity.UserAuthentication;
import com.loonxi.mail.util.MailConvetor;
import com.loonxi.mail.util.MailParser;
import com.onloon.scrm.common.beans.Result;
import com.onloon.scrm.common.utils.DateUtil;
import com.onloon.scrm.common.utils.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.*;

/**
 * 邮件发送api接口
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public class MailSenderApi extends MailAbstractApi {


    protected MailSenderApi(UserAuthentication userAuthentication, EmailEnum emailEnum){
        super(userAuthentication,emailEnum);
    }

    /**
     * 发送简单邮件
     * @param simpleMailMessage
     * @return
     */
    public Result sendSimple(SimpleMailMessage simpleMailMessage) {
        Result<String> result = null;
        try{
            if(!checkMessage(simpleMailMessage)){  //校验发件人或收件人是否为空
                return Result.failure("发件人不能为空并且收件人，抄送人，密送至少有一个不能为空");
            }
            JavaMailSenderImpl mailSender = this.generateSender();
            mailSender.send(simpleMailMessage);
            result = Result.success();
        }catch (MailException exception){
            logger.error(String.format(" send simple email params:[ %s ],msg:[ %s ]", JsonUtil.toJsonString(simpleMailMessage),exception.getMessage()));
            result = Result.failure(exception.getMessage());
        }
        return result;
    }

    /**
     * 发送带附件的邮件
     * @param simpleMailMessage
     * @param files
     * @return
     */
    public Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage, File[] files) {
        Result<String> result = null;
        try{
            if(!checkMessage(simpleMailMessage)){  //校验发件人为空或收件人，抄送人，密送都为空
                return Result.failure("收件人不能为空，收件人，抄送人，密送人请选填一个");
            }
            JavaMailSenderImpl mailSender = this.generateSender();
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            //将simpleMessage的值传递到helper
            MailConvetor.simpleMessage2Helper(helper,simpleMailMessage);
            //绑定附件
            for(File file : files){
                FileSystemResource fileSystemResource = new FileSystemResource(file);
                helper.addAttachment(file.getName(), fileSystemResource);
            }
            mailSender.send(mimeMessage);
            result = Result.success();
        }catch (MailException exception){
            logger.error(String.format(" send attach email fail  params:[ %s ],msg:[ %s ]", JsonUtil.toJsonString(simpleMailMessage),exception.getMessage()));
            result = Result.failure(exception.getMessage());
        }catch(MessagingException exception){
            logger.error(String.format(" send attach email simpleMessage2Helper fail  params:[ %s ],msg:[ %s ]", JsonUtil.toJsonString(simpleMailMessage),exception.getMessage()));
            result = Result.failure(exception.getMessage());
        }
        return result;
    }


    /**
     * 回复邮件
     * @param messageId 邮件唯一标示
     * @param text 本次回复内容
     * @param emailLabelEnum  邮件位置
     * @return
     */
    public Result replyEmail(String messageId,String text, EmailLabelEnum emailLabelEnum){
        Result<String> result = null;
        try{
            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.IMAP);
            //获取session
            Session emailSession = Session.getDefaultInstance(properties);
            //查询出message
            Message message = this.findMessage(messageId,emailLabelEnum,emailSession);
            //message解析
            MailParser mailParser = MailConvetor.messageToMailParser(message);

            //组装回复邮件
            String to =InternetAddress.toString(message.getRecipients(Message.RecipientType.TO));
            Message replyMessage = new MimeMessage(emailSession);
            replyMessage = (MimeMessage) message.reply(false);
            replyMessage.setFrom(new InternetAddress(this.userName));
            replyMessage.setContent(text +"<br/><br/><br/>"+ DateUtil.format(mailParser.getSentDate(),"yyyy年MM月dd日 HH:mm:ss")+","+ userName + " 写到<br>>"+mailParser.getBodyText(),"text/html;charset=utf-8");
            replyMessage.setReplyTo(message.getReplyTo());

            //发送邮件
            JavaMailSenderImpl mailSender = this.generateSender();
            mailSender.send((MimeMessage)replyMessage);
            result = Result.success();
        }catch (Exception exception){
            logger.error(" reply mail error msg{}",exception.getMessage());
            result = Result.failure(exception.getMessage());
        }finally {

        }
        return result;
    }


    public Result fowardMail(String messageId,String []  to,String text,EmailLabelEnum emailLabelEnum){
        Result<String> result = null;

        try{
            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.OTHER);

            //获取session
            Session emailSession = Session.getDefaultInstance(properties);
            //查询出message
            Message message = this.findMessage(messageId,emailLabelEnum,emailSession);

            MailParser mailParser = MailConvetor.messageToMailParser(message);

            // 创建转发邮件信息
            Message forward = new MimeMessage(emailSession);
            // 设置主题
            forward.setSubject("Fwd: " + message.getSubject());
            forward.setFrom(new InternetAddress(this.userName));

            Address [] internetAddresses = new InternetAddress[to.length];

            for(int i = 0 ; i< to.length ;i++){
                internetAddresses[i] = new InternetAddress(to[i]);
            }
            forward.addRecipients(Message.RecipientType.TO,internetAddresses);

            /**
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Here you go with the original message:/n/n");

            // Create a multi-part to combine the parts

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Create and fill part for the forwarded content
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(message.getDataHandler());
            // Add part to multi part
            multipart.addBodyPart(messageBodyPart);
            // Associate multi-part with message
            forward.setContent(multipart,"haha");

            //forward.setContent((Multipart)message.getContent());

**/
            String replyContent = text;
            //BodyPart messageBodyPart = new MimeBodyPart();
            //messageBodyPart.setText(replyContent);// 邮件正文部分
            Multipart mp = new MimeMultipart();

            Multipart multipart = null;

            if(mailParser.isContainAttach((MimeMessage)message)){
                multipart = (Multipart) message.getContent();

            }
            BodyPart messageBodyPart  = new MimeBodyPart();
            // 判断是否有附件，并对附件进行处理转发
            if (message.isMimeType("multipart/mixed")) {
                String htmlString2 = "<meta http-equiv=Content-Type content=text/html; charset=utf-8>"
                        + replyContent
                        + "<br/><br/>------------------ 原始邮件  ------------------<br/><br/><br/><br/><br/><br/><br/>";

                messageBodyPart.setContent(htmlString2,"text/html;charset=utf-8");
                mp.addBodyPart(messageBodyPart);

                for (int i = 0; i < multipart.getCount(); i++) {
                    messageBodyPart  = new MimeBodyPart();
                    BodyPart bodypart = multipart.getBodyPart(i);
                    // 如果该BodyPart对象包含附件，则应该解析出来
                        if (bodypart.getDisposition() != null && bodypart.getDisposition().equals(Part.ATTACHMENT)) {
                            continue;
                        }else if(bodypart.getDisposition() != null && bodypart.getDisposition().equals(Part.INLINE)){
                            DataHandler dataSource = bodypart.getDataHandler();
                            messageBodyPart.setDataHandler(dataSource);
                            mp.addBodyPart(messageBodyPart);
                        }  else{

                            mp.addBodyPart(bodypart);
                        }
                }

                forward.setContent(mp);
            } else {
                // 非"multipart/mixed"部分的处理

                MimeBodyPart mbp = new MimeBodyPart();

                String htmlString = "<meta http-equiv=Content-Type content=text/html; charset=utf-8>"
                        + replyContent
                        + "<br/><br/>------------------ 原始邮件  ------------------<br/><br/><br/><br/>"
                        + mailParser.getBodyHtml();
                mbp.setContent(htmlString, "text/html;charset=utf-8");

                mp.addBodyPart(mbp);
                forward.setContent(mp);
            }


            //发送邮件
            //JavaMailSenderImpl mailSender = this.generateSender();
            //mailSender.send((MimeMessage)forward);
            Transport t = emailSession.getTransport("smtp");
            t.connect(userName, passWord);
            t.sendMessage(forward,forward.getAllRecipients());
            result = Result.success();
        }catch (Exception e){
            logger.error(" foward email error msg{}",e.getMessage());
            result = Result.failure(e.getMessage());
        }
        return result;
    }



    private  boolean checkMessage(SimpleMailMessage simpleMailMessage){

        if(StringUtils.isEmpty(simpleMailMessage.getFrom()) ){ //发件人为空
            return false;
        }
        if((simpleMailMessage.getTo() != null && simpleMailMessage.getTo().length != 0 )  ||  (simpleMailMessage.getCc() != null && simpleMailMessage.getCc().length != 0 )  || (simpleMailMessage.getBcc() != null && simpleMailMessage.getBcc().length != 0 )  ){ //收件人，密送，抄送都为空时
            return true;
        }else{
            return false;
        }

    }

}

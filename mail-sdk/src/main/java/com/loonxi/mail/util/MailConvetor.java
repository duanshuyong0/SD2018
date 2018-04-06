package com.loonxi.mail.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeMessage;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 5/1/17
 * @since 1.0
 */

public class MailConvetor {

    public static void simpleMessage2Helper(MimeMessageHelper mimeMessageHelper,SimpleMailMessage simpleMailMessage) throws MessagingException{
        mimeMessageHelper.setFrom(simpleMailMessage.getFrom());
        mimeMessageHelper.setTo(simpleMailMessage.getTo());
        if(simpleMailMessage.getSubject() != null) {
            mimeMessageHelper.setSubject(simpleMailMessage.getSubject());
        }
        if(simpleMailMessage.getText() != null) {
            mimeMessageHelper.setText(simpleMailMessage.getText());
        }
        if(simpleMailMessage.getBcc() != null) {
            mimeMessageHelper.setBcc(simpleMailMessage.getBcc());
        }
        if(simpleMailMessage.getReplyTo() != null) {
            mimeMessageHelper.setReplyTo(simpleMailMessage.getReplyTo());
        }
        if(simpleMailMessage.getCc() != null) {
            mimeMessageHelper.setCc(simpleMailMessage.getCc());
        }
    }


    public static MailParser messageToMailParser(Message message){

        MailParser mailParser = new MailParser((MimeMessage)message);
        try{
            mailParser.getMailContent((Part) message);
            mailParser.saveAttachMent(message);
        }catch (Exception e){
        }
        return mailParser;
    }
}

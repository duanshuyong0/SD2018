package com.loonxi.mail.api.inter;

import com.loonxi.mail.api.MailClientApi;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailProperties;
import com.loonxi.mail.constant.EmailProtocolEnum;
import com.loonxi.mail.entity.UserAuthentication;
import com.onloon.scrm.common.beans.Result;
import com.onloon.scrm.common.utils.JsonUtil;
import com.sun.mail.imap.IMAPFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.*;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public abstract class MailAbstractApi {

    protected Logger logger = LoggerFactory.getLogger(MailClientApi.class);
    protected String userName;
    protected String passWord;
    protected Map<String,String> emailProperties;
    protected Properties menuProperties;
    protected MailAbstractApi(UserAuthentication userAuthentication, EmailEnum emailEnum ) {
        this.userName = userAuthentication.getUserName();
        this.passWord = userAuthentication.getPassWord();
        this.emailProperties = EmailProperties.emailProperties.get(emailEnum.getDesc());
        this.menuProperties = emailEnum.getMenuProperties();

    }

    /**
     * 校验权限
     * @return
     */
    public Result checkAuth() {
        Result<String> result = null;
        Store store = null;
        try {
            logger.info(" email username{}, password{},properties{}",userName,passWord, JsonUtil.toJsonString(emailProperties));
            //获取发送邮件配置配置信息
            Properties props = this.generateProperties(EmailProtocolEnum.IMAP);
            // Get the Session object.
            Session session = Session.getInstance(props);
            session.setDebug(true);
            store = session.getStore();
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            result = Result.success();
        }catch(Exception ex){
            logger.error(String.format(" email auth check param [ username: %s : password: %s properties: %s ] msg %s",userName,passWord,emailProperties.toString(),ex.getMessage()));
            result = Result.failure(ex.getMessage());
        }finally {
            if(store != null){
                try {
                    store.close();
                } catch (MessagingException ex) {
                    logger.error(String.format(" email store close fail  %s",ex.getMessage()));
                    result = Result.failure(ex.getMessage());
                }
            }
        }

        return result;
    }

    /**
     * 根据messageId获取message信息
     * @param messageId
     * @param emailLabelEnum
     * @param emailSession
     * @return
     */
    protected  Message findMessage(String messageId, EmailLabelEnum emailLabelEnum, Session emailSession){
        Store store = null;
        Folder emailFolder = null;
        Message message = null;
        try{

            //create the IMAP store object and connect with the pop server
            store = emailSession.getStore("imap");
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            emailFolder = store.getFolder(emailLabelEnum.getDesc() );
            emailFolder.open(Folder.READ_WRITE);
            Message[] messages = emailFolder.getMessages();
            List<Message> messageList = Arrays.asList(messages);
            Map<String, MimeMessage> messageMap = new HashMap<>();

            IMAPFolder imapFolder = (IMAPFolder)emailFolder;

            for(Message messageTmp : messageList){
                MimeMessage mimeMessage = (MimeMessage)messageTmp;
                messageMap.put(Long.toString(imapFolder.getUID(mimeMessage)),mimeMessage);
            }
            message = messageMap.get(messageId);

        }catch (Exception e){
            logger.error("根据 messageId 查询出错 msgId{},msg{}",messageId,e.getMessage());
        }
        return message;
    }

    /**
     * 返回文件夹邮件 Map
     * @param emailLabelEnum
     * @param emailSession
     * @return
     */
    protected  Map<String,MimeMessage> findMessage(EmailLabelEnum emailLabelEnum, Session emailSession){
        Store store = null;
        Folder emailFolder = null;
        Message message = null;
        Map<String, MimeMessage> messageMap = new HashMap<>();
        try{
            //create the IMAP store object and connect with the pop server
            store = emailSession.getStore("imap");
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            emailFolder = store.getFolder((String)this.menuProperties.get(emailLabelEnum.getDesc() ));
            emailFolder.open(Folder.READ_ONLY);
            messageMap = this.findMessageMap(emailFolder);
        }catch (Exception e){
            logger.error("根据 messageId 查询出错 msg{}",e.getMessage());
        }
        return messageMap;
    }

    /**
     * 根据文件夹生成邮件映射关系 key:id  value : mimeMessage
     * @param emailFolder
     * @return
     */
    protected  Map<String,MimeMessage>  findMessageMap(Folder emailFolder){
        Map<String, MimeMessage> messageMap = new HashMap<>();
        try {
            Message[] messages = emailFolder.getMessages();
            List<Message> messageList = Arrays.asList(messages);
            IMAPFolder imapFolder = (IMAPFolder)emailFolder;
            for(Message messageTmp : messageList){
                MimeMessage mimeMessage = (MimeMessage)messageTmp;
                messageMap.put(Long.toString(imapFolder.getUID(mimeMessage)),mimeMessage);
            }
        } catch (MessagingException e) {
          logger.error(" 根据文件夹生成邮件信息映射失败 msg{}",e.getMessage());
        }
       return messageMap;
    }

    /**
     * 生成邮件发送器
     * @return
     */
    protected JavaMailSenderImpl generateSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties properties = this.generateProperties(EmailProtocolEnum.SMTP);
        mailSender.setJavaMailProperties(properties);
        mailSender.setHost(emailProperties.get("smtp_host"));
        mailSender.setUsername(userName);
        mailSender.setPassword(passWord);
        mailSender.setProtocol("smtp");
        mailSender.setDefaultEncoding("UTF-8");

        return mailSender;
    }

    /**
     * 组装本次邮件服务配置信息
     * @param emailProtocolEnum
     * @return
     */
    protected Properties generateProperties(EmailProtocolEnum emailProtocolEnum){

        Properties props = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        if(EmailProtocolEnum.SMTP.getCode().equals(emailProtocolEnum.getCode())){
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", emailProperties.get("smtp_port"));

            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.host", emailProperties.get("smtp_host"));
            props.put("mail.smtp.port", emailProperties.get("smtp_port"));

        }else if(EmailProtocolEnum.IMAP.getCode().equals(emailProtocolEnum.getCode())){

            props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.imap.socketFactory.fallback", "false");
            props.setProperty("mail.imap.socketFactory.port", emailProperties.get("imap_port"));
            props.put("mail.imap.starttls.enable", "true");
            props.put("mail.imap.host", emailProperties.get("imap_host"));
            props.put("mail.imap.port", emailProperties.get("imap_port"));
            props.put("mail.store.protocol", "imap");
        }else{
            props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.imap.socketFactory.fallback", "false");
            props.setProperty("mail.imap.socketFactory.port", emailProperties.get("imap_port"));
            props.put("mail.imap.host", emailProperties.get("imap_host"));
            props.put("mail.imap.port", emailProperties.get("imap_port"));
            props.put("mail.imap.starttls.enable","true");
            props.put("mail.store.protocol", "imap");

            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", emailProperties.get("smtp_port"));
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.host", emailProperties.get("smtp_host"));
            props.put("mail.smtp.port", emailProperties.get("smtp_port"));
            props.put("mail.smtp.starttls.enable","true");

        }
        return props;
    }



}

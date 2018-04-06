package com.loonxi.mail.api;

import com.loonxi.mail.api.inter.MailAbstractApi;
import com.loonxi.mail.constant.EmailEnum;
import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailProtocolEnum;
import com.loonxi.mail.entity.UserAuthentication;
import com.onloon.scrm.common.beans.Result;
import com.sun.mail.imap.IMAPFolder;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public class MailOtherApi extends MailAbstractApi {

    protected MailOtherApi(UserAuthentication userAuthentication, EmailEnum emailEnum){
        super(userAuthentication,emailEnum);
    }

    /**
     * 权限检查
     * @return
     */
    public Result checkAuth(){
        return super.checkAuth();
    }

    /**
     * 删除邮件
     * @param uid  邮件ID
     * @param labelEnum  类型
     * @return
     */
    public Result deleteMail(String uid,EmailLabelEnum labelEnum){
        Result<String> result = null;
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
            emailFolder.open(Folder.READ_WRITE);
            //根据UID找到对应的邮件信息
            Map<String,MimeMessage> messageMap = this.findMessageMap(emailFolder);
            MimeMessage message = messageMap.get(uid);
            if(message == null){
              throw  new Exception(" uid : "+uid +" 不存在");
            }
            message.setFlag(Flags.Flag.DELETED, true);
            result = Result.success();
        }catch (Exception e){
            logger.error(" delete mail error msg{}",e.getMessage());
            result = Result.failure(e.getMessage());
        }finally {
            try {
                emailFolder.close(true);
                store.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
        return result;
    }



        /**
         * 邮件移动
         * @param sourceEnum 原文件夹
         * @param targetEnum
         * @param uid
         * @return
         */
    public Result moveEmail(EmailLabelEnum sourceEnum,EmailLabelEnum targetEnum,String [] uid){
        Result result = null;
        Store store = null;
        IMAPFolder sourceFolder = null;
        IMAPFolder targetFolder = null;
        try{
            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.IMAP);
            //获取session
            Session emailSession = Session.getDefaultInstance(properties);
            store = emailSession.getStore("imap");
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            //获取源文件夹和目标文件夹
            sourceFolder = (IMAPFolder)store.getFolder((String)this.menuProperties.get(sourceEnum.getDesc()));
            targetFolder = (IMAPFolder)store.getFolder((String)this.menuProperties.get(targetEnum.getDesc()));
            //打开文件夹
            sourceFolder.open(Folder.READ_WRITE);
            targetFolder.open(Folder.READ_WRITE);
            //根据UID找到对应的邮件信息
            Map<String,MimeMessage> messageMap = this.findMessageMap(sourceFolder);
            MimeMessage [] copyMessages = null;
            //找到uid对应的邮件信息
            for(int i = 0 ; i<uid.length ; i++){
                MimeMessage message = messageMap.get(uid[i]);
                if(message == null){
                    throw new Exception("uid : "+uid[i] +" 不存在");
                }
                copyMessages = new MimeMessage[1];
                copyMessages[0]= message;
                //移动邮件
                sourceFolder.copyMessages(copyMessages,targetFolder);
                //从源文件夹删除该邮件
                message.setFlag(Flags.Flag.DELETED, true);
            }
            result = Result.success();
        }catch (Exception e){
            logger.error(" 邮件移动出错 msg{}",e.getMessage());
            result = Result.failure(e.getMessage());
        }finally {
            try {
                if(targetFolder != null){
                    targetFolder.close(true);
                }
                if(sourceFolder != null){
                    sourceFolder.close(true);
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

    /**
     * 检查邮件是否存在
     * @param messageId
     * @param emailLabelEnum
     * @return
     */
    Result mailIsExists(String messageId,EmailLabelEnum emailLabelEnum){
        Result<String> result = null;
        try{

            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.IMAP);
            //获取session
            Session emailSession = Session.getDefaultInstance(properties);
            //查询出message
            Message message = this.findMessage(messageId,emailLabelEnum,emailSession);
            if(message == null){
                result = Result.failure("邮件不存在");
            }else{
                result = Result.success();
            }
        }catch (Exception e){
            logger.error("校验邮件出错 message:{}",e.getMessage());
            result = Result.failure(e.getMessage());
        }

        return result;
    }

    /**
     * 把邮件标为已读
     * @param uid
     * @return
     */
    public Result changeMail(String uid,EmailLabelEnum emailLabelEnum,Flags.Flag flag){
        Result<String> result = null;
        Store store = null;
        Folder emailFolder = null;
        try{
            //获取邮箱收件配置信息
            Properties properties = this.generateProperties(EmailProtocolEnum.IMAP);
            //获取session
            Session emailSession = Session.getDefaultInstance(properties);

            store = emailSession.getStore("imap");
            store.connect(emailProperties.get("imap_host"),userName,passWord);
            //获取floder对象并打开它
            emailFolder = store.getFolder((String)this.menuProperties.get(emailLabelEnum.getDesc()));
            //以只读方式打开
            emailFolder.open(Folder.READ_WRITE);
            //根据UID找到对应的邮件信息
            Map<String,MimeMessage> messageMap = this.findMessageMap(emailFolder);
            MimeMessage message = messageMap.get(uid);
            if(message == null){
                throw  new Exception(" uid : "+uid +" 不存在");

            }
            message.setFlag(flag,true);
            result = Result.success();
        }catch (Exception e){
            logger.error(" update mail error msg{}",e.getMessage());
            result = Result.failure(e.getMessage());
        }finally {
            try {
                emailFolder.close(true);
                store.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}

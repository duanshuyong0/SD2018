package com.loonxi.mail.api.inter;

import com.loonxi.mail.constant.EmailLabelEnum;
import com.loonxi.mail.constant.EmailStatusEnum;
import com.loonxi.mail.entity.EmailMessageVO;
import com.onloon.scrm.common.beans.Result;
import org.springframework.mail.SimpleMailMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 4/1/17
 * @since 1.0
 */
public interface MailClientInter {

    /**
     * 邮箱用户名和密码校验
     * @return
     */
    Result checkAuth();

    /**
     * 发送简单邮件
     * @param simpleMailMessage
     * @return
     */
    Result sendSimple(SimpleMailMessage simpleMailMessage);

    /**
     * 带多附件的邮件
     * @param simpleMailMessage
     * @param files
     * @return
     */
    Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage,File[] files);

    /**
     * 带多附件的邮件
     * @param simpleMailMessage
     * @param file
     * @return
     */
    Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage,File file);

    /**
     * 带附件的邮件
     * @param simpleMailMessage
     * @param files
     * @return
     */
    Result sendAttachmentsMail(SimpleMailMessage simpleMailMessage,ArrayList<File> files);


    /**
     * 查询指定类型邮件列表
     * @param labelEnum
     * @return
     */
    Result<EmailMessageVO> mailList(EmailLabelEnum labelEnum,String uid);

    /**
     * 查询所有类型邮件列表
     * @return
     */
    Result<List<EmailMessageVO>> mailList(String uid);

    /**
     * 回复邮件
     * @return
     */
    Result replyMail(String messageId,String text,EmailLabelEnum emailLabelEnum);

    /**
     * 转发邮件
     * @return
     */
    Result fowardMail(String messageId,String []  to,String text,EmailLabelEnum emailLabelEnum);

    /**
     * 删除邮件(彻底删除，无法还原)
     * @param messageId
     * @param emailLabelEnum
     * @return
     */
    Result deleteMail(String messageId,EmailLabelEnum emailLabelEnum);


    /**
     * 更改邮件状态
     * @param messageId
     * @param emailLabelEnum
     * @return
     */
    Result changeMail(String messageId, EmailLabelEnum emailLabelEnum, EmailStatusEnum emailStatusEnum);

    /**
     * 移动邮件
     * @param sourceEnum
     * @param targetEnum
     * @param uid
     * @return
     */
    Result moveEmail(EmailLabelEnum sourceEnum,EmailLabelEnum targetEnum,String [] uid);

    /**
     * 检查邮件是否还在当前文件夹
     * @param messageId
     * @param emailLabelEnum
     * @return
     */
    Result mailIsExists(String messageId,EmailLabelEnum emailLabelEnum);
}

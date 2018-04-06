package com.loonxi.mail.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.mail.Multipart;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public class EmailMessage {

    private String messageId;

    private Integer messageNum;

    private String from; //发件人的地址和姓名

    private String  to; //收件人地址和行姓名

    private String  cc; //抄送人的地址和姓名

    private String bcc; //密送人的地址和姓名

    private String subject; //邮件主题

    private Date sendDate; //邮件发送日期

    private Date receiveDate; //邮件接收时间

    private String body;     //邮件正文内容

    private String bodyHtml; //邮件内容html格式

    private boolean hasReplySign; //是否需要回执 true - 需要 false - 不需要

    private boolean hasRed; //是否已读

    @JsonIgnore
    private Map<String,InputStream> attachMap;  //附件

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Map<String, InputStream> getAttachMap() {
        return attachMap;
    }

    public void setAttachMap(Map<String, InputStream> attachMap) {
        this.attachMap = attachMap;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isHasReplySign() {
        return hasReplySign;
    }

    public void setHasReplySign(boolean hasReplySign) {
        this.hasReplySign = hasReplySign;
    }

    public boolean isHasRed() {
        return hasRed;
    }

    public void setHasRed(boolean hasRed) {
        this.hasRed = hasRed;
    }
}

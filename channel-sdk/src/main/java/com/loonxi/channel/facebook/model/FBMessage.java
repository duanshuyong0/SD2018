package com.loonxi.channel.facebook.model;

import java.util.Date;
import java.util.List;

/**
 * Created by xyy on 2017/1/10.
 *
 * https://developers.facebook.com/docs/graph-api/reference/v2.8/message/
 */
public class FBMessage {
    private String id;
    private FBbaseProfile from;

    /**
     * 这个是有多个对象的，现在默认只一个
     */
    private FBbaseProfile to;

    /**
     * 消息内容
     */
    private String message;


    private Date createdTime;

    private List<FBAttachment> attachmentList;

    public List<FBAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<FBAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FBbaseProfile getFrom() {
        return from;
    }

    public void setFrom(FBbaseProfile from) {
        this.from = from;
    }

    public FBbaseProfile getTo() {
        return to;
    }

    public void setTo(FBbaseProfile to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


}


package com.loonxi.channel.facebook.model;

import java.util.Date;
import java.util.List;

/**
 * Created by xyy on 2017/1/10.
 */
public class FBConversation {
    private String id;
    /**
     * 会话中的两个人
     */
    private List<FBbaseProfile> senders;
    /**
     * 最后一次通话时间
     */
    private Date getUpdatedTime;

    /**
     * 消息
     */
    private FBPaging<FBMessage> messages;

    /**
     * 未读消息条数
     */
    private Integer unreadCount;

    /**
     * 总共消息条数
     */
    private Integer messageCount;

    private boolean canReply;

    public boolean isCanReply() {
        return canReply;
    }

    public void setCanReply(boolean canReply) {
        this.canReply = canReply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FBbaseProfile> getSenders() {
        return senders;
    }

    public void setSenders(List<FBbaseProfile> senders) {
        this.senders = senders;
    }

    public Date getGetUpdatedTime() {
        return getUpdatedTime;
    }

    public void setGetUpdatedTime(Date getUpdatedTime) {
        this.getUpdatedTime = getUpdatedTime;
    }

    public FBPaging<FBMessage> getMessages() {
        return messages;
    }

    public void setMessages(FBPaging<FBMessage> messages) {
        this.messages = messages;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }
}

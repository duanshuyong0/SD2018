package com.loonxi.mail.entity;

import javax.mail.Message;
import java.util.List;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public class EmailMessageVO  implements java.io.Serializable{

    private String type; //收件箱，垃圾邮件，发件箱 INBOX,TRASH,SEND
    private List<EmailMessage> emailMessageList;
    private Integer unreadCount;
    private Integer totalCount;

    public List<EmailMessage> getEmailMessageList() {
        return emailMessageList;
    }

    public void setEmailMessageList(List<EmailMessage> emailMessageList) {
        this.emailMessageList = emailMessageList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}

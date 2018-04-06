package com.loonxi.channel.facebook.model;

import java.util.Date;

/**
 * 包括 一些 node 的简单信息，例如POST, COMMENT
 * Created by xyy on 2017/1/7.
 */
public class FBbaseObject {

    private Date createdTime;

    private String id;

    private String message;

    public FBbaseObject(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

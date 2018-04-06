package com.loonxi.channel.facebook.model;


import java.util.Date;

/**
 * Created by xyy on 2017/1/7.
 */
public class FBNotification {
    private String id;

    private Date createdTime;

    /**
     *
     */
    private FBbaseProfile from;

    /**
     *
     */
    private FBbaseProfile to;

    /**
     * 操作的主题对象
     */
    private FBbaseObject fBbaseObject;

    /**
     * 操作对象的超链接
     */
    private String link;

    /**
     * 通知提示语
     */
    private String titile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public FBbaseObject getfBbaseObject() {
        return fBbaseObject;
    }

    public void setfBbaseObject(FBbaseObject fBbaseObject) {
        this.fBbaseObject = fBbaseObject;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

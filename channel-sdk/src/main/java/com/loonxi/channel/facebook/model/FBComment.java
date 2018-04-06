package com.loonxi.channel.facebook.model;

import java.util.Date;

/**
 * Created by xyy on 2017/1/5.
 */
public class FBComment {
    private String id;

    /**
     * 评论内容
     */
    private String message;

    /**
     * 创建者
     */
    private FBbaseProfile from;

    /**
     * 父评论
     */
    private FBComment parent;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 评论中的图片，最多带一张
     */
    private String photoUrl;

    private String vedioUrl;

    /**
     * 分页显示
     */
    private FBPaging<FBComment> replies;

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

    public FBbaseProfile getFrom() {
        return from;
    }

    public void setFrom(FBbaseProfile from) {
        this.from = from;
    }

    public FBComment getParent() {
        return parent;
    }

    public void setParent(FBComment parent) {
        this.parent = parent;
    }

    public FBPaging<FBComment> getReplies() {
        return replies;
    }

    public void setReplies(FBPaging<FBComment> replies) {
        this.replies = replies;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }
}

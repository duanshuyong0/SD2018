package com.loonxi.channel.facebook.model;

import java.util.Date;
import java.util.List;

/**
 * Created by xyy on 2017/1/5.
 */
public class FBPost {
    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * POST内容
     */
    private String message;

    /**
     * POST 中的图片地址
     */
    private List<String> photoUrls;

    /**
     * 视屏链接，指向 facebook的视屏地址，页面不需要还原facebook视屏播放效果
     */
    private List<String> vedioUrls;

    /**
     * 创建者
     */
    private FBbaseProfile from;

    /**
     * 引用的POST
     */
    private FBPost quotePost;

    /**
     * 评论列表, 最多显示200条，超过200条不显示
     */
    private FBPaging<FBComment> comments;

    public FBPost() {
    }

    public FBPost(String id) {
        this.id = id;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<String> getVedioUrls() {
        return vedioUrls;
    }

    public void setVedioUrls(List<String> vedioUrls) {
        this.vedioUrls = vedioUrls;
    }

    public FBbaseProfile getFrom() {
        return from;
    }

    public void setFrom(FBbaseProfile from) {
        this.from = from;
    }

    public FBPost getQuotePost() {
        return quotePost;
    }

    public void setQuotePost(FBPost quotePost) {
        this.quotePost = quotePost;
    }

    public FBPaging<FBComment> getComments() {
        return comments;
    }

    public void setComments(FBPaging<FBComment> comments) {
        this.comments = comments;
    }
}

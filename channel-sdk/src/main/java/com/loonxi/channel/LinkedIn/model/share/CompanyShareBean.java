package com.loonxi.channel.LinkedIn.model.share;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 查询LinkedIn企业分享返回信息
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class CompanyShareBean {

    private boolean isCommentable;
    private boolean isLikable;
    private boolean isLiked;
    private Integer numLikes;
    private Long timestamp;
    private String updateKey; //本次分享key
    private String updateType;
    private CompanyShareLikesList likes; //点赞集合
    private CompanyShareCommentList updateComments; //评论集合
    private UpdateContent updateContent;


    public boolean getIsCommentable() {
        return isCommentable;
    }

    public void setCommentable(boolean commentable) {
        isCommentable = commentable;
    }

    public boolean getIsLikable() {
        return isLikable;
    }

    public void setLikable(boolean likable) {
        isLikable = likable;
    }

    public boolean getIsLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public CompanyShareLikesList getLikes() {
        return likes;
    }

    public void setLikes(CompanyShareLikesList likes) {
        this.likes = likes;
    }

    public CompanyShareCommentList getUpdateComments() {
        return updateComments;
    }

    public void setUpdateComments(CompanyShareCommentList updateComments) {
        this.updateComments = updateComments;
    }

    public UpdateContent getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(UpdateContent updateContent) {
        this.updateContent = updateContent;
    }




}

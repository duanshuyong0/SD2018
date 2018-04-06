package com.dsy.dadui.sdk.entity.user;

import java.util.Date;

public class UserWechatAdd {
    private Integer id;

    private String userId;

    private Integer byUserId;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    private Byte deleteTag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getByUserId() {
        return byUserId;
    }

    public void setByUserId(Integer byUserId) {
        this.byUserId = byUserId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Byte deleteTag) {
        this.deleteTag = deleteTag;
    }
}
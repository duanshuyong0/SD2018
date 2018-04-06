package com.dsy.dadui.sdk.entity.user;

import java.util.Date;

public class UserSugarAdd {
    private Integer id;

    private String userId;

    private String openid;

    private Integer sugarNum;

    private String wechatAccount;

    private Integer amount;

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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getSugarNum() {
        return sugarNum;
    }

    public void setSugarNum(Integer sugarNum) {
        this.sugarNum = sugarNum;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount == null ? null : wechatAccount.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
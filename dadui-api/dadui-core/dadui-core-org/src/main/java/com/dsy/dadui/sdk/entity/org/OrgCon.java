package com.dsy.dadui.sdk.entity.org;

import java.util.Date;

public class OrgCon {
    private Integer id;

    private Integer orgId;

    private Byte status;

    private String createUserId;

    private String createUserOpenid;

    private Date createTime;

    private Date updateTime;

    private Byte deleteTag;

    private String con;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateUserOpenid() {
        return createUserOpenid;
    }

    public void setCreateUserOpenid(String createUserOpenid) {
        this.createUserOpenid = createUserOpenid == null ? null : createUserOpenid.trim();
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

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con == null ? null : con.trim();
    }
}
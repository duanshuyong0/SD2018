package com.dsy.dadui.sdk.entity.org;

import java.io.Serializable;
import java.util.Date;

public class Org implements Serializable{
    private Integer id;

    private String name;

    private Byte status;

    private String imgPath;

    private Integer createUserId;

    private String createUserOpenid;

    private String createUserIntro;

    private Date createTime;

    private Date updateTime;

    private Byte deleteTag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserOpenid() {
        return createUserOpenid;
    }

    public void setCreateUserOpenid(String createUserOpenid) {
        this.createUserOpenid = createUserOpenid == null ? null : createUserOpenid.trim();
    }

    public String getCreateUserIntro() {
        return createUserIntro;
    }

    public void setCreateUserIntro(String createUserIntro) {
        this.createUserIntro = createUserIntro == null ? null : createUserIntro.trim();
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
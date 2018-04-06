package com.dsy.dadui.sdk.entity.user;

import java.util.Date;

public class User {
    private String id;

    private String username;

    private String password;

    private String name;

    private Byte isAlone;

    private String openid;

    private String wechat;

    private String nickname;

    private Byte gender;

    private String avatarUrl;

    private String city;

    private String provience;

    private String country;

    private Byte status;

    private Date regTime;

    private Date createTime;

    private Date updateTime;

    private Byte deleteTag;
    
    private int firstEdit;
    
	private int secondEdit;

	
    public int getSecondEdit() {
		return secondEdit;
	}

	public void setSecondEdit(int secondEdit) {
		this.secondEdit = secondEdit;
	}

    public int getFirstEdit() {
		return firstEdit;
	}

	public void setFirstEdit(int firstEdit) {
		this.firstEdit = firstEdit;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getIsAlone() {
        return isAlone;
    }

    public void setIsAlone(Byte isAlone) {
        this.isAlone = isAlone;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience == null ? null : provience.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
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
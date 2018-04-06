package com.dsy.dadui.sdk.entity.user;

import java.util.Date;

public class UserExtend {
    private Integer id;

    private String userId;

    private String openid;

    private Date birthdayTime;

    private Integer height;

    private String profession;

    private Byte isHouse;

    private Byte isCar;

    private String introduce;

    private Date createTime;

    private Date updateTime;

    private Byte deleteTag;
    
    private String income;
    
    private String require;
    
	private String degree;
	
    private String weChatNum;
    

    public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getIncome() {
		return income;
	}
	
    public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getWeChatNum() {
		return weChatNum;
	}

	public void setWeChatNum(String weChatNum) {
		this.weChatNum = weChatNum;
	}
	

	public void setIncome(String income) {
		this.income = income;
	}

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

    public Date getBirthdayTime() {
        return birthdayTime;
    }

    public void setBirthdayTime(Date birthdayTime) {
        this.birthdayTime = birthdayTime;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Byte getIsHouse() {
        return isHouse;
    }

    public void setIsHouse(Byte isHouse) {
        this.isHouse = isHouse;
    }

    public Byte getIsCar() {
        return isCar;
    }

    public void setIsCar(Byte isCar) {
        this.isCar = isCar;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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
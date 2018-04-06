package com.dsy.dadui.pc.web.vo.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dsy.dadui.common.beans.Entity;
import com.dsy.dadui.sdk.entity.org.Org;


public class UserVO extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String openId;

	private List<Org> org;
	
	private String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public List<Org> getOrg() {
		return org;
	}

	public void setOrg(List<Org> org) {
		this.org = org;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

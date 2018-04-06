package com.loonxi.channel.facebook.model;

import java.io.Serializable;

/**
 * Facebook主页.
 * 
 * @author 许远�?
 *
 */
public class Homepage implements Serializable{

	/**
	 * 主页ID
	 */
	private String homepageId;

	/**
	 * 主页名称
	 */
	private String name;

	/**
	 * 用户头像
	 */
	private String avatar;

	private String pageToken;

	public String getHomepageId() {
		return homepageId;
	}

	public void setHomepageId(String homepageId) {
		this.homepageId = homepageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPageToken() {
		return pageToken;
	}

	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}
}

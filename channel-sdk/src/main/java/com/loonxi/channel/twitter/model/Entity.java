package com.loonxi.channel.twitter.model;

import java.util.List;

/**
 * status 推文中的一个模块.
 *
 * @author xyy
 * @Date 2016/12/27
 */
public class Entity {
	/** 推文中的超链接 */
	private List<URLEntity> urls;

	/** 推文中的图片链接 */
	private List<MediaEntity> mediaEntity;

	/** metionsUser */
	private List<MessageUser> messageUsers;

	public List<URLEntity> getUrls() {
		return urls;
	}

	public void setUrls(List<URLEntity> urls) {
		this.urls = urls;
	}

	public List<MessageUser> getMessageUsers() {
		return messageUsers;
	}

	public void setMessageUsers(List<MessageUser> messageUsers) {
		this.messageUsers = messageUsers;
	}

	public List<MediaEntity> getMediaEntity() {
		return mediaEntity;
	}

	public void setMediaEntity(List<MediaEntity> mediaEntity) {
		this.mediaEntity = mediaEntity;
	}

}

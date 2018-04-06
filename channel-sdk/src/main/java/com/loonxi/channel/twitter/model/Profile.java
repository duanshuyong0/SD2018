package com.loonxi.channel.twitter.model;

import java.util.List;

/**
 * 账户简介
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 */
public class Profile {
	/** 账户ID */
	private String id;

	/** 昵称 */
	private String name;

	/** 用户名 */
	private String screenName;

	/** 用户头像 */
	private String attar;

	/** 创建时间 */
	private long createdAt;

	/** 描述 */
	private String description;

	/** 点赞数 */
	private int favouritesCount;

	/** 关注自己的人的数量 */
	private int followersCount;

	/** 自己关注的人的数量 */
	private int friendsCount;

	/** 地区 */
	private String location;

	/** 推文数 */
	private int statusesCount;

	/** 近期推文 */
	private List<Status> statuses;

	/** 用户 meta 信息 */
	private URLEntity uRLEntity;

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public String getAttar() {
		return attar;
	}

	public void setAttar(String attar) {
		this.attar = attar;
	}

	public URLEntity getuRLEntity() {
		return uRLEntity;
	}

	public void setuRLEntity(URLEntity uRLEntity) {
		this.uRLEntity = uRLEntity;
	}

}

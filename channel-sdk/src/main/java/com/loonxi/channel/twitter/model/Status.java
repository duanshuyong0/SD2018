package com.loonxi.channel.twitter.model;

/**
 * 推文
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 */
public class Status {
	/** statusID */
	private String id;

	private String content;

	/** 推文时间 */
	private long createdAt;

	/** 转推数 */
	private int retweetCount;

	/** 点赞数 */
	private int favouritesCount;

	/** 自己是否点赞 */
	private boolean favorited;

	/** 推文的 meta 信息 */
	private Entity entity;

	/** 发推文的用户信息 */
	private Profile profile;

	/** 转发的推文信息 */
	private Status quotedStatus;

	/** 父推文，被回复的推文 */
	private Status inReply2Status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Status getQuotedStatus() {
		return quotedStatus;
	}

	public void setQuotedStatus(Status quotedStatus) {
		this.quotedStatus = quotedStatus;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public Status getInReply2Status() {
		return inReply2Status;
	}

	public void setInReply2Status(Status inReply2Status) {
		this.inReply2Status = inReply2Status;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCcount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
}

package com.loonxi.channel.twitter.model;

/**
 * 私信
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月27日
 * @since 1.0
 */
public class DirectMessage {

	/** 消息ID */
	private String id;
	/** 消息发送者 */
	private Profile sender;
	/** 消息接收者 */
	private Profile recipient;
	/** 消息内容 */
	private String content;
	/** 消息元信息 */
	private Entity entities;
	/** 发布时间 */
	private long createdAt;

	public String getId() {
		return id;

	}

	public void setId(String id) {
		this.id = id;
	}

	public Profile getSender() {
		return sender;
	}

	public void setSender(Profile sender) {
		this.sender = sender;
	}

	public Profile getRecipient() {
		return recipient;
	}

	public void setRecipient(Profile recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Entity getEntities() {
		return entities;
	}

	public void setEntities(Entity entities) {
		this.entities = entities;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
}

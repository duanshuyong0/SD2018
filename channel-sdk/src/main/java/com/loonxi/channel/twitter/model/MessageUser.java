package com.loonxi.channel.twitter.model;

/**
 * 参与者信息
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月27日
 * @since 1.0
 */
public class MessageUser {
	/** 账户ID */
	private String id;
	/** 昵称 */
	private String name;
	/** 账户名称 */
	private String screenName;

	public MessageUser() {
	}

	public MessageUser(String id, String name, String screenName) {
		this.id = id;
		this.name = name;
		this.screenName = screenName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

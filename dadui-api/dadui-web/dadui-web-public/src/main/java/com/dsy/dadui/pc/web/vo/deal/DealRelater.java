package com.dsy.dadui.pc.web.vo.deal;

public class DealRelater {
	
	/**
	 * 相关人或者公司ID
	 */
	private String id;
	/**
	 * 相关人或者公司名字
	 */
	private String value;
	/**
	 * 相关热或者公司类型  0 个人  1 公司
	 */
	private byte type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}

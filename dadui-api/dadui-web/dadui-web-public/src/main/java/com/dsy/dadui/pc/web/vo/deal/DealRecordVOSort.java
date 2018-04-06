package com.dsy.dadui.pc.web.vo.deal;

import java.util.Date;

public class DealRecordVOSort {
	
	/**
	 * 消息ID
	 */
 	private Long dealMessageId;

    /**
     * 消息时间
     */
    private Date messageTime;
    
    /**
     * 备注ID
     */
    private long remardId;
    
    /**
     * 备注创建时间
     */
    private Date remarkCreateDate;
    
    /**
     * 记录类型  0 代表消息  1 代表备注
     */
    private byte recordType;
    
    /**
     * 排序时间
     */
    private Date sortTime;
    
    
	public Long getDealMessageId() {
		return dealMessageId;
	}

	public void setDealMessageId(Long dealMessageId) {
		this.dealMessageId = dealMessageId;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public long getRemardId() {
		return remardId;
	}

	public void setRemardId(long remardId) {
		this.remardId = remardId;
	}

	public Date getRemarkCreateDate() {
		return remarkCreateDate;
	}

	public void setRemarkCreateDate(Date remarkCreateDate) {
		this.remarkCreateDate = remarkCreateDate;
	}

	public byte getRecordType() {
		return recordType;
	}

	public void setRecordType(byte recordType) {
		this.recordType = recordType;
	}

	public Date getSortTime() {
		return sortTime;
	}

	public void setSortTime(Date sortTime) {
		this.sortTime = sortTime;
	}
    
}

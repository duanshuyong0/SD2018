package com.dsy.dadui.pc.web.form.deal;


public class DealCloseForm {
	
	/**
	 * 商机ID
	 */
	private Long dealId;
	
	
	/**
	 * 商机状态
	 */
	private byte dealStatus;
	
	/**
	 * 商机金额
	 */
	private Double dealAmount;
	
	/**
	 * 商机时间
	 */
	private String dealTime;

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public byte getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(byte dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Double getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
}

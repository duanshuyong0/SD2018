package com.dsy.dadui.pc.web.vo.deal;

import java.util.Date;

public class DealContactsListVO {
	
	//商机ID
	private Long dealId;
	
	//商机NAME
	private String dealName;

	//商机金额
	private Double amount;
	
	//商机币种
	private String currency;
	
	//期望时间
	private Date expectTime;

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public Date getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(Date expectTime) {
		this.expectTime = expectTime;
	}

}

package com.dsy.dadui.pc.web.vo.deal;

import java.util.Date;

public class DealRemarkListVO {
	
	//商机备注ID
	private Long dealRemarkId;
	
	//备注内容
	private String content;

	//创建时间
	private Date createDate;

	public Long getDealRemarkId() {
		return dealRemarkId;
	}

	public void setDealRemarkId(Long dealRemarkId) {
		this.dealRemarkId = dealRemarkId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

}

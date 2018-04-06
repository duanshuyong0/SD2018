package com.dsy.dadui.pc.web.vo.deal;

import java.util.Date;
import java.util.List;

public class DealListVO {
	
	/**
	 * 商机ID
	 */
	private Long dealId;
	
	/**
	 * 商机名字
	 */
	private String dealName;

	/**
	 * 阶段ID
	 */
	private Long stageId;

	/**
	 * 阶段name
	 */
	private String stageName;

	/**
	 * 状态
	 */
	private Byte dealStatus;

	/**
	 * 阶段天数
	 */
	private int stageDays;
	
	/**
	 * 创建天数
	 */
	private int createDays;

	/**
	 * 金额
	 */
	private Double dealAmount;

	/**
	 * 币种
	 */
	private String currency;

	/**
	 * 预计成交时间
	 */
	private Date estimateDealTime;
	
	/**
	 * 成交几率
	 */
	private String dealOdds;

	/**
	 * 关联人
	 */
	private String relatePersonId;

	/**
	 * 关联人名字
	 */
	private String relatePersonName;
	
	/**
	 * 关联公司ID
	 */
	private String relateCompanyId;

	/**
	 * 关联公司名字
	 */
	private String relateComoanyName;

	/**
	 * 商机描述
	 */
	private String dealDesc;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 成交时间
	 */
	private Date dealTime;
	
	/**
	 * 成交天数
	 */
	private int dealDays;
	
	/**
	 * 相关人或者公司
	 */
	private DealRelater relater;
	
	/**
	 * 其他相关人
	 */
	private List<OtherRelater>  otherRelater;
	
	public int getCreateDays() {
		return createDays;
	}

	public void setCreateDays(int createDays) {
		this.createDays = createDays;
	}

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}


	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}


	public int getStageDays() {
		return stageDays;
	}

	public void setStageDays(int stageDays) {
		this.stageDays = stageDays;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getEstimateDealTime() {
		return estimateDealTime;
	}

	public void setEstimateDealTime(Date estimateDealTime) {
		this.estimateDealTime = estimateDealTime;
	}

	public String getDealOdds() {
		return dealOdds;
	}

	public void setDealOdds(String dealOdds) {
		this.dealOdds = dealOdds;
	}

	public String getRelatePersonId() {
		return relatePersonId;
	}

	public void setRelatePersonId(String relatePersonId) {
		this.relatePersonId = relatePersonId;
	}

	public String getRelatePersonName() {
		return relatePersonName;
	}

	public void setRelatePersonName(String relatePersonName) {
		this.relatePersonName = relatePersonName;
	}

	public String getRelateCompanyId() {
		return relateCompanyId;
	}

	public void setRelateCompanyId(String relateCompanyId) {
		this.relateCompanyId = relateCompanyId;
	}

	public String getRelateComoanyName() {
		return relateComoanyName;
	}

	public void setRelateComoanyName(String relateComoanyName) {
		this.relateComoanyName = relateComoanyName;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public Double getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(Double dealAmount) {
		this.dealAmount = dealAmount;
	}

	public Byte getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Byte dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public int getDealDays() {
		return dealDays;
	}

	public void setDealDays(int dealDays) {
		this.dealDays = dealDays;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public DealRelater getRelater() {
		return relater;
	}

	public void setRelater(DealRelater relater) {
		this.relater = relater;
	}

	public List<OtherRelater> getOtherRelater() {
		return otherRelater;
	}

	public void setOtherRelater(List<OtherRelater> otherRelater) {
		this.otherRelater = otherRelater;
	}


}

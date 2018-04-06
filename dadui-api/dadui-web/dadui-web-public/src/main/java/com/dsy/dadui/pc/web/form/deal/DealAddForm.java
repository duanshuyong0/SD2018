package com.dsy.dadui.pc.web.form.deal;


public class DealAddForm {
	
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
	 * 阶段
	 */
	private String stageName;
	
	/**
	 * 预计成交时间
	 */
	private String estimateDealTime;
	
	/**
	 * 成交金额
	 */
	private Double dealAmount;
	
	/**
	 * 成交时间
	 */
	private String dealTime;
	
	/**
	 * 成交几率
	 */
	private String dealOdds;
	
	/**
	 * 相关人
	 */
	private String relatePerson;
	
	/**
	 * 相关人名字
	 */
	private String relatePersonName;
	
	/**
	 * 相关公司
	 */
	private String relateCompany;
	
	/**
	 * 相关公司名字
	 */
	private String relateCompanyName;
	
	/**
	 * 其他关联人
	 */
	private String otherRelatePerson;
	
	/**
	 * 商机描述
	 */
	private String dealDesc;

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long id) {
		this.dealId = id;
	}

	public String getDealName() {
		return dealName;
	}

	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public String getEstimateDealTime() {
		return estimateDealTime;
	}

	public void setEstimateDealTime(String estimateDealTime) {
		this.estimateDealTime = estimateDealTime;
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

	public String getDealOdds() {
		return dealOdds;
	}

	public void setDealOdds(String dealOdds) {
		this.dealOdds = dealOdds;
	}

	public String getRelatePerson() {
		return relatePerson;
	}

	public void setRelatePerson(String relatePerson) {
		this.relatePerson = relatePerson;
	}

	public String getRelatePersonName() {
		return relatePersonName;
	}

	public void setRelatePersonName(String relatePersonName) {
		this.relatePersonName = relatePersonName;
	}

	public String getRelateCompany() {
		return relateCompany;
	}

	public void setRelateCompany(String relateCompany) {
		this.relateCompany = relateCompany;
	}

	public String getRelateCompanyName() {
		return relateCompanyName;
	}

	public void setRelateCompanyName(String relateCompanyName) {
		this.relateCompanyName = relateCompanyName;
	}

	public String getOtherRelatePerson() {
		return otherRelatePerson;
	}

	public void setOtherRelatePerson(String otherRelatePerson) {
		this.otherRelatePerson = otherRelatePerson;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

}

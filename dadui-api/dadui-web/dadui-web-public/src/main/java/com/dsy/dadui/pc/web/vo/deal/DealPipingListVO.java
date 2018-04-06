package com.dsy.dadui.pc.web.vo.deal;

import java.util.List;

public class DealPipingListVO {

	private Long stageId;

	private String stageName;

	/*
	 * 金额
	 */
	private double amount;
	/*
	 * 数量
	 */
	private int count;

	/*
	 * 排序说明
	 */
	private int sort;

	/*
	 * 此阶段商机List
	 */
	List<DealListVO> dealList;

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<DealListVO> getDealList() {
		return dealList;
	}

	public void setDealList(List<DealListVO> dealList) {
		this.dealList = dealList;
	}

}

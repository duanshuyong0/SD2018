package com.dsy.dadui.pc.web.form.deal;

import com.dsy.dadui.common.beans.QueryParam;

public class DealStageEditForm extends QueryParam {
	
	/**
	 * 商机ID
	 */
	private long dealId;
	
	/**
	 * 阶段ID
	 */
	private long stageId;

	public long getDealId() {
		return dealId;
	}

	public void setDealId(long dealId) {
		this.dealId = dealId;
	}

	public long getStageId() {
		return stageId;
	}

	public void setStageId(long stageId) {
		this.stageId = stageId;
	}
	
}

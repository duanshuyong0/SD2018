package com.dsy.dadui.pc.web.form.deal;

import com.dsy.dadui.common.beans.QueryParam;

public class DealMessageListForm extends QueryParam {
	
	/**
	 * 商机ID
	 */
	private long dealId;

	public long getDealId() {
		return dealId;
	}

	public void setDealId(long dealId) {
		this.dealId = dealId;
	}
	
}

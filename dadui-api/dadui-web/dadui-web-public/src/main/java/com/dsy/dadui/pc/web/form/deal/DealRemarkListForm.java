package com.dsy.dadui.pc.web.form.deal;

import com.dsy.dadui.common.beans.QueryParam;

public class DealRemarkListForm extends QueryParam {
	
	/**
	 * 商机备注查询Form
	 */
	private Long dealId; //商机ID

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

}

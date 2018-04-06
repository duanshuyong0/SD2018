package com.dsy.dadui.sdk.query.user;

/**
 * 用户查询
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2017年1月7日
 * @since 1.0
 */
public class UserQuery {

	/**
	 * 账号状态
	 */
	private Byte accountStatus;

	/**
	 * 删除标记
	 */
	private Byte deleteTag;

	public Byte getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Byte accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Byte getDeleteTag() {
		return deleteTag;
	}

	public void setDeleteTag(Byte deleteTag) {
		this.deleteTag = deleteTag;
	}

}

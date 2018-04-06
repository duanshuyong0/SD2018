package com.dsy.dadui.sdk.enums.user;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 账号状态枚举
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public enum AccountStatusEnum implements EnumCode<Byte> {

	INACTIVE((byte) 0, "待激活"), NORMAL((byte) 1, "正常"), OVERDUE((byte) 2, "过期(订阅)"), DISABLED((byte) 3, "禁用");

	private Byte code;

	private String desc;

	AccountStatusEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static AccountStatusEnum getLogicValue(int code) {
		for (AccountStatusEnum logicValue : values()) {
			if (logicValue.getCode() == (code)) {
				return logicValue;
			}
		}
		return null;
	}

	@Override
	public Byte getCode() {
		return code;
	}

}

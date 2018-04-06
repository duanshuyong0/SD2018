package com.dsy.dadui.sdk.enums.user;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 用户类型枚举
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public enum UserTypeEnum implements EnumCode<Byte> {

	PARENT((byte) 0, "父账号"), CHILDREN((byte) 1, "子账号"), UNKNOWN((byte) -1, "未知");

	private Byte code;

	private String desc;

	UserTypeEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static UserTypeEnum getLogicValue(int code) {
		for (UserTypeEnum logicValue : values()) {
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

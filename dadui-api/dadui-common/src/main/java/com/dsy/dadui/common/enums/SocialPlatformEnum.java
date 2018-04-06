package com.dsy.dadui.common.enums;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 社交平台枚举
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum SocialPlatformEnum implements EnumCode<Byte> {

	FACEBOOK((byte) 0, "facebook"), TWITTER((byte) 1, "twitter"), LINKEDIN((byte) 2, "linkedin");

	private Byte code;

	private String desc;

	SocialPlatformEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static SocialPlatformEnum getLogicValue(int code) {
		for (SocialPlatformEnum logicValue : values()) {
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

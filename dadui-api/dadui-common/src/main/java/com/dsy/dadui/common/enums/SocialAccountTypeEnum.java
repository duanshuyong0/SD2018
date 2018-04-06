package com.dsy.dadui.common.enums;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 社交账号类型枚举
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 */
public enum SocialAccountTypeEnum implements EnumCode<Byte> {

	FACEBOOK((byte) 0, "Facebook个人主页"), FACEBOOK_PAGES((byte) 1, "Facebook公共主页"), TWITTER((byte) 2,
			"Twitter"), LINKEDIN((byte) 3, "LinkedIn个人"), LINKEDIN_COMPANY((byte) 4, "LinkedIn公司");

	private Byte code;

	private String desc;

	SocialAccountTypeEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static SocialAccountTypeEnum getSocialAccountTypeEnum(byte code) {
		for (SocialAccountTypeEnum typeValue : values()) {
			if (typeValue.getCode() == code) {
				return typeValue;
			}
		}
		return null;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public Byte getCode() {
		return code;
	}
}

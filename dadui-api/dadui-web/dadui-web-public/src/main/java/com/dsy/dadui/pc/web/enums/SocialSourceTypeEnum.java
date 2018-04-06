package com.dsy.dadui.pc.web.enums;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 社交联系人来源类型枚举
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2017年1月15日
 * @since 1.0
 */
public enum SocialSourceTypeEnum implements EnumCode<Byte> {

	CONTACTS((byte) 0, "联系人"),

	OPPORTUNITY((byte) 1, "机会"),

	MESSAGE((byte) 1, "消息");

	private Byte code;

	private String desc;

	SocialSourceTypeEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static SocialSourceTypeEnum getContactsTypeEnum(byte code) {
		for (SocialSourceTypeEnum typeValue : values()) {
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
		// TODO Auto-generated method stub
		return code;
	}

}

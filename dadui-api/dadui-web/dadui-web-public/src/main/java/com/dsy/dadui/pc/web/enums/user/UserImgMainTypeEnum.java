package com.dsy.dadui.pc.web.enums.user;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 社交联系人来源类型枚举
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2017年1月15日
 * @since 1.0
 */
public enum UserImgMainTypeEnum implements EnumCode<Byte> {

	IsMainImgNo((byte) 0, "不是主图像"), IsMainImgYes((byte) 1, "是主图像");

	private Byte code;

	private String desc;

	private UserImgMainTypeEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}

	@Override
	public Byte getCode() {
		return code;

	}

}

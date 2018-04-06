package com.dsy.dadui.common.enums;

/**
 * 结果状态枚举
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum ResultCodeEnum implements EnumCode<Integer> {

	SUCCESS(0, "成功"),

	NORMAL_ERROR(1, "正常错误"),

	PARAM_ERROR(2, "参数错误"),

	UNKNOWN_ERROR(-1, "服务器貌似出了点问题, 技术君全力抢修中...");

	private int code;

	private String desc;

	ResultCodeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static ResultCodeEnum getResultCode(int code) {
		for (ResultCodeEnum resultCode : values()) {
			if (resultCode.getCode() == (code)) {
				return resultCode;
			}
		}
		return UNKNOWN_ERROR;
	}

}

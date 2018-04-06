package com.dsy.dadui.common.enums;

/**
 * 金额转换倍率枚举
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum AmountUtilMultiplyEnum {

	YUAN2FEN(100, "元转化为分倍率");

	private Integer value;

	private String desc;

	AmountUtilMultiplyEnum(Integer value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static AmountUtilMultiplyEnum getLogicValue(int value) {
		for (AmountUtilMultiplyEnum amountUtilMultiply : values()) {
			if (amountUtilMultiply.getValue() == (value)) {
				return amountUtilMultiply;
			}
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}

}

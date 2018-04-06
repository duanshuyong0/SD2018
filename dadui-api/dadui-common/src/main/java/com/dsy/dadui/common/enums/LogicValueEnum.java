package com.dsy.dadui.common.enums;

/**
 * 逻辑值枚举，可用于是、否等
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum LogicValueEnum implements EnumCode<Byte> {

	TRUE((byte) 1, "逻辑真"), FALSE((byte) 0, "逻辑假");

	private Byte code;

	private String desc;

	LogicValueEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static LogicValueEnum getLogicValue(int code) {
		for (LogicValueEnum logicValue : values()) {
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

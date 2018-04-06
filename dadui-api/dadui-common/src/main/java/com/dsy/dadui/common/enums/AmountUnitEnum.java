package com.dsy.dadui.common.enums;

/**
 * 费用币种
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum AmountUnitEnum implements EnumCode<String> {

	CNY("CNY", "人民币"), USD("US", "美元");

	private String code;

	private String desc;

	AmountUnitEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String getCode() {
		return code;
	}

}

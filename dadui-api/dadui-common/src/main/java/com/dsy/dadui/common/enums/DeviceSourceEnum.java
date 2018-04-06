package com.dsy.dadui.common.enums;

import com.dsy.dadui.common.enums.EnumCode;

/**
 * 设备来源
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
public enum DeviceSourceEnum implements EnumCode<Byte> {

	PC((byte) 0, "PC"), EMBEDDED((byte) 1, "嵌入端"), MOBILE((byte) 2, "移动H5"), ANDROID((byte) 3, "安卓"), IOS((byte) 4,
			"IOS");

	private Byte code;

	private String desc;

	DeviceSourceEnum(Byte code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static DeviceSourceEnum getLogicValue(int code) {
		for (DeviceSourceEnum logicValue : values()) {
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

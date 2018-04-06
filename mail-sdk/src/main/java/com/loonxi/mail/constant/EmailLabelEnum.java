package com.loonxi.mail.constant;


/**
 * 邮箱Label枚举
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */

public enum EmailLabelEnum {
    //依次为收件箱，发件箱，垃圾箱，已删除邮件
    INBOX(0,"INBOX"),SEND(1,"SEND"),TRASH(2,"TRASH"),DELETE(3,"DELETE");

    private Integer code;
    private String desc;

    EmailLabelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    
	public static EmailLabelEnum getEmailLabelEnum(int i) {
		for (EmailLabelEnum typeValue : values()) {
			if (typeValue.getCode() == i) {
				return typeValue;
			}
		}
		return null;
	}
}

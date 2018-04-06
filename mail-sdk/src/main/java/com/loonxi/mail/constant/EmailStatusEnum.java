package com.loonxi.mail.constant;

/**
 * 邮件状态枚举
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public enum EmailStatusEnum {

    UNREAD("0","UNREAD"),READ("1","READ"),DELETE("2","DELETE");

    private String code;
    private String desc;

    EmailStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

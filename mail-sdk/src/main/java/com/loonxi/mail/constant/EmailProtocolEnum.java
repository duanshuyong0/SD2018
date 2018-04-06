package com.loonxi.mail.constant;

/**
 * 邮箱协议枚举类
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 6/1/17
 * @since 1.0
 */


public enum EmailProtocolEnum {

    SMTP("SMTP","发送邮件协议"),IMAP("IMAP","邮件接收协议"),OTHER("OTHER","其它");
    private String code;
    private String desc;

    EmailProtocolEnum(String code, String desc) {
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

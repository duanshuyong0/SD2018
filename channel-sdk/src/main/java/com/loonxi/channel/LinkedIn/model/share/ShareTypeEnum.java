package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 17/1/17
 * @since 1.0
 */

public enum  ShareTypeEnum {

    JOB_POSTINGI(0,"job-posting"),

    NEW_PRODUCT(1,"new-product"),

    /** 普通动态 */
    STATUS_UPDATE(2,"status-update"),
    ;

    private Integer code;
    private String desc;

    ShareTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

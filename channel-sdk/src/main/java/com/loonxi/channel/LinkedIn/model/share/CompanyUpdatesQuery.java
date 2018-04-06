package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 17/1/17
 * @since 1.0
 */

public class CompanyUpdatesQuery {

    private Integer size = Integer.valueOf(50);  //每页显示多少条,默认50

    private ShareTypeEnum shareTypeEnum;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ShareTypeEnum getShareTypeEnum() {
        return shareTypeEnum;
    }

    public void setShareTypeEnum(ShareTypeEnum shareTypeEnum) {
        this.shareTypeEnum = shareTypeEnum;
    }
}

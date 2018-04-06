package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 17/1/17
 * @since 1.0
 */

public class LinkedInShareComplexBean extends  LinkedInShareBean {

    private  LinkedInShareContentBean content;

    public LinkedInShareContentBean getContent() {
        return content;
    }

    public void setContent(LinkedInShareContentBean content) {
        this.content = content;
    }
}

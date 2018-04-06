package com.loonxi.channel.LinkedIn.model.share;

import com.loonxi.channel.LinkedIn.model.share.LinkedInShareContentBean;

/**
 *
 * LinkedIn 分享信息
 *
 * <pre>
 * Pattern : Value Object
 * Thread Safe : No
 *
 * Change History
 *
 * Name                 Date                    Description
 * -------              -------                 -----------------
 * Banma              2016-12-09            Create the class
 *
 * </pre>
 *
 * @author Banma
 * @version 1.0
 */
public class LinkedInShareBean {

    protected String comment;

    protected ShareVisibility visibility = new ShareVisibility();

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ShareVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(ShareVisibility visibility) {
        this.visibility = visibility;
    }

    class ShareVisibility{
        private String code = "anyone";

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}

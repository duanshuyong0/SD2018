package com.loonxi.channel.LinkedIn.model.share;

/**
 *
 * LinkedIn 分享响应信息
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
public class LinkedInShareResponse {

    private String updateKey;

    private String updateUrl;

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }
}

package com.loonxi.channel.LinkedIn.model.share;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

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
public class LinkedInShareContentBean  implements Serializable{
    private String title;
    private String description;
    @JsonProperty("submitted-url")
    private String submittedUrl;
    @JsonProperty("submitted-image-url")
    private String submittedImageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmittedUrl() {
        return submittedUrl;
    }

    public void setSubmittedUrl(String submittedUrl) {
        this.submittedUrl = submittedUrl;
    }

    public String getSubmittedImageUrl() {
        return submittedImageUrl;
    }

    public void setSubmittedImageUrl(String submittedImageUrl) {
        this.submittedImageUrl = submittedImageUrl;
    }
}

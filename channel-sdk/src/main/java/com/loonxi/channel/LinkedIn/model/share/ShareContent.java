package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class ShareContent implements java.io.Serializable {

    private String title;
    private String submittedImageUrl;
    private String submittedUrl;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmittedImageUrl() {
        return submittedImageUrl;
    }

    public void setSubmittedImageUrl(String submittedImageUrl) {
        this.submittedImageUrl = submittedImageUrl;
    }

    public String getSubmittedUrl() {
        return submittedUrl;
    }

    public void setSubmittedUrl(String submittedUrl) {
        this.submittedUrl = submittedUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

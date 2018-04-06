package com.loonxi.channel.LinkedIn.model.share;

import java.util.List;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 17/1/17
 * @since 1.0
 */

public class SharePersonInfo implements  java.io.Serializable {

    private Long timestamp;
    private SharePerson person;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public SharePerson getPerson() {
        return person;
    }

    public void setPerson(SharePerson person) {
        this.person = person;
    }
}

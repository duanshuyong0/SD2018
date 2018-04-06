package com.loonxi.channel.LinkedIn.model.share;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 16/1/17
 * @since 1.0
 */

public class CompanyShareCommentBean {

    private Integer sequenceNumber;
    private String id;
    private Long timestamp;
    private String comment;
    private SharePerson person;


    public SharePerson getPerson() {
        return person;
    }

    public void setPerson(SharePerson person) {
        this.person = person;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}

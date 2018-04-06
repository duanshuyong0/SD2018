package com.loonxi.channel.pinterest.model;

import java.io.Serializable;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/9/13
 */
public class Pins implements Serializable{
    /**
     * PIN ID
     */
    public String id;

    /**
     * PIN NTOE
     */
    public String note;

    /**
     * PIN 链接
     */
    public String url;

    /**
     * PIN 点击跳转地址
     */
    public String link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

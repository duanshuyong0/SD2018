package com.loonxi.channel.pinterest.model;

import java.io.Serializable;

/**
 * 画板.
 *
 * @author xyy
 * @Date 2016/9/12
 */
public class Boards implements Serializable{
    /**
     * 画板ID
     */
    public String id;

    /**
     * 画板名字
     */
    public String name;

    /**
     * 画板链接
     */
    public String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

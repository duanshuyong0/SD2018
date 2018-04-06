package com.loonxi.channel.facebook.model;

import java.util.Date;

/**
 * Created by xyy on 2017/1/9.
 */
public class FBPageQuery {
    /**
     * 每页显示多少条
     */
    public int size;

    /**
     * 起始时间
     */
    public Date sinceTime;

    /**
     * 结束时间
     */
    public Date untilTime;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getSinceTime() {
        return sinceTime;
    }

    public void setSinceTime(Date sinceTime) {
        this.sinceTime = sinceTime;
    }

    public Date getUntilTime() {
        return untilTime;
    }

    public void setUntilTime(Date untilTime) {
        this.untilTime = untilTime;
    }

}

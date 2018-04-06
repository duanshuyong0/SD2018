package com.loonxi.channel.pinterest.model;

import java.io.Serializable;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/9/12
 */
public class UserProfile implements Serializable{
    /**
     * 用户ID
     */
    public String userId;

    /**
     * 个人主页
     */
    public String url;

    /**
     * 用户名称
     */
    public String username;

    private String avatar; //用户头像


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

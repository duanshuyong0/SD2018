package com.loonxi.channel.facebook.model;

/**
 * Created by xyy on 2017/1/7.
 */
public class FBbaseProfile {
    public FBbaseProfile(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;


    private String name;

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
}

package com.loonxi.channel.facebook.model;

import java.util.List;

/**
 * Created by xyy on 2017/1/7.
 */
public class FBPaging<T> {
    private FBCursor fbCursor;

    private List<T> data;


    public FBPaging(FBCursor fbCursor, List<T> data) {
        this.fbCursor = fbCursor;
        this.data = data;
    }

    public FBCursor getFbCursor() {
        return fbCursor;
    }


    public List<T> getData() {
        return data;
    }
}

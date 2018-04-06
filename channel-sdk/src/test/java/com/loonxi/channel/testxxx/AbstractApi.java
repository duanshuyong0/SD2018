package com.loonxi.channel.testxxx;

/**
 * Created by xyy on 2017/1/14.
 */
public abstract class AbstractApi {
    protected String accessToken;
    protected String head;

    public AbstractApi() {
    }

    public AbstractApi(String accessToken) {
        this.accessToken = accessToken;
    }
}

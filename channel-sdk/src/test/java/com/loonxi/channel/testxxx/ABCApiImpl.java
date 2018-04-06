package com.loonxi.channel.testxxx;

/**
 * Created by xyy on 2017/1/14.
 */
public class ABCApiImpl extends AbstractApi implements ABCApi{




    public ABCApiImpl(String accessToken) {
        super(accessToken);
    }

    @Override
    public String get() {
        return this.accessToken;

    }
}

package com.loonxi.channel.twitter.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.TwitterClientFactory;
import com.loonxi.channel.twitter.XyyCredential;
import com.loonxi.channel.twitter.model.Status;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class StatusApiTest {
    private static StatusApi statusApi = null;
    static {
        TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        statusApi = factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret).getStatusApi();
    }
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    @Test
    public void postTweet() throws Exception {
        System.out.println(JSON.toJSON(statusApi.postTweet("呵呵，test")));
    }

    @Test
    public void postTweetWithPic() throws Exception {
        String imgUrl = "http://mvimg1.meitudata.com/5796c8a3d6e866111.jpg";
        statusApi.postTweetWithPic("呵呵，test post img",imgUrl);
    }

    @Test
    public void createFavorite() throws Exception {
        String stateId = "819423909783150592";
        statusApi.createFavorite(stateId);
    }

    @Test
    public void destroyFavorite() throws Exception {
        String stateId = "819423909783150592";
        statusApi.destroyFavorite(stateId);
    }

    @Test
    public void retweetStatus() throws Exception {
        String stateId = "819423909783150592";
        statusApi.retweetStatus(stateId);
    }

    @Test
    public void retweetStatus1() throws Exception {
        String screenName = "XHNews";
        String statusId = "819423909783150592";
        String context = "ok";
        Status status = statusApi.retweetStatus(screenName, statusId, context);
        System.out.println(JSON.toJSONString(status));
    }

    @Test
    public void replyToStatus() throws Exception {
        String message = "@XHNews 呵呵哒，hehe";
        String statusId = "819369684386672641";
        statusApi.replyToStatus(statusId, message);
    }

    @Test
    public void showStatus() throws Exception {
        String statusId = "819476904159969281";
        Status status = statusApi.showStatus(statusId);
        System.out.println(JSON.toJSONString(status,true));
    }

}
package com.loonxi.channel.twitter.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.TwitterClientFactory;
import com.loonxi.channel.twitter.XyyCredential;
import com.loonxi.channel.twitter.model.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class MentionsApiTest {
    private static MentionsApi mentionsApi = null;
    static {
        TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        mentionsApi = factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret).getMentionsApi();
    }
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    @Test
    public void getMentionsTimeline() throws Exception {
        List<Status> statuses = mentionsApi.getMentions(0);
        System.out.println(statuses.size());
        System.out.println(JSON.toJSON(statuses));
    }

    @Test
    public void getMentionsTimeline1() throws Exception {
        List<Status> statuses = mentionsApi.getMentions(12,"819089746370539520");
        System.out.println(statuses.size());
        System.out.println(JSON.toJSON(statuses));
    }

}
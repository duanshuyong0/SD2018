package com.loonxi.channel.twitter;

import com.loonxi.channel.common.SslUtils;
import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterFactory;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/14.
 */
public class TwitterClientFactoryTest {
    TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }
    @Test
    public void authUrl() throws Exception {
        System.out.println(factory.authUrl().getAuthUrl());
    }

    @Test
    public void getAccessToken() throws Exception {

    }

}
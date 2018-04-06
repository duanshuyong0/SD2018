package com.loonxi.channel.twitter.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.CjyCredential;
import com.loonxi.channel.twitter.TwitterClientFactory;
import com.loonxi.channel.twitter.XyyCredential;
import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterFactory;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class ProfileApiTest {
    private static ProfileApi profileApi = null;
    static {
        TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        profileApi = factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret).getProfileApi();
    }
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }


    @Test
    public void searchTwitter() throws Exception {
        System.out.println(JSON.toJSON(profileApi.searchTwitter("37_oC")));
    }

    @Test
    public void searchTwitterByUserId() throws Exception {
        System.out.println(JSON.toJSON(profileApi.searchTwitterByUserId("753471684967931904")));
    }

    @Test
    public void searchTwitters() throws Exception {
        System.out.println(JSON.toJSON(profileApi.searchTwitters("xx",10)));
    }

    @Test
    public void getAccountProfile() throws Exception {
        System.out.println(JSON.toJSON(profileApi.getAccountProfile()));
    }

    @Test
    public void getAccountProfile1() throws Exception {
        //profileApi.getAccountProfile()
    }

    @Test
    public void updateProfileImage() throws Exception {

    }

    @Test
    public void getHomeTimeline() throws Exception {

    }

    @Test
    public void getHomeTimeline1() throws Exception {

    }

    @Test
    public void getUserTimeline() throws Exception {

    }

    @Test
    public void getUserTimeline1() throws Exception {

    }

    @Test
    public void getUserTimelineById() throws Exception {

    }

    @Test
    public void getUserTimelineById1() throws Exception {

    }

}
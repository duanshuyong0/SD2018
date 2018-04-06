package com.loonxi.channel.twitter.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.CjyCredential;
import com.loonxi.channel.twitter.TwitterClientFactory;
import com.loonxi.channel.twitter.XyyCredential;
import com.loonxi.channel.twitter.model.Profile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class FriendsApiTest {
    private static FriendsApi friendsApi = null;
    static {
        TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        friendsApi = factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret).getFriendsApi();
    }
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    @Test
    public void createFriendshipById() throws Exception {

    }

    @Test
    public void createFriendshipByName() throws Exception {
        Profile profile = friendsApi.createFriendshipByName("zhangxiyue2");
        System.out.print(JSON.toJSONString(profile, true));
    }

    @Test
    public void destroyFriendshipById() throws Exception {

    }

    @Test
    public void destroyFriendshipByName() throws Exception {
        Profile profile = friendsApi.destroyFriendshipByName("zhangxiyue2");
        System.out.print(JSON.toJSONString(profile, true));
    }

    @Test
    public void getFriendsById() throws Exception {

    }

    @Test
    public void getFriendsById1() throws Exception {
        String userId = "753471684967931904";
        System.out.println(JSON.toJSON(friendsApi.getFriendsById(userId,1544778306300716000L)));
    }

    @Test
    public void getFriendsByName() throws Exception {

    }

    @Test
    public void getFriendsByName1() throws Exception {

    }

    @Test
    public void getFollowById() throws Exception {
        String userId = "753471684967931904";
        System.out.println(JSON.toJSON(friendsApi.getFollowsById(userId, 3, -1)));
    }

}
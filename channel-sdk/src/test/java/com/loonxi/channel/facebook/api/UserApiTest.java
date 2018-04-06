package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.FacebookClient;
import com.loonxi.channel.facebook.FacebookClientFactory;
import com.loonxi.channel.facebook.XyyCredential;
import com.loonxi.channel.facebook.model.FacebookUserProfile;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/5.
 */
public class UserApiTest {
    private static UserApi userApi;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);
        userApi = facebookClient.getUserApi();
    }

    @Test
    public void getProfile() throws Exception {
        FacebookUserProfile profile = userApi.getProfile();
        System.out.println(JSON.toJSON(profile));
    }

}
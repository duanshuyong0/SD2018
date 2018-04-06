package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.FacebookClient;
import com.loonxi.channel.facebook.FacebookClientFactory;
import com.loonxi.channel.facebook.XyyCredential;
import com.loonxi.channel.facebook.XyyCredentialPageCycle;
import com.loonxi.channel.facebook.model.*;
import facebook4j.FacebookException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/8.
 */
public class NotificationApiTest {
    private static NotificationApi notificationApi;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        //个人的身份
        //FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);


        //主页的身份 1133083050066887
        FacebookClient facebookClient = factory.getInstance(XyyCredentialPageCycle.accessToken);
        notificationApi = facebookClient.getNotificationApi();
    }

    @Test
    public void getNotifications() throws Exception {
        FBPageQuery fbPageQuery = new FBPageQuery();
        fbPageQuery.setSize(10);
        FBPaging<FBNotification> fbNotificationFBPaging = notificationApi.getNotifications(10);
        System.out.println(JSON.toJSON(fbNotificationFBPaging));
    }

    @Test
    public void getNotifications1() throws Exception {

    }


}
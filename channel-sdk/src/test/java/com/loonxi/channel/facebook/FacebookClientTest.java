package com.loonxi.channel.facebook;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.api.PageApi;
import com.loonxi.channel.facebook.model.*;
import org.junit.Before;
import org.junit.Test;
import sun.invoke.util.VerifyAccess;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/10.
 */
public class FacebookClientTest {
    private static FacebookClient client;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        //个人的身份
        //FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);


        //主页的身份 1133083050066887
        client = factory.getInstance(XyyCredentialPageCycle.accessToken);
    }

    @Test
    public void navigatePage() throws Exception {

    }

    @Test
    public void navigateNotification() throws Exception {

    }

    @Test
    public void navigatePost() throws Exception {

    }

    @Test
    public void navigateConversation() throws Exception {
        String value = "https://graph.facebook.com/v2.8/1133083050066887/conversations?fields=messages.limit%281%29%7Bcreated_time,from,id,message,to%7D,senders&limit=1&format=json&access_token=EAAZAOjtLPb9EBAFDfMc8IowJXXBl3NbCwJqbGx2eZAh4ivIyQU0KTqNFILeMUcxQDTEJWYZBhqdcCHArX8XML64pzWWnmUfafoZBbQlR6s48zDZByh5VahdPzcQ7NuMgnXMqZBysLnMSNtCZBCQFD1WEpFcPxStOS2rSk9q6otIPbblNE0pQ04c&until=1484010633&__paging_token=enc_AdCLCyVuMoChreXvN6xuEgt6sB2R0eZCsKkSwy4wU9aoJxetHJrv6TcNDeH4OaOYIqmnqW3x77vJvD8Ou8wBTyCpNZBLZBYaySZAbbLkWJSwPPNkuwZDZD";
        System.out.println(JSON.toJSON(client.navigateConversation(new FBCursorMode(value, FBCursorDirection.AFTER))));

        /*FBPageQuery fbPageQuery = new FBPageQuery();
        fbPageQuery.setSize(1);
        FBPaging<FBNotification> fbNotificationFBPaging = client.getNotificationApi().getNotifications(fbPageQuery);
        System.out.println(JSON.toJSON(fbNotificationFBPaging));*/
    }

    @Test
    public void navigateMessage() throws Exception {

    }

    @Test
    public void navigateComments() throws Exception {
        String value = "https://graph.facebook.com/v2.2/1366608820047641_1366609820047541/comments?access_token=EAACEdEose0cBAPDUiyXGcThjLAcGeKOrZBJMqzl1VjNIm6S30emWu3wYVekZB0gZAmmmf5UJUwZBdvG1OqlGPVJNhIGeC6D5NKfzayYNrJl0huEAy5W9HHGyGnQ1vSZBFCpWFUy2qjng7MxZAqjltOhNKsLZA2QWPvZAHOeObp4SZAF0HXGjiN2wx&fields=attachment%2Ccan_like%2Ccomment_count%2Ccreated_time%2Cfrom%2Cid%2Cmessage%2Clike_count&limit=2&after=WTI5dGJXVnVkRjlqZAFhKemIzSTZANVE0yTmpZAeE5UQTNNREEwTnpBeE5qb3hORGd6TmpZAM09EQXoZD";
        System.out.println(JSON.toJSON(client.navigateComment(new FBCursorMode(value, FBCursorDirection.AFTER))));

    }

}
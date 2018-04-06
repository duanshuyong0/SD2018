package com.loonxi.channel.facebook.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.facebook.FacebookClient;
import com.loonxi.channel.facebook.FacebookClientFactory;
import com.loonxi.channel.facebook.XyyCredential;
import com.loonxi.channel.facebook.XyyCredentialPageCycle;
import facebook4j.Message;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by xyy on 2017/1/9.
 */
public class MessageApiTest {
    private static MessageApi messageApi;

    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    static {
        FacebookClientFactory factory = new FacebookClientFactory(XyyCredential.appId,XyyCredential.appSecret);
        //个人的身份
        //FacebookClient facebookClient = factory.getInstance(XyyCredential.accessToken);
        //主页的身份
        FacebookClient facebookClient = factory.getInstance(XyyCredentialPageCycle.accessToken);
        messageApi = facebookClient.getMessageApi();
    }

    @Test
    public void getMessage() throws Exception {
        String messageId = "t_mid.1483789056973:c127349c19";
        Message message = messageApi.getMessage(messageId);
        System.out.println(JSON.toJSON(message));
    }


    @Test
    public void getConversations() throws Exception {
        System.out.println(JSON.toJSON(messageApi.getConversations(10,10)));
    }

    @Test
    public void postMessage() throws Exception {
        String conversationId = "t_mid.1483789056973:c127349c19";
        String message = "xxxxx by program";
        System.out.println(messageApi.postMessage(conversationId, message));
    }

}
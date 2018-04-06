package com.loonxi.channel.twitter.api;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.TwitterClientFactory;
import com.loonxi.channel.twitter.XyyCredential;
import com.loonxi.channel.twitter.model.DirectMessage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class DirectMessageApiTest {
    private static DirectMessageApi directMessageApi = null;
    static {
        TwitterClientFactory factory = new TwitterClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        directMessageApi= factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret).getMessageApi();
    }
    @Before
    public void before() throws Exception {
        SslUtils.ignoreSsl();
    }

    @Test
    public void getDirectMessages() throws Exception {
        List<DirectMessage> messages = directMessageApi.getDirectMessages(0);
        System.out.println(messages.size());
        System.out.println(JSON.toJSON(messages));
    }

    @Test
    public void getDirectMessages1() throws Exception {
        List<DirectMessage> messages = directMessageApi.getDirectMessages(0,"819088643675418627");
        System.out.println(messages.size());
        System.out.println(JSON.toJSON(messages));
    }

    @Test
    public void getSentDirectMessages() throws Exception {
        List<DirectMessage> messages = directMessageApi.getSentDirectMessages(1);
        System.out.println(messages.size());
        System.out.println(JSON.toJSON(messages));
    }

    @Test
    public void getSentDirectMessages1() throws Exception {
        List<DirectMessage> messages = directMessageApi.getSentDirectMessages(2,"819366751481647108");
        System.out.println(messages.size());
        System.out.println(JSON.toJSON(messages));
    }

    @Test
    public void sendDirectMessageByName() throws Exception {
        directMessageApi.sendDirectMessageByName("zhangxiyue2","hello,aaaaaa");
    }

    @Test
    public void sendDirectMessageById() throws Exception {

    }

    @Test
    public void destroyDirectMessage() throws Exception {
        directMessageApi.destroyDirectMessage("819481044378390531");
    }

}
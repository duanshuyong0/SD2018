package com.loonxi.channel.twitter;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.api.FriendsApi;
import com.loonxi.channel.twitter.model.Profile;
import com.loonxi.channel.twitter.model.Status;
import com.loonxi.channel.twitter.streamApi.UserListener;
import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterStreamFactory;

import static org.junit.Assert.*;

/**
 * Created by xyy on 2017/1/12.
 */
public class TwitterStreamClientTest {
    private static TwitterStreamClient twitterStreamClient;
    static {
        TwitterStreamClientFactory factory = new TwitterStreamClientFactory(XyyCredential.consumerKey, XyyCredential.consumerSecrect);
        twitterStreamClient = factory.getInstance(XyyCredential.accessToken, XyyCredential.accessTokenSecret);
        try {
            SslUtils.ignoreSsl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        twitterStreamClient.startUserStream(new UserListener() {
            @Override
            protected void retweet(Status status) {
                System.out.println(JSON.toJSON(status));
            }

            @Override
            protected void quotedTweet(Profile source, Profile target, Status quotingTweet) {

            }

            @Override
            protected void favoute(Profile source, Profile target, Status staus) {

            }

            @Override
            protected void follow(Profile source, Profile followedUser) {

            }
        });
    }

}
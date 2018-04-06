package com.loonxi.channel.twitter.streamApi;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.SslUtils;
import com.loonxi.channel.twitter.XyyCredential;
import com.loonxi.channel.twitter.model.Profile;
import com.loonxi.channel.twitter.model.Status;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2017/1/3
 */
public class StreamApiTest {


    public static void main(String[] args) throws Exception {
        SslUtils.ignoreSsl();
        StreamApi.start(XyyCredential.consumerKey, XyyCredential.consumerSecrect, XyyCredential.accessToken, XyyCredential.accessTokenSecret, new UserListener() {
            @Override
            protected void retweet(Status status) {
                System.out.println(JSON.toJSON(status));
            }

            @Override
            protected void quotedTweet(Profile source, Profile target, Status quotingTweet) {
                System.out.println(JSON.toJSON(source));
                System.out.println(JSON.toJSON(target));
                System.out.println(JSON.toJSON(quotingTweet));
            }

            @Override
            protected void favoute(Profile source, Profile target, Status staus) {
                System.out.println(JSON.toJSON(source));
                System.out.println(JSON.toJSON(target));
                System.out.println(JSON.toJSON(staus));
            }

            @Override
            protected void follow(Profile source, Profile followedUser) {
                System.out.println(JSON.toJSON(source));
                System.out.println(JSON.toJSON(followedUser));
            }
        });
    }

}
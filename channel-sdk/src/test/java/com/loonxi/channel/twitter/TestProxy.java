package com.loonxi.channel.twitter;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.twitter.model.Profile;
import org.junit.Test;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/12/30
 */
public class TestProxy {
    @Test
    public void test() throws Exception {
        TwitterConfig twitterConfig = new TwitterConfig(XyyCredential.consumerKey,XyyCredential.consumerSecrect);
        twitterConfig.setSetProxy(true);
        //本地IP
        twitterConfig.setProxyIp("127.0.0.1");
        //本地代理软件的端口 如果使用 shadowsank 都用 1080
        twitterConfig.setProxyPort(1080);
        TwitterClient client = new TwitterClient(twitterConfig);
        //Profile profile = client.getProfileApi().getAccountProfile(XyyCredential.accessToken,XyyCredential.accessTokenSecret);
        //System.out.println(JSON.toJSON(profile));
    }
}

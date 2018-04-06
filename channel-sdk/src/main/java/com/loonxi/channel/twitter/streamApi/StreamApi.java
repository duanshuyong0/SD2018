package com.loonxi.channel.twitter.streamApi;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2017/1/3
 */
@Deprecated
public class StreamApi {
    /*private TwitterStream twitterStream;
    private static String consumerKey;
    private static String consumerSecret;
    private UserListener userListener;*/

    /*public void start(String token, String tokenSecret){
        AccessToken accessToken = new AccessToken(token, tokenSecret); // 设置access token
        TwitterStream twitterStream = StreamClient(consumerKey,consumerSecret);
        twitterStream.setOAuthAccessToken(accessToken); // twitterStream实例用于侦听用户推文

        twitterStream.addListener(userListener); // 这里加入了listener用于处理侦听推文
        twitterStream.user();
    }*/

    public static void start(String consumerKey, String consumerSecret, String token, String tokenSecret,UserListener userListener){
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        Configuration configuration = builder.build();
        TwitterStreamFactory tf = new TwitterStreamFactory(configuration);
        TwitterStream twitterStream = tf.getInstance();
        AccessToken accessToken = new AccessToken(token, tokenSecret); // 设置access token
        twitterStream.setOAuthAccessToken(accessToken); // twitterStream实例用于侦听用户推文
        twitterStream.addListener(userListener); // 这里加入了listener用于处理侦听推文
        twitterStream.user();
    }


}

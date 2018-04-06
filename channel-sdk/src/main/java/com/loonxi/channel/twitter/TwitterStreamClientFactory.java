package com.loonxi.channel.twitter;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by xyy on 2017/1/12.
 */
public class TwitterStreamClientFactory {
    private TwitterStreamFactory factory;


    public TwitterStreamClientFactory(String consumerKey, String consumerSecret) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        Configuration configuration = builder.build();
        TwitterStreamFactory factory = new TwitterStreamFactory(configuration);
        this.factory = factory;
    }

    /**
     * make a proxy factory
     * @param consumerKey
     * @param consumerSecret
     * @param proxyHost
     * @param proxyPort
     */
    public TwitterStreamClientFactory(String consumerKey, String consumerSecret,String proxyHost, int proxyPort) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        builder.setHttpProxyHost(proxyHost);
        builder.setHttpProxyPort(proxyPort);
        Configuration configuration = builder.build();
        TwitterStreamFactory factory = new TwitterStreamFactory(configuration);
        this.factory = factory;
    }

    /**
     * make a twitterclient
     * @param token
     * @param tokenSecrect
     * @return
     */
    public TwitterStreamClient getInstance(String token, String tokenSecrect){
        TwitterStream twitter = factory.getInstance();
        twitter.setOAuthAccessToken(new AccessToken(token,tokenSecrect));
        TwitterStreamClient streamClient = new TwitterStreamClient(twitter);
        return streamClient;
    }


}

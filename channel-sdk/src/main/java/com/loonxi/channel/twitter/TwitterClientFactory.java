package com.loonxi.channel.twitter;

import com.loonxi.channel.twitter.model.AuthParam;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * a factory class
 * Created by xyy on 2017/1/5.
 */
public class TwitterClientFactory {
    private TwitterFactory twitterFactory;


    public TwitterClientFactory(String consumerKey, String consumerSecret) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        this.twitterFactory = factory;
    }

    /**
     * make a proxy factory
     * @param consumerKey
     * @param consumerSecret
     * @param proxyHost
     * @param proxyPort
     */
    public TwitterClientFactory(String consumerKey, String consumerSecret,String proxyHost, int proxyPort) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(consumerKey);
        builder.setOAuthConsumerSecret(consumerSecret);
        builder.setHttpProxyHost(proxyHost);
        builder.setHttpProxyPort(proxyPort);
        Configuration configuration = builder.build();
        TwitterFactory factory = new TwitterFactory(configuration);
        this.twitterFactory = factory;
    }

    /**
     * make a twitterclient
     * @param token
     * @param tokenSecrect
     * @return
     */
    public TwitterClient getInstance(String token, String tokenSecrect){
        Twitter twitter = twitterFactory.getInstance();
        twitter.setOAuthAccessToken(new AccessToken(token,tokenSecrect));
        TwitterClient twitterClient = new TwitterClient(twitter);
        return twitterClient;
    }

    /**
     * @describe 获取授权链接
     * @author guoxubin
     * @date 2016年10月11日
     *
     * @return
     * @throws TwitterException
     */
    public AuthParam authUrl() throws TwitterException {
        Twitter twitter = twitterFactory.getInstance();

        AuthParam authParam = new AuthParam();

        RequestToken requestToken = twitter.getOAuthRequestToken();
        authParam.setAuthUrl(requestToken.getAuthorizationURL());
        authParam.setToken(requestToken.getToken());
        authParam.setTokenSecret(requestToken.getTokenSecret());
        return authParam;
    }

    /**
     * @describe 获取accessToken
     * @author guoxubin
     * @date 2016年10月11日
     *
     * @param token
     * @param tokenSecret
     * @param oauthVerifier
     * @return
     * @throws TwitterException
     */
    public AccessToken getAccessToken(String token, String tokenSecret, String oauthVerifier) throws TwitterException {
        Twitter twitter = twitterFactory.getInstance();
        RequestToken requestToken = new RequestToken(token, tokenSecret);
        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);

        return accessToken;
    }


}

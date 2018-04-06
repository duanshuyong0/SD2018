package com.loonxi.channel.twitter;

import com.loonxi.channel.twitter.api.*;
import com.loonxi.channel.twitter.api.impl.*;
import com.loonxi.channel.twitter.model.AuthParam;
import twitter4j.*;
import twitter4j.api.UsersResources;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * twitter客户端
 * 
 * @describe
 * @author guoxubin
 * @date 2016年10月11日
 *
 */
public class TwitterClient {

	private Twitter twitter;
	private ProfileApi profileApi;
	private DirectMessageApi messageApi;
	private MentionsApi mentionsApi;
	private FriendsApi friendsApi;
	private StatusApi statusApi;

	/**
	 * 构造twitter对象
	 *
	 * @param consumerKey
	 * @param consumerSecret
	 */
	public TwitterClient(String consumerKey, String consumerSecret) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(consumerKey);
		builder.setOAuthConsumerSecret(consumerSecret);
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		twitter = factory.getInstance();

		profileApi = new ProfileApiImpl(twitter);
		messageApi = new DirectMessageApiImpl(twitter);
		mentionsApi = new MentionsApiImpl(twitter);
		friendsApi = new FriendsApiImpl(twitter);
		statusApi = new StatusApiImpl(twitter);
	}

	public TwitterClient(Twitter twitter) {
		this.twitter = twitter;
		profileApi = new ProfileApiImpl(twitter);
		messageApi = new DirectMessageApiImpl(twitter);
		mentionsApi = new MentionsApiImpl(twitter);
		friendsApi = new FriendsApiImpl(twitter);
		statusApi = new StatusApiImpl(twitter);
	}

	/**
	 *
	 * @param twitterConfig
	 */
	public TwitterClient(TwitterConfig twitterConfig) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(twitterConfig.getConsumerKey());
		builder.setOAuthConsumerSecret(twitterConfig.getConsumerSecret());
		// 设置代理
		if (twitterConfig.isSetProxy() == true) {
			if (twitterConfig.getProxyIp() != null && twitterConfig.getProxyIp() != "") {
				builder.setHttpProxyHost(twitterConfig.getProxyIp());
				builder.setHttpProxyPort(twitterConfig.getProxyPort());
			}
		}
		Configuration configuration = builder.build();
		TwitterFactory factory = new TwitterFactory(configuration);
		twitter = factory.getInstance();

		profileApi = new ProfileApiImpl(twitter);
		messageApi = new DirectMessageApiImpl(twitter);
		mentionsApi = new MentionsApiImpl(twitter);
		friendsApi = new FriendsApiImpl(twitter);
		statusApi = new StatusApiImpl(twitter);
	}

	public StatusApi getStatusApi() {
		return statusApi;
	}

	public FriendsApi getFriendsApi() {
		return friendsApi;
	}

	public MentionsApi getMentionsApi() {
		return mentionsApi;
	}

	public DirectMessageApi getMessageApi() {
		return messageApi;
	}

	public ProfileApi getProfileApi() {
		return profileApi;
	}

	/**
	 * @describe 获取授权链接
	 * @author guoxubin
	 * @date 2016年10月11日
	 *
	 * @return
	 * @throws TwitterException
	 * @see "使用 的TwitterFactory.authUrl()
	 *
	 */
	@Deprecated
	public AuthParam authUrl() throws TwitterException {

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
	 * @see "使用 的TwitterFactory.getAccessToken()
	 */
	@Deprecated
	public AccessToken getAccessToken(String token, String tokenSecret, String oauthVerifier) throws TwitterException {
		RequestToken requestToken = new RequestToken(token, tokenSecret);
		AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);

		return accessToken;
	}

	/**
	 * 获取授权用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public User getUserInfo(AccessToken accessToken) throws Exception {
		twitter.setOAuthAccessToken(accessToken);
		UsersResources usersResources = twitter.users();
		User user = usersResources.verifyCredentials();
		return user;
	}

	/**
	 * 发推文
	 * 
	 * @param token
	 * @param tokenSecret
	 * @param context
	 * @return
	 * @throws TwitterException
	 */
	public String postTweet(String token, String tokenSecret, String context) throws TwitterException {

		AccessToken accessToken = new AccessToken(token, tokenSecret);
		twitter.setOAuthAccessToken(accessToken);
		Status status = twitter.updateStatus(context);
		return generateTweetUrl(status.getUser().getScreenName(), status.getId());
	}

	/**
	 * @describe
	 * @author guoxubin
	 * @date 2016年10月11日
	 *
	 * @param token
	 * @param tokenSecret
	 * @param context
	 * @param imgUrl
	 * @return
	 * @throws Exception
	 */
	public String postTweetWithPic(String token, String tokenSecret, String context, String imgUrl) throws Exception {

		if (null == imgUrl || "".equals(imgUrl)) {
			return postTweet(token, tokenSecret, context);
		}
		AccessToken accessToken = new AccessToken(token, tokenSecret);
		twitter.setOAuthAccessToken(accessToken);
		Status status1 = null;
		URLConnection con = null;
		InputStream is = null;
		try {
			URL url = new URL(imgUrl);
			// 打开连接
			con = url.openConnection();
			// 输入流
			is = con.getInputStream();

			StatusUpdate status = new StatusUpdate(context);
			status.setMedia(context, is);

			status1 = twitter.updateStatus(status);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {

				}
			}

		}
		return generateTweetUrl(status1.getUser().getScreenName(), status1.getId());
	}

	/**
	 * 生成预览链接
	 * 
	 * @author guoxubin
	 * @time 下午2:15:37
	 * @param name
	 * @param statusId
	 * @return
	 */
	private String generateTweetUrl(String name, long statusId) {
		String url = "https://twitter.com/" + name + "/status/" + statusId;
		return url;
	}
}

package com.loonxi.channel.twitter.api.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.api.StatusApi;
import com.loonxi.channel.twitter.model.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

/**
 * 推文实现类
 *
 * @author xyy
 * @Date 2016/12/27
 */
public class StatusApiImpl implements StatusApi {
	Twitter twitter;

	static final String TWITTERURL = "https://twitter.com/";
	static final String STATUS = "/status/";

	public StatusApiImpl(Twitter twitter) {
		this.twitter = twitter;
	}

	@Override
	public Status postTweet(String context) throws Exception {
		twitter4j.Status status = twitter.updateStatus(context);
		return TwitterUtil.statusConert(status);
	}

	@Override
	public Status postTweetWithPic(String context, String imgUrl) throws Exception {
		if (null == imgUrl || "".equals(imgUrl)) {
			return postTweet(context);
		}
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

			status1 = TwitterUtil.statusConert(twitter.updateStatus(status));
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

		return status1;
	}

	@Override
	public boolean createFavorite(String statusId) throws Exception {
		twitter.createFavorite(Long.parseLong(statusId));
		return true;
	}

	@Override
	public boolean destroyFavorite(String statusId) throws Exception {
		twitter.destroyFavorite(Long.parseLong(statusId));
		return true;
	}

	@Override
	public boolean destroyStatus(String statusId, String token, String tokenSecret) throws Exception {
		twitter.setOAuthAccessToken(new AccessToken(token, tokenSecret));
		twitter.destroyStatus(Long.parseLong(statusId));
		return true;
	}

	@Override
	public boolean retweetStatus(String statusId) throws Exception {
		twitter.retweetStatus(Long.parseLong(statusId));
		return true;
	}

	@Override
	public Status retweetStatus(String screenName, String statusId, String context)
			throws Exception {
		String retweetURL = TWITTERURL + screenName + STATUS + statusId;
		twitter4j.Status status = twitter.updateStatus(context + " " + retweetURL);
		return TwitterUtil.statusConert(status);
	}

	@Override
	public boolean replyToStatus(String statusId, String message) throws Exception {
		StatusUpdate latestStatus = new StatusUpdate(message);
		latestStatus.setInReplyToStatusId(Long.parseLong(statusId));
		twitter.updateStatus(latestStatus);
		return false;
	}

	@Override
	public Status showStatus(String statusId) throws Exception {
		twitter4j.Status status = twitter.showStatus(Long.parseLong(statusId));
		return TwitterUtil.statusConert(status);
	}

}

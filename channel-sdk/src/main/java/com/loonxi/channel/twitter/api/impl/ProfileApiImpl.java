package com.loonxi.channel.twitter.api.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.api.ProfileApi;
import com.loonxi.channel.twitter.model.Status;
import com.loonxi.channel.twitter.model.Profile;

import twitter4j.*;
import twitter4j.auth.AccessToken;

/**
 * 用户简介实现类
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 */
public class ProfileApiImpl implements ProfileApi {
	private Twitter twitter;

	public ProfileApiImpl(Twitter twitter) {
		this.twitter = twitter;
	}

	@Override
	public Profile searchTwitter(String screenName) throws Exception {
		User user = twitter.showUser(screenName);
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public Profile searchTwitterByUserId(String userId) throws Exception {
		User user = twitter.showUser(Long.parseLong(userId));
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public List<Profile> searchTwitters(String info, int page) throws Exception {
		List<Profile> profiles = new ArrayList<>();
		ResponseList<User> users = twitter.searchUsers(info, page);
		users.stream().forEach(user -> profiles.add(TwitterUtil.twitter4jUser2Profile(user)));
		return profiles;
	}

	@Override
	public Profile getAccountProfile() throws Exception {
		return TwitterUtil.twitter4jUser2Profile(twitter.verifyCredentials());
	}

	@Override
	public List<Profile> getAccountProfile(String... userId) throws Exception {
		List<User> users = twitter.lookupUsers(convertLong(userId));
		List<Profile> profiles = new ArrayList<Profile>();
		for (int i = 0; i < users.size(); i++) {
			profiles.add(TwitterUtil.twitter4jUser2Profile(users.get(i)));
		}
		return profiles;
	}

	private long[] convertLong(String... userId) {
		long[] num = new long[userId.length];
		for (int idx = 0; idx < userId.length; idx++) {
			num[idx] = Long.parseLong(userId[idx]);
		}
		return num;
	}

	@Override
	public List<Status> getHomeTimeline() throws Exception {
		List<Status> homeTimeline = new ArrayList<Status>();
		List<twitter4j.Status> status = twitter.getHomeTimeline();

		for (int i = 0; i < status.size(); i++) {
			homeTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return homeTimeline;
	}

	@Override
	public List<Status> getHomeTimeline(String sinceId) throws Exception {
		List<Status> homeTimeline = new ArrayList<>();

		Paging page = new Paging();
		page.count(200);
		page.setSinceId(Long.parseLong(sinceId));

		List<twitter4j.Status> status = twitter.getHomeTimeline(page);
		for (int i = 0; i < status.size(); i++) {
			homeTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return homeTimeline;
	}

	@Override
	public Profile updateProfileImage(File image) throws Exception {
		return TwitterUtil.twitter4jUser2Profile(twitter.updateProfileImage(image));
	}

	@Override
	public List<Status> getUserTimeline() throws Exception {
		List<Status> userTimeline = new ArrayList<Status>();
		List<twitter4j.Status> status = twitter.getUserTimeline();

		for (int i = 0; i < status.size(); i++) {
			userTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return userTimeline;
	}

	@Override
	public List<Status> getUserTimeline(String id) throws Exception {
		Paging page = new Paging();
		page.count(20);
		page.setSinceId(Long.parseLong(id));

		List<Status> userTimeline = new ArrayList<Status>();
		List<twitter4j.Status> status = twitter.getUserTimeline(page);

		for (int i = 0; i < status.size(); i++) {
			userTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return userTimeline;
	}

	@Override
	public List<Status> getUserTimelineById(String userId) throws Exception {
		List<Status> userTimeline = new ArrayList<Status>();
		List<twitter4j.Status> status = twitter.getUserTimeline(Long.parseLong(userId));

		for (int i = 0; i < status.size(); i++) {
			userTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return userTimeline;
	}

	@Override
	public List<Status> getUserTimelineById(String id, String userId)
			throws Exception {
		Paging page = new Paging();
		page.count(20);
		page.setSinceId(Long.parseLong(id));

		List<Status> userTimeline = new ArrayList<Status>();
		List<twitter4j.Status> status = twitter.getUserTimeline(Long.parseLong(userId), page);

		for (int i = 0; i < status.size(); i++) {
			userTimeline.add(TwitterUtil.statusConert(status.get(i)));
		}

		return userTimeline;
	}

}

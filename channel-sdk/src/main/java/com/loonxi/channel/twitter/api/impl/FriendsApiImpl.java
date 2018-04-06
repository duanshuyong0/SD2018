package com.loonxi.channel.twitter.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.api.FriendsApi;
import com.loonxi.channel.twitter.model.PagableResponse;
import com.loonxi.channel.twitter.model.Profile;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.User;
import twitter4j.auth.AccessToken;

/**
 * 好友实现类
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 */
public class FriendsApiImpl implements FriendsApi {
	private Twitter twitter;

	public FriendsApiImpl(Twitter twitter) {
		this.twitter = twitter;
	}

	@Override
	public Profile createFriendshipById(String userId) throws Exception {
		User user = twitter.createFriendship(Long.valueOf(userId));
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public Profile createFriendshipByName(String screenName) throws Exception {
		User user = twitter.createFriendship(screenName);
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public Profile destroyFriendshipById(String userId) throws Exception {
		User user = twitter.destroyFriendship(userId);
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public Profile destroyFriendshipByName(String screenName) throws Exception {
		User user = twitter.destroyFriendship(screenName);
		return TwitterUtil.twitter4jUser2Profile(user);
	}

	@Override
	public PagableResponse<Profile> getFriendsById(String userId, long cursor)
			throws Exception {
		PagableResponseList<twitter4j.User> users = twitter.getFriendsList(Long.parseLong(userId),cursor);
		return getFriends(users);
	}

	@Override
	public PagableResponse<Profile> getFollowsById(String userId,int count, long cursor) throws Exception {
		if(count==0){
			count = 20;
		}
		PagableResponseList<twitter4j.User> users = twitter.getFollowersList(Long.parseLong(userId), cursor, count);
		return getFriends(users);
	}

	private PagableResponse<Profile> getFriends(PagableResponseList<twitter4j.User> users) {
		PagableResponse<Profile> p = new PagableResponse<>();
		p.setHasPrevious(users.hasPrevious());
		p.setHasNext(users.hasNext());
		p.setPreviousCursor(users.getPreviousCursor());
		p.setNextCursor(users.getNextCursor());

		List<Profile> profiles = new ArrayList<>();
		for (int i = 0; i < users.size(); i++) {
			twitter4j.User u = users.get(i);
			profiles.add(TwitterUtil.twitter4jUser2Profile(u));
		}
		p.setProfiles(profiles);
		return p;
	}

	@Override
	public PagableResponse<Profile> getFriendsByName(String screenName, long cursor)
			throws Exception {
		PagableResponseList<twitter4j.User> users = twitter.getFriendsList(screenName, cursor);
		return getFriends(users);
	}

	@Override
	public PagableResponse<Profile> getFriendsById(String userId, long cursor, int count) throws Exception {
		PagableResponseList<twitter4j.User> users = twitter.getFriendsList(Long.parseLong(userId), cursor, count);
		return getFriends(users);
	}

	@Override
	public PagableResponse<Profile> getFriendsByName(String screenName, long cursor, int count) throws Exception {
		PagableResponseList<twitter4j.User> users = twitter.getFriendsList(screenName, cursor, count);
		return getFriends(users);
	}

}

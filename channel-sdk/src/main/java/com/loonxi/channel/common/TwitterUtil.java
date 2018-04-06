package com.loonxi.channel.common;

import com.loonxi.channel.twitter.model.DirectMessage;
import com.loonxi.channel.twitter.model.Entity;
import com.loonxi.channel.twitter.model.MediaEntity;
import com.loonxi.channel.twitter.model.MessageUser;
import com.loonxi.channel.twitter.model.Profile;
import com.loonxi.channel.twitter.model.Status;
import com.loonxi.channel.twitter.model.URLEntity;
import com.loonxi.channel.twitter.model.VideoVariant;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;

/**
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月25日
 * @since 1.0
 */
public class TwitterUtil {
	// twitter 对象缓存，consumerKey 作为key 一般只有一个对象。
	private static Map<String, Twitter> twitterMap = new HashMap<>();

	public static void setAccessToekn(Twitter twitter, AccessToken accessToken) {
		twitter.setOAuthAccessToken(accessToken);
	}

	public static Twitter generateTwitter(String consumerKey, String consumerSecret, String token, String tokenSecret) {
		Twitter newTwitter = null;
		if (twitterMap.containsKey(consumerKey) && twitterMap.get(consumerKey) != null) {
			newTwitter = twitterMap.get(consumerKey);
			// 清空accessToken
			newTwitter.setOAuthAccessToken(null);
		} else {
			ConfigurationBuilder builder = new ConfigurationBuilder();

			builder.setHttpProxyHost("127.0.0.1");
			builder.setHttpProxyPort(1080);

			builder.setOAuthConsumerKey(consumerKey);
			builder.setOAuthConsumerSecret(consumerSecret);
			Configuration configuration = builder.build();
			TwitterFactory factory = new TwitterFactory(configuration);
			Twitter twitter = factory.getInstance();
			twitterMap.put(consumerKey, twitter);
			newTwitter = twitter;
		}

		AccessToken accessToken = new AccessToken(token, tokenSecret);
		newTwitter.setOAuthAccessToken(accessToken);
		return newTwitter;

	}

	/**
	 * 将 twitter4j 中的 status 对象转成channel-sdk中封装的 status 对象
	 *
	 * @param status
	 * @return
	 */
	public static Status statusConert(twitter4j.Status status) {
		if (status == null) {
			return null;
		}

		Status status1 = new Status();
		// status 基本信息
		status1.setId(String.valueOf(status.getId()));
		status1.setContent(status.getText());
		status1.setCreatedAt(status.getCreatedAt().getTime());
		status1.setFavouritesCcount(status.getFavoriteCount());
		status1.setRetweetCount(status.getRetweetCount());

		status1.setFavorited(status.isFavorited());

		// 封装 entity
		Entity entity = new Entity();
		twitter4j.URLEntity[] urlEntities = status.getURLEntities();
		if (urlEntities != null && urlEntities.length > 0) {
			List<URLEntity> urlList = new ArrayList<>();
			Arrays.stream(urlEntities)
					.forEach(e -> urlList.add(new URLEntity(e.getDisplayURL(), e.getExpandedURL(), e.getURL())));
			entity.setUrls(urlList);
		}
		twitter4j.MediaEntity[] mediaEntities = status.getMediaEntities();
		if (mediaEntities != null && mediaEntities.length > 0) {
			List<MediaEntity> photoes = new ArrayList<>();
			Arrays.stream(mediaEntities).forEach(e -> {
				List<VideoVariant> videoVariants = new ArrayList<>();
				twitter4j.MediaEntity.Variant[] video = e.getVideoVariants();
				Arrays.stream(video).forEach(item -> {
					videoVariants.add(new VideoVariant(item.getContentType(), item.getUrl()));
				});
				photoes.add(new MediaEntity(e.getDisplayURL(), e.getExpandedURL(), e.getMediaURLHttps(), e.getType(),
						videoVariants));

			});

			entity.setMediaEntity(photoes);
		}
		UserMentionEntity[] userMentionEntities = status.getUserMentionEntities();
		if (userMentionEntities != null && userMentionEntities.length > 0) {
			List<MessageUser> messageUsers = new ArrayList<>();
			Arrays.stream(userMentionEntities).forEach(
					e -> messageUsers.add(new MessageUser(String.valueOf(e.getId()), e.getName(), e.getScreenName())));
			entity.setMessageUsers(messageUsers);
		}
		status1.setEntity(entity);

		// Profile profile
		Profile profile = new Profile();
		if (status.getUser() != null) {
			profile.setId(String.valueOf(status.getUser().getId()));
			profile.setName(status.getUser().getName());
			profile.setScreenName(status.getUser().getScreenName());
			profile.setAttar(status.getUser().getMiniProfileImageURLHttps());
			profile.setLocation(status.getUser().getLocation());
			profile.setCreatedAt(status.getUser().getCreatedAt().getTime());
			profile.setDescription(status.getUser().getDescription());
			profile.setStatusesCount(status.getUser().getStatusesCount());
			profile.setFavouritesCount(status.getUser().getFavouritesCount());
			profile.setFollowersCount(status.getUser().getFollowersCount());
			profile.setFriendsCount(status.getUser().getFriendsCount());
			status1.setProfile(profile);
		}

		// Status quotedStatus
		Status quotedStatus = statusConert(status.getQuotedStatus());
		status1.setQuotedStatus(quotedStatus);

		// Status InReply2Status
		if (status.getInReplyToStatusId() > 0) {
			Status inReply2Status = new Status();
			inReply2Status.setId(String.valueOf(status.getInReplyToStatusId()));
			Profile inReply2StatusProfile = new Profile();
			inReply2StatusProfile.setScreenName(status.getInReplyToScreenName());
			inReply2StatusProfile.setId(String.valueOf(status.getInReplyToUserId()));
			inReply2Status.setProfile(inReply2StatusProfile);
			status1.setInReply2Status(inReply2Status);
		}
		return status1;
	}

	/**
	 * 将 twitter4j 中的user对象转成channel-sdk中封装的 Profile对象
	 *
	 * @param user
	 * @return
	 */
	public static Profile twitter4jUser2Profile(User user) {
		if (user == null) {
			return null;
		}
		Profile profile = new Profile();
		profile.setId(String.valueOf(user.getId()));
		profile.setName(user.getName());
		profile.setScreenName(user.getScreenName());
		profile.setDescription(user.getDescription());
		profile.setCreatedAt(user.getCreatedAt().getTime());
		profile.setFavouritesCount(user.getFavouritesCount());
		profile.setFollowersCount(user.getFollowersCount());
		profile.setFriendsCount(user.getFriendsCount());
		profile.setAttar(user.getProfileImageURLHttps());
		profile.setStatusesCount(user.getStatusesCount());
		profile.setLocation(user.getLocation());

		URLEntity uRLEntity = new URLEntity();
		uRLEntity.setDisplayURL(user.getURLEntity().getDisplayURL());
		uRLEntity.setExpandedURL(user.getURLEntity().getExpandedURL());
		uRLEntity.setuRL(user.getURLEntity().getURL());
		profile.setuRLEntity(uRLEntity);

		List<Status> statusList = new ArrayList<>();
		statusList.add(TwitterUtil.statusConert(user.getStatus()));
		profile.setStatuses(statusList);
		return profile;
	}

	/**
	 * 将 twitter4j 中的 DirectMessage 对象转成channel-sdk中封装的 DirectMessage 对象
	 *
	 * @param status
	 * @return
	 */
	public static DirectMessage directMessageConert(twitter4j.DirectMessage directMessage) {
		if (directMessage == null) {
			return null;
		}

		DirectMessage directMessage1 = new DirectMessage();
		// directMessage 基本信息
		directMessage1.setId(Long.toString(directMessage.getId()));
		directMessage1.setCreatedAt(directMessage.getCreatedAt().getTime());
		directMessage1.setContent(directMessage.getText());
		directMessage1.setRecipient(TwitterUtil.twitter4jUser2Profile(directMessage.getRecipient()));
		directMessage1.setSender(TwitterUtil.twitter4jUser2Profile(directMessage.getSender()));

		// 封装 entity
		Entity entity = new Entity();
		twitter4j.URLEntity[] urlEntities = directMessage.getURLEntities();
		if (urlEntities != null && urlEntities.length > 0) {
			List<URLEntity> urlList = new ArrayList<>();
			Arrays.stream(urlEntities)
					.forEach(e -> urlList.add(new URLEntity(e.getDisplayURL(), e.getExpandedURL(), e.getURL())));
			entity.setUrls(urlList);
		}
		twitter4j.MediaEntity[] mediaEntities = directMessage.getMediaEntities();
		if (mediaEntities != null && mediaEntities.length > 0) {
			List<MediaEntity> photoes = new ArrayList<>();
			Arrays.stream(mediaEntities).forEach(e -> {
				List<VideoVariant> videoVariants = new ArrayList<>();
				twitter4j.MediaEntity.Variant[] video = e.getVideoVariants();
				Arrays.stream(video).forEach(item -> {
					videoVariants.add(new VideoVariant(item.getContentType(), item.getUrl()));
				});
				photoes.add(new MediaEntity(e.getDisplayURL(), e.getExpandedURL(), e.getMediaURLHttps(), e.getType(),
						videoVariants));

			});

			entity.setMediaEntity(photoes);

		}
		UserMentionEntity[] userMentionEntities = directMessage.getUserMentionEntities();
		if (userMentionEntities != null && userMentionEntities.length > 0) {
			List<MessageUser> messageUsers = new ArrayList<>();
			Arrays.stream(userMentionEntities).forEach(
					e -> messageUsers.add(new MessageUser(String.valueOf(e.getId()), e.getName(), e.getScreenName())));
			entity.setMessageUsers(messageUsers);
		}
		directMessage1.setEntities(entity);

		return directMessage1;
	}

}

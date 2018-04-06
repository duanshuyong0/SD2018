package com.loonxi.channel.twitter;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.twitter.model.*;
import com.loonxi.channel.twitter.streamApi.UserListener;
import twitter4j.*;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2016/12/29
 */
public class StreamApiTest {
    public static void main(String[] args) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(XyyCredential.consumerKey); // 设置consumerKey
        configurationBuilder.setOAuthConsumerSecret(XyyCredential.consumerSecrect); // 设置consumerSecret
        configurationBuilder.setJSONStoreEnabled(true);
        Configuration configuration = configurationBuilder.build();
        TwitterStreamFactory tf = new TwitterStreamFactory(configuration);
        TwitterStream twitterStream = tf.getInstance();
        AccessToken accessToken = new AccessToken(XyyCredential.accessToken, XyyCredential.accessTokenSecret); // 设置access token
        System.out.println("AccessToken:" + accessToken);
        twitterStream.setOAuthAccessToken(accessToken); // twitterStream实例用于侦听用户推文


        twitterStream.addListener(new UserListener() {
            @Override
            protected void retweet(com.loonxi.channel.twitter.model.Status status) {
                System.out.println(status);
            }

            @Override
            protected void favoute(Profile source, Profile target, com.loonxi.channel.twitter.model.Status staus) {
                System.out.println(source);
                System.out.println(target);
                System.out.println(staus);

            }

            @Override
            protected void quotedTweet(Profile source, Profile target, com.loonxi.channel.twitter.model.Status quotingTweet) {
                System.out.println(JSON.toJSON(source));
                System.out.println(JSON.toJSON(target));
                System.out.println(JSON.toJSON(quotingTweet));
            }

            @Override
            protected void follow(Profile source, Profile followedUser) {
                System.out.println(source);
                System.out.println(followedUser);
            }
        }); // 这里加入了listener用于处理侦听推文
        /*FilterQuery query = new FilterQuery();
        query.follow(new long[] { userId }); // userId 是在Twitter App页面中的用户ID
        twitterStream.filter(query);*/
        twitterStream.user();
    }

    static UserStreamListener userStreamListener = new UserStreamListener(){


        @Override
        public void onException(Exception ex) {

        }

        @Override
        public void onStatus(Status status) {

        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

        }

        @Override
        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

        }

        @Override
        public void onScrubGeo(long userId, long upToStatusId) {

        }

        @Override
        public void onStallWarning(StallWarning warning) {

        }

        @Override
        public void onDeletionNotice(long directMessageId, long userId) {

        }

        @Override
        public void onFriendList(long[] friendIds) {

        }

        @Override
        public void onFavorite(User source, User target, Status favoritedStatus) {
            System.out.println("有人给我的文章点赞啦，哈哈哈");
            System.out.println(source.toString());
            System.out.println(target.toString());
        }

        @Override
        public void onUnfavorite(User source, User target, Status unfavoritedStatus) {

        }

        @Override
        public void onFollow(User source, User followedUser) {

        }

        @Override
        public void onUnfollow(User source, User unfollowedUser) {

        }

        @Override
        public void onDirectMessage(DirectMessage directMessage) {

        }

        @Override
        public void onUserListMemberAddition(User addedMember, User listOwner, UserList list) {

        }

        @Override
        public void onUserListMemberDeletion(User deletedMember, User listOwner, UserList list) {

        }

        @Override
        public void onUserListSubscription(User subscriber, User listOwner, UserList list) {

        }

        @Override
        public void onUserListUnsubscription(User subscriber, User listOwner, UserList list) {

        }

        @Override
        public void onUserListCreation(User listOwner, UserList list) {

        }

        @Override
        public void onUserListUpdate(User listOwner, UserList list) {

        }

        @Override
        public void onUserListDeletion(User listOwner, UserList list) {

        }

        @Override
        public void onUserProfileUpdate(User updatedUser) {

        }

        @Override
        public void onUserSuspension(long suspendedUser) {

        }

        @Override
        public void onUserDeletion(long deletedUser) {

        }

        @Override
        public void onBlock(User source, User blockedUser) {

        }

        @Override
        public void onUnblock(User source, User unblockedUser) {

        }

        @Override
        public void onRetweetedRetweet(User source, User target, Status retweetedStatus) {
            System.out.println("转推了");
            System.out.println(source.toString());
            System.out.println(target.toString());
        }

        @Override
        public void onFavoritedRetweet(User source, User target, Status favoritedRetweeet) {

        }

        @Override
        public void onQuotedTweet(User source, User target, Status quotingTweet) {

        }
    };

}

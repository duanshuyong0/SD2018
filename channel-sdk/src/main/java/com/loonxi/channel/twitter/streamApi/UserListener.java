package com.loonxi.channel.twitter.streamApi;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.model.*;
import twitter4j.*;
import twitter4j.DirectMessage;
import twitter4j.Status;

/**
 * xxx.
 *
 * @author xyy
 * @Date 2017/1/3
 */
public abstract class UserListener implements UserStreamListener{

    /**
     * 转推
     */
    protected abstract void retweet(com.loonxi.channel.twitter.model.Status status);

    /**
     * A引用了 B 的推文
     * @param source A
     * @param target B
     * @param quotingTweet A的推文
     */
    protected abstract void quotedTweet(Profile source, Profile target, com.loonxi.channel.twitter.model.Status quotingTweet);

    /**
     * 点赞 A点赞B的一片推文
     * @param source A
     * @param target B
     * @param staus 推文
     */
    protected abstract void favoute(Profile source, Profile target, com.loonxi.channel.twitter.model.Status staus);

    /**
     * A 关注了 B
     * @param source A
     * @param followedUser  B 被关注的人
     */
    protected abstract void follow(Profile source, Profile followedUser);

    @Override
    public void onDeletionNotice(long directMessageId, long userId) {

    }

    @Override
    public void onFriendList(long[] friendIds) {

    }

    @Override
    public void onFavorite(User source, User target, Status favoritedStatus) {
        Profile souurce1 = TwitterUtil.twitter4jUser2Profile(source);
        Profile target1 = TwitterUtil.twitter4jUser2Profile(target);
        com.loonxi.channel.twitter.model.Status staus1 = TwitterUtil.statusConert(favoritedStatus);
        favoute(souurce1, target1, staus1);
    }

    @Override
    public void onUnfavorite(User source, User target, Status unfavoritedStatus) {

    }

    @Override
    public void onFollow(User source, User followedUser) {
        Profile souurce1 = TwitterUtil.twitter4jUser2Profile(source);
        Profile followedUser1 = TwitterUtil.twitter4jUser2Profile(followedUser);
        follow(souurce1, followedUser1);
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

    }

    @Override
    public void onFavoritedRetweet(User source, User target, Status favoritedRetweeet) {

    }

    @Override
    public void onQuotedTweet(User source, User target, Status quotingTweet) {
        Profile souurce1 = TwitterUtil.twitter4jUser2Profile(source);
        Profile target1 = TwitterUtil.twitter4jUser2Profile(target);
        com.loonxi.channel.twitter.model.Status staus1 = TwitterUtil.statusConert(quotingTweet);
        quotedTweet(souurce1,target1,staus1);
    }

    @Override
    public void onStatus(Status status) {
        // 如果推文内容是以 RT 开头， 则是转推
        if(status.getText().startsWith("RT")){
            com.loonxi.channel.twitter.model.Status staus1 = TwitterUtil.statusConert(status);
            retweet(staus1);
        }
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
    public void onException(Exception ex) {

    }
}

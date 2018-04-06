package com.loonxi.channel.twitter.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.api.DirectMessageApi;
import com.loonxi.channel.twitter.model.DirectMessage;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

/**
 * 私信实现类
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月28日
 * @since 1.0
 */
public class DirectMessageApiImpl implements DirectMessageApi {
	private Twitter twitter;

	public DirectMessageApiImpl(Twitter twitter) {
		this.twitter = twitter;
	}

	@Override
	public List<DirectMessage> getDirectMessages(int count) throws Exception {
		Paging paging = new Paging();
		if(count!=0){
			paging.setCount(count);
		}
		List<twitter4j.DirectMessage> directMessages = twitter.getDirectMessages(paging);
		return getDirectMessages(directMessages);
	}

	@Override
	public List<DirectMessage> getDirectMessages(int count, String sindId) throws Exception {
		Paging paging = new Paging();
		if(count!=0){
			paging.setCount(count);
		}
		if(sindId!=null && !"".equals(sindId)){
			//TODO 可能会报错
			paging.setSinceId(Long.parseLong(sindId));
		}
		List<twitter4j.DirectMessage> directMessages = twitter.getDirectMessages(paging);
		return getDirectMessages(directMessages);
	}

	private List<DirectMessage> getDirectMessages(List<twitter4j.DirectMessage> directMessages) {
		List<DirectMessage> messages = new ArrayList<>();
		for (int i = 0; i < directMessages.size(); i++) {
			twitter4j.DirectMessage directMessage = directMessages.get(i);
			DirectMessage message = TwitterUtil.directMessageConert(directMessage);
			messages.add(message);
		}

		return messages;
	}

	@Override
	public List<DirectMessage> getSentDirectMessages(int count) throws Exception {
		Paging paging = new Paging();
		if(count!=0){
			paging.setCount(count);
		}
		List<twitter4j.DirectMessage> directMessages = twitter.getSentDirectMessages(paging);
		return getDirectMessages(directMessages);

	}

	@Override
	public List<DirectMessage> getSentDirectMessages(int count, String sinceId) throws Exception {
		Paging paging = new Paging();
		if(count!=0){
			paging.setCount(count);
		}
		if(sinceId!=null && !"".equals(sinceId)){
			//TODO 可能会报错
			paging.setSinceId(Long.parseLong(sinceId));
		}
		List<twitter4j.DirectMessage> directMessages = twitter.getSentDirectMessages(paging);
		return getDirectMessages(directMessages);

	}

	@Override
	public DirectMessage sendDirectMessageByName(String screenName, String text)
			throws Exception {
		return TwitterUtil.directMessageConert(twitter.sendDirectMessage(screenName, text));
	}

	@Override
	public DirectMessage sendDirectMessageById(String userId, String text)
			throws Exception {
		return TwitterUtil.directMessageConert(twitter.sendDirectMessage(Long.parseLong(userId), text));
	}

	@Override
	public DirectMessage destroyDirectMessage(String messageId) throws Exception {
		return TwitterUtil.directMessageConert(twitter.destroyDirectMessage(Long.parseLong(messageId)));
	}

}

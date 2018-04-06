package com.loonxi.channel.twitter.api.impl;

import java.util.ArrayList;
import java.util.List;

import com.loonxi.channel.common.TwitterUtil;
import com.loonxi.channel.twitter.api.MentionsApi;
import com.loonxi.channel.twitter.model.Status;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;

/**
 * 获取@列表实现类
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月28日
 * @since 1.0
 */
public class MentionsApiImpl implements MentionsApi {

	private Twitter twitter;

	public MentionsApiImpl(Twitter twitter) {
		this.twitter = twitter;
	}

	@Override
	public List<Status> getMentions(int count) throws Exception {
		return getMentions(count,null);
	}

	@Override
	public List<Status> getMentions(int count, String sinceId) throws Exception {
		Paging page = new Paging();
		if(sinceId!=null && !"".equals(sinceId)){
			//TODO 这里有可能出现转化错误
			page.setSinceId(Long.valueOf(sinceId));
		}
		if(count!=0){
			page.setCount(count);
		}
		List<twitter4j.Status> status = twitter.getMentionsTimeline(page);
		return getMentions(status);
	}

	private List<Status> getMentions(List<twitter4j.Status> status) {
		List<Status> mentions = new ArrayList<>();
		for (int i = 0; i < status.size(); i++) {
			twitter4j.Status statu = status.get(i);
			Status mention = TwitterUtil.statusConert(statu);
			mentions.add(mention);
		}
		return mentions;
	}

	private Paging getPaging(long id) {
		Paging page = new Paging();
		page.setSinceId(id);
		page.count(800);
		return page;
	}

}

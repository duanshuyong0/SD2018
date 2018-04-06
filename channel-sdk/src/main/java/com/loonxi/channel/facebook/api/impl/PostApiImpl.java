package com.loonxi.channel.facebook.api.impl;

import com.loonxi.channel.facebook.api.PostApi;
import com.loonxi.channel.facebook.api.convert.FBPostConvert;
import com.loonxi.channel.facebook.model.FBPageQuery;
import com.loonxi.channel.facebook.model.FBPaging;
import com.loonxi.channel.facebook.model.FBPost;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月4日
 * @since 1.0
 */
public class PostApiImpl implements PostApi {

	private Facebook facebook;
	private String[] readingFileds = {"parent_id","attachments","created_time",
			"from","message_tags","link","message",
			"permalink_url","comments.limit(20){comments.limit(20){id,message,from,created_time},id,message,from,created_time}"};

	public PostApiImpl(Facebook facebook) {
		this.facebook = facebook;
	}


	@Override
	public String createPost(String targetId, String message) throws FacebookException {
		PostUpdate postUpdate = new PostUpdate(message);
		String postId = facebook.postFeed(targetId, postUpdate);
		return postId;
	}

	@Override
	public boolean delete(String postId) throws FacebookException {
		return facebook.deletePost(postId);
	}

	@Override
	public FBPost getPost(String postId) throws FacebookException {
		Reading reading = new Reading();
		reading.fields(readingFileds);
		Post post = facebook.getPost(postId, reading);
		//封装成 FBPost
		return new FBPostConvert().modelConvert(post);
	}

	@Override
	public FBPaging<FBPost> pageTimeline(String pageId, FBPageQuery fbPageQuery) throws FacebookException {
		Reading reading = new Reading();
		DataConvertUtil.buildReadingByFBPageQuery(fbPageQuery,reading);
		reading.fields(readingFileds);
		ResponseList<Post> posts = facebook.getPosts(pageId,reading);
		return new FBPostConvert().pageConvert(posts);
	}

	@Override
	public FBPaging<FBPost> search(String info, FBPageQuery fbPageQuery) throws FacebookException {

		Reading reading = new Reading();
		DataConvertUtil.buildReadingByFBPageQuery(fbPageQuery,reading);
		reading.fields(readingFileds);
		ResponseList<Post> posts = facebook.searchPosts(info, reading);

		return new FBPostConvert().pageConvert(posts);
	}

	@Override
	public boolean like(String postId) throws FacebookException {
		return facebook.likePost(postId);
	}

	@Override
	public boolean unlike(String postId) throws FacebookException {
		return facebook.unlikePost(postId);
	}

	@Override
	public List<FBbaseProfile> likes(String postId) throws FacebookException {
		List<FBbaseProfile> list = new ArrayList<>();
		Reading reading = new Reading();
		reading.limit(200);
		ResponseList<Like> likes = facebook.getPostLikes(postId,reading);
		for (Like like : likes){
			FBbaseProfile fBbaseProfile = new FBbaseProfile(like.getId(),like.getName());
			list.add(fBbaseProfile);
		}
		return list;
	}

}

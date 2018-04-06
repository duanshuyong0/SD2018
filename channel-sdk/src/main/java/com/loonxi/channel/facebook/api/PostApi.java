package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.FBPageQuery;
import com.loonxi.channel.facebook.model.FBPaging;
import com.loonxi.channel.facebook.model.FBPost;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.FacebookException;
import facebook4j.Post;

import java.util.List;

/**
 * facebook原创文(post)接口
 * https://developers.facebook.com/docs/graph-api/reference/v2.8/post/
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月3日
 * @since 1.0
 *
 * post的地址格式是：https://www.facebook.com/{pagename}/posts/postId
 * https://www.facebook.com/boxrecyclegood/posts/1367145513327305
 */
public interface PostApi {

	/**
	 * 注意目前只能在自己的个人主页和别人的公共主页发帖
	 * @param targetId userID, pageId, 等， 帖子发到谁的公共主页
	 * @param message
	 * @return
	 */
	String createPost(String targetId, String message) throws FacebookException;

	/**
	 * 只能删除自己主页上的帖子，不能删除自己发在别人主页上的帖子
	 * @param postId
	 * @return
	 * @throws FacebookException
	 */
	boolean delete(String postId) throws FacebookException;

	/**
	 * 引用帖子的信息只能拿到id，分享的时候，会自动把他的图片也分享过来。
	 * 帖子的评论数量默认显示前20条，评论的回复也默认显示该条评论的前20条，支持分页
	 * @param postId
	 * @return
	 * @throws FacebookException
	 */
	FBPost getPost(String postId) throws FacebookException;

	/**
	 * 获取某个主页下的帖子
	 * 搜索帖子 paging 中 只返回 上一页和下一页的 url
	 * 怎样通过接口获取下一页的数据呢
	 * 帖子下的评论最新200条； 评论的回复也最多200条
	 * @param pageId
	 * @param fbPageQuery
	 * @return
	 * @throws FacebookException
	 */
	FBPaging<FBPost> pageTimeline(String pageId, FBPageQuery fbPageQuery) throws FacebookException;

	/**
	 * 搜索一个帖子
	 * @param info
	 * @param fbPageQuery
	 * @return
	 * @throws FacebookException
	 */
	FBPaging<FBPost> search(String info,FBPageQuery fbPageQuery) throws FacebookException;

	boolean like(String postId) throws FacebookException;

	boolean unlike(String postId) throws FacebookException;

	/**
	 * 获取最多前200个
	 * @param postId
	 * @return
	 */
	List<FBbaseProfile> likes(String postId) throws FacebookException;
}

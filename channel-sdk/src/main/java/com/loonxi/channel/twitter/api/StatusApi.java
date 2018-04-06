package com.loonxi.channel.twitter.api;

import com.loonxi.channel.twitter.model.Status;

/**
 * 推文接口
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月25日
 * @since 1.0
 */
public interface StatusApi {
	
	/**
	 * 发推文
	 * 
	 * @author chenjingyun
	 * @time 上午9:24:49  
	 * @param context
	 * @return
	 * @throws Exception
	 */
	Status postTweet(String context) throws Exception;

	/**
	 * 发推文带图片
	 * 
	 * @author chenjingyun
	 * @time 上午9:53:10
	 * @param context
	 * @param imgUrl
	 * @return
	 * @throws Exception
	 */
	Status postTweetWithPic(String context, String imgUrl) throws Exception;
	
	/**
	 * 推文点攒
	 * 
	 * @author chenjingyun
	 * @time 下午9:18:04
	 * @param statusId
	 * @return
	 * @throws Exception
	 */
	boolean createFavorite(String statusId) throws Exception;

	/**
	 * 推文取消点攒
	 * 
	 * @author chenjingyun
	 * @time 下午9:18:52
	 * @param statusId
	 * @return
	 * @throws Exception
	 * @see https://dev.twitter.com/rest/reference/post/favorites/create
	 */
	boolean destroyFavorite(String statusId) throws Exception;

	/**
	 * 删除推文（推文/回复/转推）
	 * 
	 * @param statusId
	 * @param token
	 * @param tokenSecret
	 * @return
	 */
	boolean destroyStatus(String statusId, String token, String tokenSecret) throws Exception;

	/**
	 * 转推 TODO 转推不能带评论
	 * 暂时不使用
	 * 
	 * @author chenjingyun
	 * @time 下午9:34:45
	 * @param statusId
	 * @return
	 * @throws Exception
	 * @see https://dev.twitter.com/rest/reference/post/statuses/retweet/id
	 */
	boolean retweetStatus(String statusId) throws Exception;

	/**
	 * 转推并编写评论，等同于发推文并引用别的推文
	 * 
	 * @author chenjingyun
	 * @time 下午1:40:08  
	 * @param screenName 原推文的
	 * @param statusId
	 * @param context 不能为null
	 * @return
	 * @throws Exception
	 */
	Status retweetStatus(String screenName,String statusId,String context) throws Exception;

	/**
	 * 回复推文
	 * 
	 * @author chenjingyun
	 * @time 下午9:51:26
	 * @param statusId
	 *            必须带@chenjingyun1
	 * @return
	 * @throws Exception
	 */
	boolean replyToStatus(String statusId, String message) throws Exception;

	/**
	 * 推文查询
	 * 
	 * @author chenjingyun
	 * @time 下午9:52:56
	 * @param statusId
	 * @return
	 * @throws Exception
	 */
	Status showStatus(String statusId) throws Exception;

}

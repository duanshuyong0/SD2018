package com.loonxi.channel.twitter.api;

import com.loonxi.channel.twitter.model.PagableResponse;
import com.loonxi.channel.twitter.model.Profile;

/**
 * 添加删除好友接口
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月25日
 * @since 1.0
 */
public interface FriendsApi {
	/**
	 * 添加好友
	 * 
	 * @author chenjingyun
	 * @time 上午11:17:59
	 * @param userId
	 *            用户id
	 * @return
	 * @throws Exception
	 *
	 */
	Profile createFriendshipById(String userId) throws Exception;

	/**
	 * 添加好友
	 * 
	 * @author chenjingyun
	 * @time 下午3:03:44
	 * @param screenName
	 *            用户显示名称
	 * @return
	 * @throws Exception
	 */
	Profile createFriendshipByName(String screenName) throws Exception;

	/**
	 * 删除好友
	 * 
	 * @author chenjingyun
	 * @time 下午3:21:22
	 * @param userId
	 *            用户id
	 * @return
	 * @throws Exception
	 */
	Profile destroyFriendshipById(String userId) throws Exception;

	/**
	 * 删除好友
	 * 
	 * @author chenjingyun
	 * @time 下午3:21:35
	 * @param screenName
	 *            用户名称
	 * @return
	 * @throws Exception
	 */
	Profile destroyFriendshipByName(String screenName) throws Exception;

	/**
	 * 授权用户关注的好友列表
	 * 
	 * @author chenjingyun
	 * @time 下午5:59:01
	 * @param userId
	 * @param cursor
	 *            页码，初值－1
	 * @param count
	 *            每页数量
	 * @return
	 * @throws Exception
	 */
	PagableResponse<Profile> getFriendsById(String userId, long cursor, int count)
			throws Exception;

	/**
	 * 授权用户关注的好友列表
	 * 
	 * @author chenjingyun
	 * @time 下午5:55:39
	 * @param userId
	 * @param cursor
	 *            页码
	 * @return
	 * @throws Exception
	 */
	PagableResponse<Profile> getFriendsById(String userId, long cursor)
			throws Exception;

	/**
	 * 查找用户 follows
	 * @param userId
	 * @param count 分页大小 最大值为200
	 * @param cursor 第一次查询 传 -1
	 * @return
	 * @throws Exception
	 */
	PagableResponse<Profile> getFollowsById(String userId,int count, long cursor)
			throws Exception;

	/**
	 * 授权用户关注的好友列表
	 * 
	 * @author chenjingyun
	 * @time 下午5:56:21
	 * @param screenName
	 * @param cursor
	 *            页码 初值－1
	 * @return 默认每页20条
	 * @throws Exception
	 */
	PagableResponse<Profile> getFriendsByName(String screenName, long cursor)
			throws Exception;

	/**
	 * 授权用户关注的好友列表
	 * 
	 * @author chenjingyun
	 * @time 下午6:01:01
	 * @param screenName
	 * @param cursor
	 *            页码
	 * @param count
	 * @return
	 * @throws Exception
	 */
	PagableResponse<Profile> getFriendsByName(String screenName, long cursor, int count) throws Exception;

}

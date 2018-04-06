package com.loonxi.channel.twitter.api;

import java.io.File;
import java.util.List;
import com.loonxi.channel.twitter.model.Status;
import com.loonxi.channel.twitter.model.Profile;

/**
 * 账户简介信息接口
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * @since 1.0
 *
 * 用户信息流接口是不支持分页的；最多一次性返回该用户最近的3200条数据，具体参考如下链接
 * https://dev.twitter.com/rest/reference/get/statuses/user_timeline
 */
public interface ProfileApi {

	/**
	 * 查询单个账户信息
	 * 
	 * @param screenName
	 * @return 返回结果中只包含一条最近的status
	 * @see <a href="https://dev.twitter.com/rest/reference/get/users/show">GET
	 *      users/show | Twitter Developers</a>
	 */
	Profile searchTwitter(String screenName) throws Exception;

	/**
	 *
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	Profile searchTwitterByUserId(String userId) throws Exception;

	/**
	 * 查询用户列表
	 * 
	 * @param keyWord
	 *            关键字
	 * @param page 页号
	 * @return
	 *
	 * @see <a href="https://dev.twitter.com/rest/reference/get/users/search">
	 *      GET users/search | Twitter Developers</a>
	 */
	List<Profile> searchTwitters(String keyWord, int page) throws Exception;

	/**
	 * 获得用户信息
	 * 
	 * @author chenjingyun
	 * @time 上午11:44:35
	 * @return
	 * @throws Exception
	 */
	Profile getAccountProfile() throws Exception;

	/**
	 * 用户列表信息
	 * 
	 * @author chenjingyun
	 * @time 下午3:06:12
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<Profile> getAccountProfile(String... userId) throws Exception;

	/**
	 * 更新用户简介
	 * 
	 * @author chenjingyun
	 * @time 上午11:44:35
	 * @return
	 * @throws Exception
	 */
	Profile updateProfileImage(File image) throws Exception;

	/**
	 * 获得用户主页动态
	 * 
	 * @author chenjingyun
	 * @time 上午11:51:00
	 * @return
	 * @throws Exception
	 */
	List<Status> getHomeTimeline() throws Exception;


	/**
	 * 获得用户主页动态
	 * @param sinceId 返回大于给定id号的列表
	 * @return
	 * @throws Exception
	 */
	List<Status> getHomeTimeline(String sinceId) throws Exception;

	/**
	 * 获取授权用户发送的推文列表,最大20
	 * 
	 * @author chenjingyun
	 * @time 上午11:23:10
	 * @return
	 * @throws Exception
	 */
	List<Status> getUserTimeline() throws Exception;

	/**
	 *  获取授权用户发送的推文列表,最大20
	 * 
	 * @author chenjingyun
	 * @time 下午5:22:02  
	 * @param sinceId
	 * @return 返回大于给定 sinceId 号的列表
	 * @throws Exception
	 */
	List<Status> getUserTimeline(String sinceId) throws Exception;

	
	/**
	 * 获取指定用户发送的推文列表,最大20
	 * 
	 * @author chenjingyun
	 * @time 下午5:07:25
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<Status> getUserTimelineById(String userId) throws Exception;

	/**
	 * 获取指定用户发送的推文列表,最大20
	 * 
	 * @author chenjingyun
	 * @time 下午5:22:56  
	 * @param sinceId
	 * @param userId
	 * @return 返回大于给定id号的列表
	 * @throws Exception
	 */
	List<Status> getUserTimelineById(String sinceId, String userId) throws Exception;

}

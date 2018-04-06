package com.loonxi.channel.twitter.api;

import java.util.List;
import com.loonxi.channel.twitter.model.DirectMessage;

/**
 * 私信接口
 * 
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2016年12月26日
 * https://dev.twitter.com/rest/reference/get/direct_messages
 * @since 1.0
 */
public interface DirectMessageApi {

	/**
	 * 用户接收对私信列表
	 * @param count
	 * @return
	 * @throws Exception
	 */
	List<DirectMessage> getDirectMessages(int count) throws Exception;

	/**
	 * 用户接收对私信列表
	 * @param count 返回条数
	 * @param sinceId 最小的ID
	 * @return
	 * @throws Exception
	 */
	List<DirectMessage> getDirectMessages(int count, String  sinceId) throws Exception;

	/**
	 * 用户发送的私信列表
	 * 
	 * @author chenjingyun
	 * @time 下午2:03:34
	 * @param count 每页条数
	 * @return
	 * @throws Exception
	 */
	List<DirectMessage> getSentDirectMessages(int count) throws Exception;

	/**
	 * 用户发送的私信列表
	 * 
	 * @author chenjingyun
	 * @time 下午5:55:40
	 * @return 返回大于指定id的私信列表 最大一次200条
	 * @throws Exception
	 */
	List<DirectMessage> getSentDirectMessages(int count, String sinceId) throws Exception;

	/**
	 * 发私信给指定用户
	 * 
	 * @author chenjingyun
	 * @time 上午10:25:30
	 * @param screenName
	 *            用户显示名如：@chenjingyun1
	 * @param text
	 * @return
	 * @throws Exception
	 */
	DirectMessage sendDirectMessageByName(String screenName, String text)
			throws Exception;

	/**
	 * 发私信给指定用户
	 * 
	 * @author chenjingyun
	 * @time 下午3:54:28
	 * @param userId
	 * @param text
	 * @return
	 * @throws Exception
	 */
	DirectMessage sendDirectMessageById(String userId, String text) throws Exception;

	/**
	 * 删除私信
	 * 
	 * @author chenjingyun
	 * @time 下午2:56:00
	 * @param messageId
	 * @return
	 * @throws Exception
	 */
	DirectMessage destroyDirectMessage(String messageId) throws Exception;

}

package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.FBConversation;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.*;

/**
 * 私信接口
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月4日
 * @since 1.0
 */
public interface MessageApi {
	/**
	 * 获取指定id的message
	 * 
	 * @author chenjingyun
	 * @time 下午5:48:56  
	 * @param messageId
	 * @return
	 * @throws Exception
	 */
	Message getMessage(String messageId)throws Exception;


	/**
	 * 获取会话消息列表，不支持时间查询，只从最新的会话和消息开始查询
	 * @param conversationPageSize 会话每页显示条数
	 * @param messagePageSize 会话里的消息条数每页显示条数
	 * @return
	 * @throws FacebookException
	 */
	FBPaging<FBConversation> getConversations(int conversationPageSize, int messagePageSize) throws FacebookException;

	/**
	 * 只有主页给个人发 而且必须是有一个会话，即个人先给主页发了信息。
	 * @param conversionId 会话ID
	 * @param message 消息内容
	 * @return
	 *
	 * https://developers.facebook.com/docs/graph-api/reference/v2.8/conversation/messages/
	 */
	String postMessage(String conversionId, String message) throws FacebookException;

}

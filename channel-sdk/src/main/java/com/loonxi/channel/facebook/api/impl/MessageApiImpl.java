package com.loonxi.channel.facebook.api.impl;

import com.alibaba.fastjson.JSON;
import com.loonxi.channel.facebook.api.MessageApi;
import com.loonxi.channel.facebook.api.convert.FBConversationConvert;
import com.loonxi.channel.facebook.model.FBConversation;
import com.loonxi.channel.facebook.model.FBPaging;
import facebook4j.*;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月4日
 * @since 1.0
 */
public class MessageApiImpl implements MessageApi{
	private Facebook facebook;


	public MessageApiImpl(Facebook facebook) {
		this.facebook = facebook;
	}

	@Override
	public Message getMessage(String messageId) throws Exception {
		// TODO Auto-generated method stub
		return facebook.getMessage(messageId);
	}

	@Override
	public FBPaging<FBConversation> getConversations(int conversationPageSize, int messagePageSize) throws FacebookException {
		Reading reading = new Reading();
		if(conversationPageSize!=0){
			reading.limit(conversationPageSize);
		}
		//String conversationFild = "conversations.limit(10){messages.limit(10){from}}";
		String conversationFild = "messages.limit(10){created_time,from,id,message,to,attachments}";

		if(messagePageSize!=0){
			conversationFild = conversationFild.replace("limit(10","limit(" + messagePageSize);
		}
		reading.fields(conversationFild,"senders");

		InboxResponseList<Conversation> conversations = facebook.getConversations(reading);
		return new FBConversationConvert().pageConvert(conversations);
	}


	@Override
	public String postMessage(String conversionId, String message) throws FacebookException {
		String relaventUrl = conversionId + "/messages";
		Map<String, String> params = new HashMap<>();
		params.put("message", message);
		RawAPIResponse rawAPIResponse = facebook.callPostAPI(relaventUrl, params);
		JSONObject jsonObject = rawAPIResponse.asJSONObject();
		String messageId = null;
		try {
			messageId = (String) jsonObject.get("id");
		} catch (JSONException e) {
			throw new RuntimeException("主页发送消息，解析请求返回对象失败：jsonObject" + JSON.toJSONString(jsonObject));
		}
		return messageId;
	}
}

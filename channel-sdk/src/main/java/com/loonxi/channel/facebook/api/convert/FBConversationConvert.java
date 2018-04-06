package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBConversation;
import facebook4j.Conversation;
import facebook4j.Message;
import facebook4j.PagableList;

/**
 * 主页会话转化器
 * Created by xyy on 2017/1/10.
 */
public class FBConversationConvert implements FBconvert<Conversation, FBConversation>{
    @Override
    public FBConversation modelConvert(Conversation conversation) {
        FBConversation fbConversation = new FBConversation();
        fbConversation.setGetUpdatedTime(conversation.getUpdatedTime());
        fbConversation.setId(conversation.getId());
        fbConversation.setMessageCount(conversation.getMessageCount());
        fbConversation.setUnreadCount(conversation.getUnreadCount());
        //消息
        PagableList<Message> messages =  conversation.getMessages();
        //fbConversation.setCanReply(conversation.get);
        fbConversation.setMessages(new FBMessageConvert().pageConvert(messages));
        return fbConversation;
    }

    @Override
    public Class getSourceClass() {
        return Conversation.class;
    }
}

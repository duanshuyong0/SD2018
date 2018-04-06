package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBAttachment;
import com.loonxi.channel.facebook.model.FBMessage;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xyy on 2017/1/10.
 */
public class FBMessageConvert implements FBconvert<Message, FBMessage> {
    @Override
    public FBMessage modelConvert(Message message) {
        FBMessage fbMessage = new FBMessage();
        fbMessage.setId(message.getId());
        fbMessage.setCreatedTime(message.getCreatedTime());
        fbMessage.setFrom(new FBbaseProfile(message.getFrom().getId(), message.getFrom().getName()));
        fbMessage.setTo(new FBbaseProfile(message.getTo().get(0).getId(),message.getTo().get(0).getName()));
        fbMessage.setMessage(message.getMessage());

        List<Message.Attachment> attachments = message.getAttachments();
        List<FBAttachment> list = new ArrayList<>();
        for(Message.Attachment attachment : attachments){
            FBAttachment fbAttachment = new FBAttachment();
            fbAttachment.setId(attachment.getId());
            fbAttachment.setName(attachment.getName());
            fbAttachment.setMimeType(attachment.getMimeType());
            fbAttachment.setUrl(attachment.getUrl());
            list.add(fbAttachment);
        }
        fbMessage.setAttachmentList(list);
        return fbMessage;
    }

    @Override
    public Class getSourceClass() {
        return Message.class;
    }
}

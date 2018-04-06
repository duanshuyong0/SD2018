package com.loonxi.channel.facebook.api.convert;

import com.loonxi.channel.facebook.model.FBNotification;
import com.loonxi.channel.facebook.model.FBbaseObject;
import com.loonxi.channel.facebook.model.FBbaseProfile;
import facebook4j.Notification;

/**
 * Created by xyy on 2017/1/9.
 */
public class FBNotificationConvert implements FBconvert<Notification, FBNotification> {

    @Override
    public FBNotification modelConvert(Notification notification) {
        FBNotification fbNotification = new FBNotification();
        fbNotification.setCreatedTime(notification.getCreatedTime());
        fbNotification.setId(notification.getId());
        fbNotification.setTitile(notification.getTitle());
        fbNotification.setFrom(new FBbaseProfile(notification.getFrom().getId(), notification.getFrom().getName()));
        fbNotification.setTo(new FBbaseProfile(notification.getTo().getId(), notification.getTo().getName()));
        fbNotification.setfBbaseObject(new FBbaseObject(notification.getTargetObject().getId(),notification.getTargetObject().getType()));
        fbNotification.setLink(notification.getLink().toString());
        return fbNotification;
    }

    @Override
    public Class getSourceClass() {
        return Notification.class;
    }
}

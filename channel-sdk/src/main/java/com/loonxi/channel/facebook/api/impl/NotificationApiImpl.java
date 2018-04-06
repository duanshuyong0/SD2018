/*
 * Copyright (c) 2002-2014 Alibaba Group Holding Limited.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.loonxi.channel.facebook.api.impl;

import com.loonxi.channel.facebook.api.NotificationApi;
import com.loonxi.channel.facebook.api.convert.FBNotificationConvert;
import com.loonxi.channel.facebook.model.*;
import facebook4j.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月5日
 * @since 1.0
 */
public class NotificationApiImpl implements NotificationApi{
	private Facebook facebook;

	public NotificationApiImpl(Facebook facebook) {
		this.facebook = facebook;
	}


	@Override
	public FBPaging<FBNotification> getNotifications(int limit) throws FacebookException {
		ResponseList<Notification> notifications;
		Reading reading = new Reading();
		reading.limit(limit);
		//fields=from,id,link,object,title,to,message,created_time
		reading.fields(new String("from,id,link,object,title,to,message,created_time").split(","));
		notifications = facebook.getNotifications(reading);
		return new FBNotificationConvert().pageConvert(notifications);
	}

	@Override
	public Notification getNotification(String notificationId) throws Exception {
		return null;
	}

}
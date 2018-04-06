package com.loonxi.channel.facebook.api;

import com.loonxi.channel.facebook.model.*;
import facebook4j.FacebookException;
import facebook4j.Notification;

/**
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月5日
 * @since 1.0
 */
public interface NotificationApi {

	/**
	 * 获取当前主页的通知，注意如果是 个人 用户不能实现
	 * @return
	 * @throws FacebookException
	 */
	FBPaging<FBNotification> getNotifications(int limit) throws FacebookException;

	
	/**
	 * 获取消息详情
	 *
	 * @author chenjingyun
	 * @time 下午5:12:32
	 * @return
	 * @throws Exception
	 */
	Notification getNotification(String notificationId)throws Exception;



}

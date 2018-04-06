package com.dsy.dadui.sdk.service.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserImg;
import com.dsy.dadui.sdk.query.user.UserQuery;


public interface UserImgService {
	
	/**
	 * 根据用户ID 查询用户下面的所有图片详情信息
	* @Title: UserImgService.java 
	* @Package com.dsy.dadui.sdk.service.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 上午8:49:29 
	* @param userId
	* @return
	* @version V1.0
	 */
	List<UserImg> get(String userId);

	/**   
	* @Title: UserImgService.java 
	* @Package com.dsy.dadui.sdk.service.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月29日 下午2:15:00 
	* @param userImg
	* @return
	* @version V1.0   
	*/
	Boolean insert(UserImg userImg);

	
}

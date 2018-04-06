package com.dsy.dadui.sdk.service.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserExtend;
import com.dsy.dadui.sdk.query.user.UserQuery;


public interface UserExtendService {

	List<UserExtend> queryByIdList(List<String> userIds);

	UserExtend get(String userId);

	 
	/**
	 * 传入对象  有选择性地更新
	* @Title: UserExtendService.java 
	* @Package com.dsy.dadui.sdk.service.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 下午4:27:54 
	* @param userExtend
	* @return
	* @version V1.0
	 */
	Boolean updateBySet(UserExtend userExtend);

	 
	/**   
	* @Title: UserExtendService.java 
	* @Package com.dsy.dadui.sdk.service.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月26日 下午5:21:18 
	* @param userExtend
	* @return
	* @version V1.0   
	*/
	Boolean insert(UserExtend userExtend);

	
}

package com.dsy.dadui.core.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.user.UserExtendMapper;
import com.dsy.dadui.core.mapper.user.UserMapper;
import com.dsy.dadui.sdk.entity.user.UserExtend;



@Repository
public class UserExtendDao {


	@Autowired
	private UserExtendMapper userExtendMapper;

	public List<UserExtend> queryByIdList(List<String> userIds) {

		return userExtendMapper.queryByIdList(userIds);
	}

	public UserExtend get(String userId) {

		return userExtendMapper.get(userId);
	}

	 
	/**   
	* @Title: UserExtendDao.java 
	* @Package com.dsy.dadui.core.dao.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 下午4:35:01 
	* @param userExtend
	* @return
	* @version V1.0   
	*/
	public Boolean updateBySet(UserExtend userExtend) {
		// TODO Auto-generated method stub
		return userExtendMapper.updateByPrimaryKeySelective(userExtend)>0;
	}

	 
	/**   
	* @Title: UserExtendDao.java 
	* @Package com.dsy.dadui.core.dao.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月26日 下午5:23:01 
	* @param userExtend
	* @return
	* @version V1.0   
	*/
	public Boolean insert(UserExtend userExtend) {
		// TODO Auto-generated method stub
		return userExtendMapper.insert(userExtend)>0;
	}
			
	
}

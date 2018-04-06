package com.dsy.dadui.core.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.user.UserImgMapper;
import com.dsy.dadui.core.mapper.user.UserMapper;
import com.dsy.dadui.sdk.entity.user.UserImg;



@Repository
public class UserImgDao {


	@Autowired
	private UserImgMapper userImgMapper;

	public List<UserImg> get(String userId) {

		return userImgMapper.get(userId);
	}

	 
	/**   
	* @Title: UserImgDao.java 
	* @Package com.dsy.dadui.core.dao.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月29日 下午2:17:35 
	* @param userImg
	* @return
	* @version V1.0   
	*/
	public Boolean insert(UserImg userImg) {
		// TODO Auto-generated method stub
		return userImgMapper.insert(userImg)>0;
	}
			
	
}

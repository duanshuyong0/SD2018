package com.dsy.dadui.core.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.user.UserMapper;
import com.dsy.dadui.sdk.entity.user.User;



@Repository
public class UserDao {


	@Autowired
	private UserMapper userMapper;

	public User getByAccount(String accountName) {

	return userMapper.getByAccount(accountName);
	
	}

	public boolean insert(User user) {
		return userMapper.insert(user)>0;
	}

	public List<User> queryByIdList(List<String> userIds) {
		// TODO Auto-generated method stub
		return userMapper.queryByIdList(userIds);
	}

	public User get(String userId) {

		return userMapper.selectByPrimaryKey(userId);
	}

	 
	/**   
	 * 
	 * 有选择性地更新
	* @Title: UserDao.java 
	* @Package com.dsy.dadui.core.dao.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 下午4:33:10 
	* @param user
	* @return
	* @version V1.0   
	*/
	public boolean update(User user) {
		return userMapper.updateByPrimaryKeySelective(user)>0;
	}


			
	
}

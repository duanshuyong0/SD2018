package com.dsy.dadui.core.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.query.user.UserQuery;
import com.dsy.dadui.sdk.service.user.UserService;
import com.dsy.dadui.core.dao.user.UserDao;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserDao userDao;

	@Override
	public User getByAccount(String accountName) {
		return userDao.getByAccount(accountName);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public boolean insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public User get(String userId) {
		// TODO Auto-generated method stub
		return userDao.get(userId);
	}

	@Override
	public List<User> find(UserQuery userQuery) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<User> queryByIdList(List<String> userIds) {
		// TODO Auto-generated method stub
		return userDao.queryByIdList(userIds);
	}
	
}

package com.dsy.dadui.core.service.user.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserExtend;
import com.dsy.dadui.sdk.query.user.UserQuery;
import com.dsy.dadui.sdk.service.user.UserExtendService;
import com.dsy.dadui.sdk.service.user.UserService;
import com.dsy.dadui.common.constants.DeleteTagConstant;
import com.dsy.dadui.core.dao.user.UserDao;
import com.dsy.dadui.core.dao.user.UserExtendDao;
@Service
public class UserExtendServiceImpl implements UserExtendService {

	
	@Autowired
	private UserExtendDao userExtendDao;

	@Override
	public List<UserExtend> queryByIdList(List<String> userIds) {

		return userExtendDao.queryByIdList(userIds);
	}

	@Override
	public UserExtend get(String userId) {

		return userExtendDao.get(userId);
	}


	@Override
	public Boolean updateBySet(UserExtend userExtend) {
		// TODO Auto-generated method stub
		return userExtendDao.updateBySet(userExtend);
	}

	/* (non-Javadoc)
	 * @see com.dsy.dadui.sdk.service.user.UserExtendService#insert(com.dsy.dadui.sdk.entity.user.UserExtend)
	 */
	@Override
	public Boolean insert(UserExtend userExtend) {
		// TODO Auto-generated method stub
		return userExtendDao.insert(userExtend);
	}

}

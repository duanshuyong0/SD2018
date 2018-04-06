package com.dsy.dadui.core.service.user.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.query.user.UserQuery;
import com.dsy.dadui.sdk.service.user.UserExtendService;
import com.dsy.dadui.sdk.service.user.UserImgService;
import com.dsy.dadui.sdk.service.user.UserSugarService;
import com.dsy.dadui.common.constants.DeleteTagConstant;
import com.dsy.dadui.core.dao.user.UserDao;
import com.dsy.dadui.core.dao.user.UserImgDao;
import com.dsy.dadui.core.dao.user.UserSugarDao;
@Service
public class UserSugarServiceImpl implements UserSugarService {

	
	@Autowired
	private UserSugarDao userSugarDao;

}

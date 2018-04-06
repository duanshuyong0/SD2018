package com.dsy.dadui.core.service.org.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.core.dao.org.OrgDao;
import com.dsy.dadui.core.dao.org.OrgUserDao;
import com.dsy.dadui.sdk.entity.org.OrgUser;
import com.dsy.dadui.sdk.service.org.OrgService;
import com.dsy.dadui.sdk.service.org.OrgUserService;
@Service
public class OrgUserServiceImpl implements OrgUserService {

	
	@Autowired
	private OrgUserDao orgUserDao;

	@Override
	public List<OrgUser> getList(long orgId) {

		return orgUserDao.getList(orgId);
	}

	
}

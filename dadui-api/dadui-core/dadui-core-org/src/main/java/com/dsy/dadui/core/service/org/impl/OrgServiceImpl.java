package com.dsy.dadui.core.service.org.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.core.dao.org.OrgDao;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.service.org.OrgService;
@Service
public class OrgServiceImpl implements OrgService {

	
	@Autowired
	private OrgDao orgDao;

	@Override
	public List<Org> getList() {
		
		return orgDao.getList();
	}

	
}

package com.dsy.dadui.core.service.org.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.dadui.core.dao.org.OrgAdvertDao;
import com.dsy.dadui.core.dao.org.OrgConDao;
import com.dsy.dadui.core.dao.org.OrgDao;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgAdvert;
import com.dsy.dadui.sdk.entity.org.OrgCon;
import com.dsy.dadui.sdk.service.org.OrgAdvertService;
import com.dsy.dadui.sdk.service.org.OrgConService;
import com.dsy.dadui.sdk.service.org.OrgService;
@Service
public class OrgAdvertServiceImpl implements OrgAdvertService {

	
	@Autowired
	private OrgAdvertDao orgAdvertDao;
	
	@Override
	public List<OrgAdvert> getList( ) {
		
		return orgAdvertDao.getList();
	}

	
}

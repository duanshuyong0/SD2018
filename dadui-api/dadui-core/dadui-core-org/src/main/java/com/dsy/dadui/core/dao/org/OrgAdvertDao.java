package com.dsy.dadui.core.dao.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.org.OrgAdvertMapper;
import com.dsy.dadui.core.mapper.org.OrgMapper;
import com.dsy.dadui.core.mapper.org.OrgUserMapper;
import com.dsy.dadui.sdk.entity.org.OrgAdvert;




@Repository
public class OrgAdvertDao {


	@Autowired
	private OrgAdvertMapper orgAdvertMapper;

	public List<OrgAdvert> getList() {
		
		return orgAdvertMapper.getList();
	}
			
	
}

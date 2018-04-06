package com.dsy.dadui.core.dao.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.org.OrgMapper;
import com.dsy.dadui.core.mapper.org.OrgUserMapper;
import com.dsy.dadui.sdk.entity.org.OrgUser;




@Repository
public class OrgUserDao {


	@Autowired
	private OrgUserMapper orgUserMapper;

	public List<OrgUser> getList(long orgId) {
		
		return orgUserMapper.getList(orgId);
	}
			
	
}

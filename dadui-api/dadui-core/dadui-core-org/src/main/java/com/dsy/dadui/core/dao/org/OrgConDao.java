package com.dsy.dadui.core.dao.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.org.OrgConMapper;
import com.dsy.dadui.core.mapper.org.OrgMapper;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgCon;




@Repository
public class OrgConDao {


	@Autowired
	private OrgConMapper orgConMapper;

	public List<OrgCon> getList(long orgId) {

		return orgConMapper.getList(orgId);
	}
			
	
}

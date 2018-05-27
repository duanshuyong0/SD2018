package com.dsy.dadui.core.dao.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dsy.dadui.core.mapper.org.OrgMapper;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.query.org.OrgQuery;




@Repository
public class OrgDao {


	@Autowired
	private OrgMapper orgMapper;

	public List<Org> getList(OrgQuery query) {

		return orgMapper.getList(query);
	}

	public int queryCount(OrgQuery query) {
		// TODO Auto-generated method stub
		return orgMapper.queryCount(query);
	}
			
	
}

package com.dsy.dadui.core.mapper.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.OrgUser;

public interface OrgUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgUser record);

    int insertSelective(OrgUser record);

    OrgUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgUser record);

    int updateByPrimaryKey(OrgUser record);

	List<OrgUser> getList(long orgId);
	
}
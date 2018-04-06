package com.dsy.dadui.core.mapper.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.OrgCon;

public interface OrgConMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgCon record);

    int insertSelective(OrgCon record);

    OrgCon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgCon record);

    int updateByPrimaryKeyWithBLOBs(OrgCon record);

    int updateByPrimaryKey(OrgCon record);

	List<OrgCon> getList(Long orgId);
}
package com.dsy.dadui.core.mapper.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.query.org.OrgQuery;

public interface OrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);

	List<Org> getList(OrgQuery query);

	int queryCount(OrgQuery query);
}
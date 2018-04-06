package com.dsy.dadui.core.mapper.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.Org;

public interface OrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);

	List<Org> getList();
}
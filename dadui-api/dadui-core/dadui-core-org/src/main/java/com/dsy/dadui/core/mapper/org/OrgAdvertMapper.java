package com.dsy.dadui.core.mapper.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.OrgAdvert;
import com.dsy.dadui.sdk.entity.org.OrgUser;

public interface OrgAdvertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgAdvert record);

    int insertSelective(OrgAdvert record);

    OrgAdvert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgAdvert record);

    int updateByPrimaryKey(OrgAdvert record);

	List<OrgAdvert> getList(long orgId);
}
package com.dsy.dadui.core.mapper.user;

import com.dsy.dadui.sdk.entity.user.UserSugarReduce;

public interface UserSugarReduceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSugarReduce record);

    int insertSelective(UserSugarReduce record);

    UserSugarReduce selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSugarReduce record);

    int updateByPrimaryKey(UserSugarReduce record);
}
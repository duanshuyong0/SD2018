package com.dsy.dadui.core.mapper.user;

import com.dsy.dadui.sdk.entity.user.UserSugarAdd;

public interface UserSugarAddMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSugarAdd record);

    int insertSelective(UserSugarAdd record);

    UserSugarAdd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSugarAdd record);

    int updateByPrimaryKey(UserSugarAdd record);
}
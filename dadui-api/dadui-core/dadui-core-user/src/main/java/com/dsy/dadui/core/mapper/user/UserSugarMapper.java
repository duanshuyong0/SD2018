package com.dsy.dadui.core.mapper.user;

import com.dsy.dadui.sdk.entity.user.UserSugar;

public interface UserSugarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSugar record);

    int insertSelective(UserSugar record);

    UserSugar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSugar record);

    int updateByPrimaryKey(UserSugar record);
}
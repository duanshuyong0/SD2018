package com.dsy.dadui.core.mapper.user;

import com.dsy.dadui.sdk.entity.user.UserWechatAdd;

public interface UserWechatAddMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWechatAdd record);

    int insertSelective(UserWechatAdd record);

    UserWechatAdd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWechatAdd record);

    int updateByPrimaryKey(UserWechatAdd record);
}
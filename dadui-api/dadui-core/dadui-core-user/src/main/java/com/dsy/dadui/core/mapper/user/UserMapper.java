package com.dsy.dadui.core.mapper.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User getByAccount(String openId);

	List<User> queryByIdList(List<String> userIds);

}
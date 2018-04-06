package com.dsy.dadui.core.mapper.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.UserExtend;

public interface UserExtendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserExtend record);

    int insertSelective(UserExtend record);

    UserExtend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserExtend record);

    int updateByPrimaryKey(UserExtend record);

	List<UserExtend> queryByIdList(List<String> userIds);

	UserExtend get(String userId);
}
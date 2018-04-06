package com.dsy.dadui.core.mapper.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.UserImg;

public interface UserImgMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(UserImg record);

    int insertSelective(UserImg record);

    UserImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserImg record);

    int updateByPrimaryKey(UserImg record);

	List<UserImg> get(String userId);
}
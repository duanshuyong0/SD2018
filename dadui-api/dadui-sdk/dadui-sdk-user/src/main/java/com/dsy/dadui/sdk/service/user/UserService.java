package com.dsy.dadui.sdk.service.user;

import java.util.List;

import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.query.user.UserQuery;

/**
 * 用户service接口
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public interface UserService {

	/**
	 * 通过账号名查询用户
	 * 
	 * @author taojiagui(云启)
	 * @time 下午2:10:11
	 * @param accountName
	 * @return
	 */
	User getByAccount(String accountName);

	/**
	 * 更新用户
	 * 
	 * @author taojiagui(云启)
	 * @time 下午3:11:57
	 * @param user
	 * @return
	 */
	boolean update(User user);

	/**
	 * 插入用户记录
	 * 
	 * @author taojiagui(云启)
	 * @time 上午10:39:42
	 * @param user
	 * @return
	 */
	boolean insert(User user);

	/**
	 * 通过用户ID得到用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午4:34:44
	 * @param userId
	 * @return
	 */
	User get(String userId);

	/**
	 * 查询所有用户
	 * 
	 * @author taojiagui(云启)
	 * @time 下午3:18:12
	 * @param userQuery
	 * @return
	 */
	List<User> find(UserQuery userQuery);
	
	/**
	 * 根据用户ID LIST 去查询返回用户LIST
	 * @param userIds
	 * @return
	 */
	List<User> queryByIdList(List<String> userIds);

}

package com.dsy.dadui.sdk.service.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.OrgUser;



/**
 * 用户service接口
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public interface OrgUserService {

	List<OrgUser> getList(long orgId);

}

package com.dsy.dadui.sdk.service.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgCon;



/**
 * 用户service接口
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public interface OrgConService {
	
	/**
	 * 查询orgCon   List
	 * @param orgId 
	 * @return
	 */
	List<OrgCon> getList(long orgId);

}

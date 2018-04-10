package com.dsy.dadui.sdk.service.org;

import java.util.List;

import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgAdvert;
import com.dsy.dadui.sdk.entity.org.OrgCon;



/**
 * 
 */
public interface OrgAdvertService {
	
	/**
	 * 查询orgCon   List
	 * @param orgId 
	 * @return
	 */
	List<OrgAdvert> getList();

}

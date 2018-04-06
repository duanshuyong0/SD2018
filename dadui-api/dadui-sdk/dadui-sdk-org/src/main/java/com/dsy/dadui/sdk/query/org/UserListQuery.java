/**
 * 
 */
package com.dsy.dadui.sdk.query.org;

import com.dsy.dadui.common.beans.PageParam;

/**   
* @Title: UserListQuery.java 
* @Package com.dsy.dadui.sdk.query.org 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年7月27日 上午8:19:07 
* @version V1.0   
*/
public class UserListQuery extends PageParam{
	
	
	private Long orgId; //圈子ID

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

}

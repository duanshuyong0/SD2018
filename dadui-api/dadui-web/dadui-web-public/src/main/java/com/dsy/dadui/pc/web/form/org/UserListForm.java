/**
 * 
 */
package com.dsy.dadui.pc.web.form.org;

import com.dsy.dadui.common.beans.QueryParam;

/**   
* @Title: UserListForm.java 
* @Package com.dsy.dadui.pc.web.form.org 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年7月27日 上午8:09:46 
* @version V1.0   
*/
public class UserListForm extends QueryParam {

	
	private Long orgId; //圈子ID

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	
}

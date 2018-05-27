/**
 * 
 */
package com.dsy.dadui.sdk.query.org;

import com.dsy.dadui.common.beans.PageParam;

/**   
* @Title: OrgQuery.java 
* @Package com.dsy.dadui.sdk.query.org 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年7月27日 上午8:19:07 
* @version V1.0   
*/
public class OrgQuery extends PageParam{
	
	
	private String openId; //用户ID

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String string) {
		this.openId = string;
	}



}

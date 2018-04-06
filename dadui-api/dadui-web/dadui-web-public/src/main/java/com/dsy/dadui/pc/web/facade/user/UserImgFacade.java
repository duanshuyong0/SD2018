/**
 * 
 */
package com.dsy.dadui.pc.web.facade.user;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dsy.dadui.common.utils.QiniuFileUtil;
import com.dsy.dadui.pc.web.enums.user.UserImgMainTypeEnum;
import com.dsy.dadui.sdk.entity.user.UserImg;
import com.dsy.dadui.sdk.service.org.OrgService;
import com.dsy.dadui.sdk.service.user.UserImgService;

/**   
* @Title: UserImgFacade.java 
* @Package com.dsy.dadui.pc.web.facade.user 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年6月29日 上午11:12:03 
* @version V1.0   
*/
@Service
public class UserImgFacade {
	
	
	@Autowired
	private UserImgService userImgService;
	/**   
	 * 上传用户图片接口
	* @Title: UserImgFacade.java 
	* @Package com.dsy.dadui.pc.web.facade.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月29日 上午11:13:07 
	* @return
	* @version V1.0   
	 * @param request 
	 * @throws IOException 
	*/
	
	
	public Boolean upload(MultipartFile file,String userId) throws IOException {
		Boolean flag = false;
		//上传文件
		String key = QiniuFileUtil.upload(file.getBytes(),file.getOriginalFilename());

		//添加UserImg 表
		UserImg  userImg = new UserImg();
		userImg.setCreateTime(new Date());
		userImg.setImgPath(key);
		userImg.setIsMain(UserImgMainTypeEnum.IsMainImgNo.getCode());
		userImg.setUpdateTime(new Date());
		userImg.setUserId(userId);
		flag=userImgService.insert(userImg);		
		return flag;
		
	}
	
}

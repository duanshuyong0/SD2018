/**
 * 
 */
package com.dsy.dadui.pc.web.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.pc.web.controller.base.BaseController;
import com.dsy.dadui.pc.web.facade.user.UserImgFacade;
import com.dsy.dadui.pc.web.form.user.UploadForm;
import com.google.common.collect.ImmutableMap;

/**   
* @Title: userImgController.java 
* @Package com.dsy.dadui.pc.web.controller.user 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年6月29日 上午11:08:45 
* @version V1.0   
*/

@RestController
@RequestMapping("/user/img")
public class UserImgController  extends BaseController {
	
	
	@Autowired
	private UserImgFacade userImgFacade;
	
	/**
	 * user/img/upload  图片上传组件
	* @Title: UserImgController.java 
	* @Package com.dsy.dadui.pc.web.controller.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月29日 上午11:13:41 
	* @param file
	* @return
	* @version V1.0
	 */
	@RequestMapping(value ="/upload",method = RequestMethod.POST, produces = "application/json")
    public Result<Boolean> handleFileUpload(@RequestParam(value = "file",required =false)MultipartFile file){
//	public Result<Boolean> handleFileUpload(UploadForm uploadForm){

		try {
			
	//	return Result.success("成功", userImgFacade.upload(uploadForm.getImgFile(),getUserId()));
		return Result.success("成功", userImgFacade.upload(file,getUserId()));
		
		} catch (Exception e) {
		//	logger.error("上传附件失败，异常详情：{}", e.getMessage());
			return Result.failure("上传附件失败");
		}
    }
	
	

	@RequestMapping(value = "upload/image", method = RequestMethod.POST, produces = "application/json")
	public Map<String,Object> uploadImage(@RequestParam(required=true,value="file")MultipartFile file){
		if(null == file){
			return rtnParam(40010, null);
		}
		String random = RandomStringUtils.randomAlphabetic(16);
		String fileName = random + ".jpg";
		String ss="ww";
		return rtnParam(40011, null);
	}
	
	/**   
	* @Title: userImgController.java 
	* @Package com.dsy.dadui.pc.web.controller.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月29日 上午11:08:45 
	* @param args
	* @version V1.0   
	*/
	public static void main(String[] args) {
		
		
	}

	
}

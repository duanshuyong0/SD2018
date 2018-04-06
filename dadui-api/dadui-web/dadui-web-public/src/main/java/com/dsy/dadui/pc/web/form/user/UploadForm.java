/**
 * 
 */
package com.dsy.dadui.pc.web.form.user;

import org.springframework.web.multipart.MultipartFile;

/**   
* @Title: UploadForm.java 
* @Package com.dsy.dadui.pc.web.form.user 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年6月29日 下午9:27:56 
* @version V1.0   
*/
public class UploadForm {
	
	

	private MultipartFile imgFile;

	private String filePath;
	
	
	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	
}

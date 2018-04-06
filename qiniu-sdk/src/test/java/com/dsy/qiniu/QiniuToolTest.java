package com.dsy.qiniu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import com.dsy.qiniu.QiniuTool;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.FileInfo;

public class QiniuToolTest {

	public static void main(String[] args){
		QiniuToolTest test = new QiniuToolTest();
		//test.uploadFile();
		//test.uploadBytes();
		//test.privateDownloadUrl("http://ojp3jy2u9.bkt.clouddn.com/1484288899462.jpg");
		//test.delete();
		
	}
	
	public void delete(){
		try {
			FileInfo fileInfo = QiniuTool.getFileInfo(QiniuTool.Bucket.SCRM, "138283499642684611.jpg");
			System.out.println(fileInfo.key);
			System.out.println(fileInfo.hash);
			System.out.println(fileInfo.endUser);
			System.out.println(fileInfo.fsize);
			System.out.println(fileInfo.mimeType);
			System.out.println(fileInfo.putTime);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadFile(){
		 File file = new File("F:/20170112214141.jpg");
		try {
			Response response = QiniuTool.upload(QiniuTool.Bucket.SCRM, file);
			System.out.println(response.statusCode);
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uploadBytes(){
		File file = new File("F:/20170112214141.jpg");
		File test = new File("F:/test.jpg");
		byte[] data = new byte[(int)file.length()];
		try {
			InputStream input = new FileInputStream(file);
			OutputStream output = new FileOutputStream(test);
			try {
				int off = 0 ;
				while((off = input.read(data)) != -1){
				}
				output.write(data);
				output.flush();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					input.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//调用七牛工具类上传文件
			QiniuTool.upload(QiniuTool.Bucket.SCRM, data, String.valueOf(new Date().getTime())+getSuffix(file.getName()));
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void privateDownloadUrl(String fileUrl){
		System.out.println(QiniuTool.privateDownloadUrl(fileUrl));
	}
	
	public String getSuffix(String fileName){
		if(fileName.lastIndexOf(".") <= 0){
			return null;
		}
		return fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}
	
	
	
}

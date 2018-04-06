package com.dsy.dadui.common.utils;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.qiniu.QiniuTool;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.DefaultPutRet;

import ch.qos.logback.core.status.Status;

/**
 * 文件操作类
 *
 * @author <a href="mailto:yangcheng@loonxi.com">杨成</a>
 * @version 1.0 2017年1月13日
 * @since 1.0
 */
public class QiniuFileUtil {
	
	protected static final Log logger = LogFactory.getLog(QiniuFileUtil.class);
	
	private final static String BUCKET_SCRM = QiniuTool.Bucket.TEST;
    
	/**
	 * 获取上传文件需要的upToken
	 * 
	 * @author yangcheng(杨成)
	 * @time 下午3:11:18  
	 * @return
	 */
	public static String getUpToken(){
		return QiniuTool.getUpToken(BUCKET_SCRM);
	}
	
	/**
	 * 上传二进制文件，
	 * <pre>
	 *   上传成功，返回上传的二进制文件名称；返回值为null,则上传失败。
	 * </pre>
	 * @author yangcheng(杨成)
	 * @time 下午3:35:59  
	 * @param data
	 * @param fileName
	 * @return
	 */
	public static String upload(byte[] data, String fileName){
		String key = getFileName(fileName);
		try {
			Response response = QiniuTool.upload(BUCKET_SCRM, data, key);
			if(response.statusCode == QiniuTool.SUCCESS){
				return key;
			}
			return null;
		} catch (QiniuException e){
			logger.error("upload exception:",e);
		    throw new BusinessException("文件数据上传失败");
		}
	}
	
	/**
	 * 上传文件，
	 * <pre>
	 *   上传成功，返回上传的文件名称，返回的值为null, 则上传失败。
	 * </pre>
	 * @author yangcheng(杨成)
	 * @time 下午3:11:11  
	 * @param file
	 * @return
	 */
	public static String upload(File file){
		String key = getFileName(file.getName());
		try {
			Response response = QiniuTool.upload(BUCKET_SCRM, file, key);
			if(response.statusCode == QiniuTool.SUCCESS){
				return key;
			}
			return null;
		} catch (QiniuException e){
			logger.error("upload exception:",e);
		    throw new BusinessException("文件上传失败");
		}
	}
	
	/**
	 * 文件删除方法
	 * <pre>
	 * 先判断文件是否存在，存在则继续删除，不存在则不做删除操作
	 * </pre>
	 * @author yangcheng(杨成)
	 * @time 下午4:22:32  
	 * @param key
	 */
	public static void delete(String key){
		if(QiniuTool.exist(BUCKET_SCRM, key)){
			try {
				QiniuTool.delete(BUCKET_SCRM, key);
			} catch (QiniuException e) {
				logger.error("delete exception. bucket:"+ BUCKET_SCRM +", key:" + key, e);
			    throw new BusinessException("文件删除失败, key:"+key);
			}
		}
	}
	
	private static String getFileName(String fileName){
		String suffix = getSuffix(fileName);
		if(null == suffix){
			 throw new BusinessException("文件后缀名为空，无效的文件类型");
		}
		return NumericUniqueKeyUtil.genUniqueKey() + getSuffix(fileName);
	}
	
	public static String getSuffix(String fileName){
		int lastIndex = fileName.lastIndexOf(".");
		if(lastIndex <= 0){
			return null;
		}
		return fileName.substring(lastIndex, fileName.length());
	}
	
	public static void main(String[] args){
		File file = new File("D:/02.Iam-work/09.DADUI/01.jpg");
		String fileName = QiniuFileUtil.upload(file);
		System.out.println(fileName);
	}
	

}

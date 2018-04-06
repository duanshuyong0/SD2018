package com.dsy.qiniu;

import java.io.File;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

/**
 * 七牛文件操作工具类
 *
 * @author <a href="mailto:yangcheng@loonxi.com">杨成</a>
 * @version 1.0 2017年1月13日
 * @since 1.0
 */
public class QiniuTool {

	//设置好账号的ACCESS_KEY和SECRET_KEY
    private final static String ACCESS_KEY = "BN0c3OODiDSPCgz7bbO0D6ip6KeKEL3n15be3Dti";
    private final static String SECRET_KEY = "ZVrb3jeYwxWMGuAptvsNqeuIYpdLYMd3WH7iXdbK";
    
    /**
     * 七牛的存储空间名称常量值
     *
     * @author <a href="mailto:yangcheng@loonxi.com">杨成</a>
     * @version 1.0 2017年1月13日
     * @since 1.0
     */
    public interface Bucket{
    	
    	 public final static String SCRM = "scrm"; //七牛中创建的名为"scrm"的空间
    	 
    	 public final static String TEST = "test"; //七牛中创建的名为"test"的空间
    }
    
    public final static int SUCCESS = 200;
    
    
    /**
     * 获取七牛授权
     * 
     * @author yangcheng(杨成)
     * @time 下午5:58:30  
     * @return
     */
    public static Auth getAuth(){
    	return Auth.create(ACCESS_KEY, SECRET_KEY);
    }
    
    /**
     * 获取需要上传文件的upToken字符串
     * 
     * @author yangcheng(杨成)
     * @time 下午3:43:56  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @return
     */
    public static String getUpToken(String bucket){
    	return getAuth().uploadToken(bucket);
    }
    
    /**
     * 文件上传方法
     * <pre>
     *  使用文件名称作为key
     * </pre>
     * @author yangcheng(杨成)
     * @time 下午1:50:19  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @param file 上传的文件对象
     * @return Response 响应对象，其中"statusCode":200为上传成功。
     * @throws QiniuException
     */
    public static Response upload(String bucket, File file)throws QiniuException{
    	return upload(bucket, file, file.getName());
    }
    
    /**
     * 文件上传方法
     * 
     * @author yangcheng(杨成)
     * @time 下午1:50:19  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @param file 上传的文件对象
     * @param key 上传文件的唯一标识(在七牛保存的文件名称)
     * @return Response 响应对象，其中"statusCode":200为上传成功。
     * @throws QiniuException
     */
    public static Response upload(String bucket, File file, String key)throws QiniuException{
    	Zone z = Zone.autoZone();
	    Configuration c = new Configuration(z);
	    //创建上传对象
	    UploadManager uploadManager = new UploadManager(c);
	    try {
	    	return uploadManager.put(file, key, getUpToken(bucket));
		} catch (QiniuException e) {
			throw new QiniuException(e);
		}
    }
    
    /**
     * 文件上传方法
     * 
     * @author yangcheng(杨成)
     * @time 下午2:05:31  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @param data 上传的二进制数据
     * @param key 上传文件的唯一标识(在七牛保存的文件名称)
     * @return Response 响应对象，其中"statusCode":200为上传成功。
     * @throws QiniuException
     */
    public static Response upload(String bucket, final byte[] data, String key)throws QiniuException{
    	Zone z = Zone.autoZone();
	    Configuration c = new Configuration(z);
	    //创建上传对象
	    UploadManager uploadManager = new UploadManager(c);
	    try {
	    	return uploadManager.put(data, key, getUpToken(bucket));
		} catch (QiniuException e) {
			throw new QiniuException(e);
		}
    }
    
    /**
     * 文件删除方法
     * @author yangcheng(杨成)
     * @time 下午1:48:38  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @param key 上传文件的唯一标识(在七牛保存的文件名称)
     * @throws QiniuException
     */
    public static void delete(String bucket, String key) throws QiniuException{
    	Zone z = Zone.zone0();
        Configuration c = new Configuration(z);
        BucketManager bucketManager = new BucketManager(getAuth(), c);
        try {
			bucketManager.delete(bucket, key);
		} catch (QiniuException e) {
			throw new QiniuException(e);
		}
    }
    
    /**
     * 获取单个文件的信息
     * 
     * @author yangcheng(杨成)
     * @time 下午3:18:14  
     * @param bucket 上传的存储空间名称，在七牛空间创建的存储空间名称
     * @param key 上传文件的唯一标识(在七牛保存的文件名称)
     * @return
     * @throws QiniuException
     */
    public static FileInfo getFileInfo(String bucket, String key)throws QiniuException{
    	Zone z = Zone.zone0();
        Configuration c = new Configuration(z);
        BucketManager bucketManager = new BucketManager(getAuth(), c);
        try {
            return bucketManager.stat(bucket, key);
          } catch (QiniuException e) {
        	  throw new QiniuException(e);
          }
    }
    
    public static boolean exist(String bucket, String key){
    	try {
			FileInfo fileInfo = getFileInfo(bucket, key);
			if(fileInfo != null && fileInfo.hash != null){
				return true;
			}
		} catch (QiniuException e) {
		}
    	return false;
    }
    
    /**
     * 获取私有空间文件的下载链接
     * 
     * @author yangcheng(杨成)
     * @time 下午3:02:57  
     * @param fileUrl 文件在七牛的地址
     * @return 返回下载链接字符串
     */
    public static String privateDownloadUrl(String fileUrl){
    	return getAuth().privateDownloadUrl(fileUrl);
    }
}

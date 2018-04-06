package com.dsy.dadui.common.utils;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.dsy.dadui.common.constants.OSSConstants;

import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * OSS文件上传工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public abstract class OssClientUtil {

	private static final String bucketName = "fshop";

	/** 阿里云上传地址 */
	private static final String endpoint = "http://oss.aliyuncs.com";

	/** 阿里云账户accessKeyId */
	private static final String accessKeyId = "mEwlEkvm56coWOFQ";

	/** 阿里云账户secretAccessKey */
	private static final String secretAccessKey = "3JdKkMsXizYJt5v6NFgLrW399v22DC";

	public static InputStream getObject(String fileName) {
		// 初始化OSSClient
		OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
		return client.getObject(bucketName, fileName).getObjectContent();
	}

	/***
	 * 简单存入 对应 bucket 的文件 文件是按照bucketName 存放的，例如传入"fshop" 则上传的文件在 fshop 目录下，
	 * 依次类推， 目前bucketName 无需继续建立： 这里需要注意的是，存入规则需要开发者自定，例如是userIdMOD 5
	 * 还是其他方式，最好HASH 打散， 然后信息保存到数据库记录 特别要注意的是，中文的兼容性， 上传以后，中文是否做个 alias 映射 比如
	 * '教学视频.flv'--》aliasName--jxsp20160612.flv realName 和aliasName 关系维护在数据库中
	 * 另外访问路径啥的也都写进去、
	 * 
	 * @param dir
	 *            文件目录， 例如 ："item/"
	 * @param fileName
	 *            上传文件名
	 * @param fileLength
	 *            文件大小
	 **/
	public static String putObject(InputStream inputStream, String dir, String fileName, int fileLength)
			throws FileNotFoundException {
		// 初始化OSSClient
		OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();
		// 必须设置ContentLength
		meta.setContentLength(fileLength);

		String tempfile = fileName.toLowerCase();
		if (tempfile.endsWith(".mp4")) {
			meta.setContentType("vidio/mp4");
		}

		String fileNameWithDir;
		if (StringUtils.isEmpty(dir)) {
			fileNameWithDir = fileName;
		} else {
			fileNameWithDir = dir + "/" + fileName;
		}

		// 上传Object. KEY 目前直接用file.getName()
		client.putObject(bucketName, fileNameWithDir, inputStream, meta);

		return fileNameWithDir;

	}

	/**
	 * 获得图片路径
	 *
	 * @param fileUrl
	 * @return
	 */
	public static String getImgUrl(String fileUrl) {

		return OSSConstants.url + fileUrl;
	}

	/**
	 * 获得url链接
	 *
	 * @param key
	 * @return
	 */
	public static String getUrl(String key) {
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
		// 设置URL过期时间为10年 3600l* 1000*24*365*10
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}

	/**
	 * 通过原始名称获取随机名称的图片名
	 * 
	 * @param filieName
	 * @return
	 */
	public static String getFileName(String fileName) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name = simpleDateFormat.format(date);
		return name + getSixNumStr()
				+ fileName.substring(fileName.lastIndexOf(".") == -1 ? 0 : fileName.lastIndexOf("."));
	}

	/**
	 * 获取六位数字随机数
	 * 
	 * @return
	 */
	public static String getSixNumStr() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
}

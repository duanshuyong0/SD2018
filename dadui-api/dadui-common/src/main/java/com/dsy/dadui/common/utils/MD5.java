package com.dsy.dadui.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
public class MD5 {

	// 全局数组
	private final static String[] STRING_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
			"d", "e", "f" };

	/**
	 * 
	 * 将字节转换为字符串数组
	 * 
	 * @param bByte
	 *            字节
	 * @return 返回形式为数字跟字符串
	 */
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return STRING_DIGITS[iD1] + STRING_DIGITS[iD2];
	}

	/**
	 * 
	 * 转换字节数组转换为16进制字符串
	 * 
	 * @param bByte
	 *            字节数组
	 * @return 16进制字符串
	 */
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	/**
	 * 
	 * 获得经过MD5加密之后的字符串
	 * 
	 * @param strObj
	 *            需要加密的字符串
	 * @return 加密之后的字符串
	 */
	public static String getMD5Code(String strObj) {
		String resultString;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			resultString = null;
		}
		return resultString;
	}
}

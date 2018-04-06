package com.loonxi.channel.facebook;

/**
 * 获取Facebook操作对象
 */
public class FaceBookUtil {

	public static String genFBAttar(String userId) {

		String attarUrl = FacebookConfig.FACEBOOK_API_URL + "/" + userId + "/picture";
		return attarUrl;
	}

}

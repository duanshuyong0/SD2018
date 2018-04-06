package com.dsy.dadui.pc.web.utils;

import org.apache.commons.lang3.StringUtils;

import com.dsy.dadui.pc.web.constants.Constant;

/**
 * 图片工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年11月5日
 * @since 1.0
 */
public class ImageUtil {

	private ImageUtil() {
	};

	/**
	 * 得到图片全路径
	 * 
	 * @author taojg(云启)
	 * @time 下午4:24:28
	 * @param path
	 * @return
	 */
	public static String getImageFullPath(String path) {
		if (path == null || StringUtils.isEmpty(path)) {
			return "";
		}
		path = StringUtils.trim(path);
		if (!path.startsWith("http")) {
			return Constant.OSS_ENDPOINT + path;
		}

		return path;
	}

	public static String getHttpImgPath(String path) {
		if (null == path) {
			return null;
		}
		if (path.startsWith("https://")) {
			return path.replaceFirst("https://", "http://");
		}
		return path;
	}
}

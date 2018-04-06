package com.dsy.dadui.common.utils;

import java.util.UUID;

/**
 * uuid工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public abstract class UUIDUtil {

	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}
}

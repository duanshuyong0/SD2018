package com.dsy.dadui.common.utils;

/**
 * 公共key工具类
 *
 * @author <a href="mailto:taojiagui@59store.com">云启</a>
 * @version 1.0 2016年10月13日
 * @since 1.0
 */
public class CommonKeyUtil {

	private CommonKeyUtil() {
	}

	/**
	 * 生成唯一的key
	 * 
	 * <pre>
	 * uniqueKey:目前暂用uuid代替
	 * </pre>
	 * 
	 * @author taojiagui(云启)
	 * @time 下午2:09:55
	 * @return
	 */
	public static String genUniqueKey() {
		return UUIDUtil.uuid();
	}

	public static String genUniqueKey4Numeric() {
		return NumericUniqueKeyUtil.genUniqueKey();
	}

}

package com.dsy.dadui.common.utils;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

/**
 * 环境工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class EnvUtil {

	public static final String ENV_PROD = "prod";
	public static final String ENV_BENCHMARK = "benchmark";
	public static final String ENV_INTEGRATION = "integration";
	public static final String ENV_DEV = "dev";

	public static final String NAME_PROJECTNO = "LPROJECTNO";
	public static final String NAME_ENV = "LENV";

	public static void setProjectName(String projectName) {
		System.setProperty(NAME_PROJECTNO, projectName);
	}

	public static String getProjectCode() {
		String project = getenv(NAME_PROJECTNO);
		return project;
	}

	/**
	 * 获取当前运行环境(dev|test|prod)
	 * 
	 * @return
	 */
	public static String getEnv() {
		String env = getenv(NAME_ENV);
		if (StringUtils.isEmpty(env)) {
			return EnvUtil.ENV_DEV;
		}
		return env;
	}

	public static boolean isDevEnv() {
		String env = EnvUtil.getEnv();
		// AssertData.notEmpty(env, "未配置环境变量" + NAME_ENV + ".");
		return !EnvUtil.ENV_PROD.equalsIgnoreCase(env);
	}

	protected static String getenv(String name) {
		String value = System.getenv(name);
		if (StringUtils.isEmpty(value)) {
			value = System.getProperty(name);
		}
		return value;
	}

	public static String getModuleName(String path) {
		if (path.endsWith("/")) {
			throw new IllegalArgumentException("非法路径格式[" + path + "].");
		}
		int index = path.lastIndexOf("/");
		String moduleName = path.substring(index + 1);
		return moduleName;
	}

	/**
	 * 是否web环境.
	 * 
	 * @return
	 */
	public static boolean isWebserver() {
		throw new NotImplementedException("");
	}

	/**
	 * 是否单元测试
	 * 
	 * @return
	 */
	public static boolean isJunit() {
		String junit = System.getProperty("env.junit");
		return "true".equals(junit);
	}
}

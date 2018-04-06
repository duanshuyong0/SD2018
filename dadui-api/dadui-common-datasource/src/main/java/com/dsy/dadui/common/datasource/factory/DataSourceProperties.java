
package com.dsy.dadui.common.datasource.factory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源配置
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
@Configuration
@ConfigurationProperties(value = "spring.datasource", ignoreNestedProperties = false)
public class DataSourceProperties {

	public static String MAPPER_SCAN_PACKAGE = "spring.datasource.mapperpath";

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private int maxActive = 100;
	private int maxIdle = 10;
	private int minIdle = 5;
	private int initialSize = 2;
	private int maxWait = 60000;
	private int timeBetweenEvictionRunsMillis = 60000;
	private int minEictableIdleTimeMillis = 300000;
	private boolean testOnBorrow = false;
	private boolean testOnReturn = false;
	private boolean testWhileIdle = true;
	private String validationQuery;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getMinEictableIdleTimeMillis() {
		return minEictableIdleTimeMillis;
	}

	public void setMinEictableIdleTimeMillis(int minEictableIdleTimeMillis) {
		this.minEictableIdleTimeMillis = minEictableIdleTimeMillis;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

}

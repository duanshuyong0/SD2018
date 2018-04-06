
package com.dsy.dadui.common.datasource.factory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * DB配置
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {

	private Logger logger = LoggerFactory.getLogger(DBConfig.class);

	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		logger.debug("dataSourceProperties" + dataSourceProperties);

		// create tomcat jdbc pool
		DataSource ds = (DataSource) DataSourceBuilder.create().type(DataSource.class)
				.driverClassName(dataSourceProperties.getDriverClassName()).url(dataSourceProperties.getUrl())
				.username(dataSourceProperties.getUsername()).password(dataSourceProperties.getPassword()).build();
		ds.setMaxActive(dataSourceProperties.getMaxActive());
		ds.setValidationQuery(dataSourceProperties.getValidationQuery());
		ds.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
		ds.setTestOnReturn(dataSourceProperties.isTestOnReturn());
		ds.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
		ds.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
		ds.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEictableIdleTimeMillis());
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());

		try {
			// 指定mapper xml目录
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:*mapper*.xml"));
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@PostConstruct
	public void postConstruct() {
		logger.info("jdbc.settings={}", dataSourceProperties);
	}
}

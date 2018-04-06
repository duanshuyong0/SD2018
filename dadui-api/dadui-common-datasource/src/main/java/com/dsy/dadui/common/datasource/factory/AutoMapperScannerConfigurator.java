
package com.dsy.dadui.common.datasource.factory;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Mapper scanner配置
 * 
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年9月7日
 * @since 1.0
 */
@Configuration
@AutoConfigureAfter(DBConfig.class)
public class AutoMapperScannerConfigurator implements EnvironmentAware {

	private Environment environment;

	@Bean
	MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage(environment.getProperty(DataSourceProperties.MAPPER_SCAN_PACKAGE, ""));
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return configurer;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}

package com.dsy.dadui.pc.web.application;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dsy.dadui.pc.web.filter.xsssql.XssAndSqlFilter;
import com.dsy.dadui.pc.web.interceptor.LoginInterceptor;
import com.dsy.dadui.pc.web.interceptor.PostRequestInterceptor;

/**
 * Web config
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月18日
 * @since 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 排除/login/和商品评论
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/trial/**",
				"/**/login/**", "/dict/item/list", "/system/province/list", "/system/city/list", "/system/continent/**",
				"/system/country/list", "/password/forget/**");
		registry.addInterceptor(new PostRequestInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize("20Mb");
		multipartConfigFactory.setMaxRequestSize("20Mb");
		return multipartConfigFactory.createMultipartConfig();
	}

	@Bean
	public XssAndSqlFilter xssAndSqlFilter() {
		return new XssAndSqlFilter();
	}

}

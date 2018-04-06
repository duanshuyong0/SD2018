package com.dsy.dadui.pc.web.filter.xsssql;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * xss and sql注入过滤器
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年10月14日
 * @since 1.0
 */
@Component
public class XssAndSqlFilter implements Filter {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws ServletException, IOException {
		if (logger.isDebugEnabled()) {
			logger.debug("XssAndSqlFilter execute.");
		}
		XssAndSqlRequestWrapper xssRequest = new XssAndSqlRequestWrapper((HttpServletRequest) servletRequest);
		filterChain.doFilter(xssRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}

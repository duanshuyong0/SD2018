package com.dsy.dadui.pc.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Jsonp post提交处理拦截器
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class PostRequestInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(PostRequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (logger.isInfoEnabled()) {
			logger.info("PostRequestInterceptor.preHandle execute url={}", url);
		}

		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Headers",
				"Access-Control-Allow-Headers,X-Requested-With,X_Requested_With");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");

		if ("IE".equals(request.getParameter("type"))) {
			response.addHeader("XDomainRequestAllowed", "1");
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}

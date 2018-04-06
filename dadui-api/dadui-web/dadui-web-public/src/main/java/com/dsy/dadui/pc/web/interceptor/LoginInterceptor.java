package com.dsy.dadui.pc.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dsy.dadui.pc.web.vo.user.UserVO;
import com.dsy.dadui.sdk.utils.SessionConstUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author <a href="mailto:taojiagui@59store.com">云启</a>
 * @version 1.0 2016年9月28日
 * @since 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	//	SslUtils.ignoreSsl();
		// 请求的路径
		String contextPath = request.getContextPath();
		String url = request.getServletPath().toString();
	//	UserVO sessUser = (UserVO) request.getSession().getAttribute(SessionConstUtil.SESSION_USER_KEY);
		UserVO sessUser = (UserVO) request.getSession().getAttribute(SessionConstUtil.SESSION_USER_KEY);
		if (logger.isDebugEnabled()) {
			logger.debug("SessUser is null,request contextPath={},url={}", contextPath, url);
		}

		// 用户未登录或session失效
		if (sessUser == null) {
			request.getRequestDispatcher(contextPath + RequestUrlConstants.NO_SESSION_URL).forward(request, response);
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		SslUtils.ignoreSsl();
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}

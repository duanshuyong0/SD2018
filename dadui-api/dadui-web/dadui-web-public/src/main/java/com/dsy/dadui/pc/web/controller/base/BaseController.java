package com.dsy.dadui.pc.web.controller.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dsy.dadui.pc.web.vo.user.UserVO;
import com.dsy.dadui.sdk.utils.SessionConstUtil;
import com.google.common.collect.ImmutableMap;

/**
 * Controller 基类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月16日
 * @since 1.0
 */
public abstract class BaseController {

	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ImmutableMap<String, String> errorCodeMap;

	/**
	 * 接口数据返回
	 * @param errorCode
	 * @param data
	 * @return
	 */
	protected Map<String,Object> rtnParam(Integer errorCode,Object data) {
		//正常的业务逻辑 
		if(errorCode == 0){
			return ImmutableMap.of("errorCode", errorCode,"data", (data == null)? new Object() : data);
		}else{
			return ImmutableMap.of("errorCode", errorCode, "msg", errorCodeMap.get(String.valueOf(errorCode)));
		}
	}
	
	
	/**
	 * 得到session用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:39:43
	 * @param request
	 * @return
	 */
	protected UserVO getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (UserVO) session.getAttribute(SessionConstUtil.SESSION_USER_KEY);
	}

	/**
	 * 得到session用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:15:15
	 * @return
	 */
	protected UserVO getUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return getUser(request);
	}

	/**
	 * 得到当前会话用户ID
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:22:03
	 * @param request
	 * @return
	 */
	protected String getUserId(HttpServletRequest request) {
		return getUser(request).getUserId();
	}

	/**
	 * 得到当前会话用户ID
	 * 
	 * @author taojiagui(云启)
	 * @time 下午5:22:03
	 * @param request
	 * @return
	 */
	protected String getUserId() {
		return getUser().getUserId();
	}

	/**
	 * session设置
	 * 
	 * @author taojiagui(云启)
	 * @time 下午4:29:28
	 * @param request
	 * @param sessUser
	 */
	protected void setSession(HttpServletRequest request, UserVO sessUser) {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		logger.debug(sessionId);
		if (sessUser != null) {
			session.setAttribute(SessionConstUtil.SESSION_USER_KEY, sessUser);
		}
	}

	/**
	 * 清除session
	 * 
	 * @author taojiagui(云启)
	 * @time 上午11:35:37
	 * @param request
	 */
	protected void removeSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(SessionConstUtil.SESSION_USER_KEY);
	}

	/**
	 * 返回HttpServletRequest
	 * 
	 * @author taojiagui(云启)
	 * @time 下午7:40:36
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取域名
	 * 
	 * @author guoxubin
	 * @time 下午5:02:01
	 * @return
	 */
	protected String getHostName() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取域名
		StringBuffer url = request.getRequestURL();
		String hostName = url.delete(url.length() - request.getRequestURI().length(), url.length())
				.append(request.getServletContext().getContextPath()).toString();
		return hostName;
	}

	/**
	 * 获取 https 域名
	 * 
	 * @author guoxubin
	 * @time 下午5:02:26
	 * @return
	 */
	protected String getHttpsHost() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取域名
		StringBuffer url = request.getRequestURL();
		String hostName = url.delete(url.length() - request.getRequestURI().length(), url.length())
				.append(request.getServletContext().getContextPath()).toString();

		if (hostName.startsWith("http://")) {
			return hostName.replaceFirst("http://", "https://");
		}
		return hostName;
	}

}

package com.dsy.dadui.pc.web.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.pc.web.controller.base.BaseController;

/**
 * 注销
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2017年1月17日
 * @since 1.0
 */
@RequestMapping("")
@RestController()
public class LogoutController extends BaseController {

	/**
	 * 注销
	 * 
	 * @author taojiagui(云启)
	 * @time 上午9:47:27
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Result<?> logout(HttpServletRequest request) {
		try {
			removeSession(request);
		} catch (Exception e) {
			logger.error("Logout error：" + e.getMessage(), e);
		}
		return Result.success(true);
	}

}

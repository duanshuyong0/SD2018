package com.dsy.dadui.pc.web.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.common.enums.LogicValueEnum;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.pc.web.controller.base.BaseController;
import com.dsy.dadui.pc.web.facade.user.UserFacade;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.utils.CaptchaUtil;
import com.dsy.dadui.pc.web.utils.CheckUtil;
import com.dsy.dadui.pc.web.view.CaptchaView;
import com.dsy.dadui.pc.web.vo.user.UserVO;

/**
 * 登录Controller
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月20日
 * @since 1.0
 */
@RequestMapping("/login")
@RestController
public class LoginController extends BaseController {

	@Autowired
	private UserFacade userFacade;


	/**
	 * 得到登录校验码图片
	 * 
	 * @author taojiagui(云启)
	 * @time 下午7:16:02
	 * @return
	 */
	@RequestMapping(value = "/captcha/get", method = RequestMethod.GET)
	public CaptchaView getCaptcha() {
		return new CaptchaView("login");
	}

	/**
	 * 登录
	 * @param userForm
	 * @param request
	 * @return
	 */
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result<UserVO> login(UserForm userForm,
			HttpServletRequest request) {

		if (StringUtils.isBlank(userForm.getOpenid())){
			return Result.failure("微信登录ID为空");
		}


		UserVO userVO = null;
		try {
			// userVO = userFacade.login(userForm, request);
			userVO =new UserVO();
			userVO.setOpenId("llllll");
			userVO.setSessionId(request.getSession().getId());
			setSession(request, userVO);
		} catch (BusinessException be) {
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("登录失败：" + e.getMessage(), e);
			return Result.failure("登录出错");
		}
		
		return Result.success(userVO);
	}


	private boolean checkCaptcha(HttpServletRequest request, String captcha) {
		String s = CaptchaUtil.getCode(request, "login");
		if (StringUtils.isBlank(s)) {
			return false;
		}
		captcha = StringUtils.trim(captcha);
		return StringUtils.equalsIgnoreCase(s, captcha);
	}


	
	@RequestMapping(value = "nosession", method = RequestMethod.GET)
	public Result<String> noSession() {
		Result<String> result = Result.failure("Users are not logged in or session expires");
		result.setCode(1010);
		return result;
	}

//	/**
//	 * 第一次登录修改密码
//	 * 
//	 * @author taojiagui(云启)
//	 * @time 下午8:26:03
//	 * @param newpwd
//	 * @return
//	 */
//	@RequestMapping(value = "/password/first/update", method = RequestMethod.POST)
//	public Result<Boolean> firstLoginUpdate(String newpwd) {
//		try {
//			return Result.success(userFacade.updatePassword(getUserId(), newpwd));
//		} catch (BusinessException e) {
//			return Result.failure(e.getMessage());
//		} catch (Exception e) {
//			logger.error("首次登录修改密码失败：" + e.getMessage(), e);
//			return Result.failure("首次登录修改密码失败");
//		}
//	}
}

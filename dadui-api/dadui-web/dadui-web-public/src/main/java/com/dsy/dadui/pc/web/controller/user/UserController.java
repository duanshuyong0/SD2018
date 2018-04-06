package com.dsy.dadui.pc.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.pc.web.controller.base.BaseController;
import com.dsy.dadui.pc.web.facade.org.OrgFacade;
import com.dsy.dadui.pc.web.facade.user.UserFacade;
import com.dsy.dadui.pc.web.form.user.UserEditFirstForm;
import com.dsy.dadui.pc.web.form.user.UserEditSecondForm;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.vo.org.ConListVO;
import com.dsy.dadui.pc.web.vo.org.UserListVO;
import com.dsy.dadui.pc.web.vo.user.UserDetailVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgCon;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController{

	
	@Autowired
	private UserFacade userFacade;
    
	/**
     * 查询用户详情接口
     * 
     * @author duanshuyong
     * @time 上午11:44:39  
     * @return
     */

	@RequestMapping(value = "/detail", method = RequestMethod.GET )
	public Result<UserDetailVO> detail(@RequestParam("userId") String userId) {
		try {
			return Result.success("成功", userFacade.detail(userId,getUserId()));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("查询用户详情失败，异常详情：{}", e.getMessage());
			return Result.failure("查询用户详情失败");
		}
	}
	
	/**
	 * 用户个人信息编辑第一步接口
	* @Title: UserController.java 
	* @Package com.dsy.dadui.pc.web.controller.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月26日 下午4:58:24 
	* @param userEditFirstForm
	* @return
	* @version V1.0
	 */
	@RequestMapping(value = "/edit/first", method = RequestMethod.POST )
	public Result<Boolean> editFirst(UserEditFirstForm userEditFirstForm) {
		try {
			return Result.success("成功", userFacade.editFirst(userEditFirstForm,getUserId()));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("编辑用户详情失败，异常详情：{}", e.getMessage());
			return Result.failure("编辑用户详情失败");
		}
	}
	
	/**
	 * 用户个人信息编辑第二步接口
	* @Title: UserController.java 
	* @Package com.dsy.dadui.pc.web.controller.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月26日 下午4:58:52 
	* @param userEditSecondForm
	* @return
	* @version V1.0
	 */
	@RequestMapping(value = "/edit/second", method = RequestMethod.POST )
	public Result<Boolean> editSecond(UserEditSecondForm userEditSecondForm) {
		try {
			return Result.success("成功", userFacade.editSecond(userEditSecondForm,getUserId()));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("编辑用户详情失败，异常详情：{}", e.getMessage());
			return Result.failure("编辑用户详情失败");
		}
	}
	

	
	
}

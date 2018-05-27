package com.dsy.dadui.pc.web.controller.org;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsy.dadui.common.beans.Page;
import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.pc.web.controller.base.BaseController;
import com.dsy.dadui.pc.web.facade.org.OrgFacade;
import com.dsy.dadui.pc.web.form.org.OrgForm;
import com.dsy.dadui.pc.web.form.org.UserListForm;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.vo.org.ConListVO;
import com.dsy.dadui.pc.web.vo.org.UserListVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgCon;

@RequestMapping("/org")
@RestController
public class OrgController extends BaseController{

	
	@Autowired
	private OrgFacade orgFacade;
    
	/**
     * 查询群组列表接口
     * 
     * @author duanshuyong
     * @time 上午11:44:39  
     * @return
     */

	@RequestMapping(value = "/list", method = RequestMethod.GET )
	public Result<Page<Org>> queryList(OrgForm orgForm,
			HttpServletRequest request) {
		try {
			
			return Result.success("成功", orgFacade.list(orgForm));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("查询频道列表失败，异常详情：{}", e.getMessage());
			return Result.failure("查询频道列表失败");
		}
	}
	
	
	
	@RequestMapping(value = "/con/list", method = RequestMethod.GET )
	public Result<List<ConListVO>> conList(@RequestParam("orgId") long orgId) {
		try {
			
			return Result.success("成功", orgFacade.conList(orgId,getUserId()));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("查询群组内容列表失败，异常详情：{}", e.getMessage());
			return Result.failure("查询群组内容列表失败");
		}
	}
	
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET )
	public Result<Page<UserListVO>> userList(UserListForm queryParam) {
		try {
			
			return Result.success("成功", orgFacade.userList(queryParam,getUserId()));
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("查询群组人员列表失败，异常详情：{}", e.getMessage());
			return Result.failure("查询群组人员列表失败");
		}
	}
	
}

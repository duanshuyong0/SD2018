package com.dsy.dadui.pc.web.controller.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsy.dadui.common.beans.Page;
import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.pc.web.controller.base.BaseController;
import com.dsy.dadui.pc.web.facade.org.OrgAdvertFacade;
import com.dsy.dadui.pc.web.facade.org.OrgFacade;
import com.dsy.dadui.pc.web.form.org.UserListForm;
import com.dsy.dadui.pc.web.vo.org.ConListVO;
import com.dsy.dadui.pc.web.vo.org.UserListVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgAdvert;
import com.dsy.dadui.sdk.entity.org.OrgCon;

@RequestMapping("/org")
@RestController
public class OrgAdvertController extends BaseController{

	
	@Autowired
	private OrgAdvertFacade orgAdvertFacade;
    
	/**
     * 查询群组列表接口
     * 
     * @author duanshuyong
     * @time 上午11:44:39  
     * @return
     */

	@RequestMapping(value = "/advert/list", method = RequestMethod.GET )
	public Result<List<OrgAdvert>> queryList() {
		try {
			
			return Result.success("成功", orgAdvertFacade.list());
		} catch(BusinessException be){
			return Result.failure(be.getMessage());
		} catch (Exception e) {
			logger.error("查询广告列表失败，异常详情：{}", e.getMessage());
			return Result.failure("查询群组列表失败");
		}
	}
	
	
}

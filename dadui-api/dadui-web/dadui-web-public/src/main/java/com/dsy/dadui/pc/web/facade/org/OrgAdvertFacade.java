package com.dsy.dadui.pc.web.facade.org;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsy.dadui.common.beans.Page;
import com.dsy.dadui.common.constants.DeleteTagConstant;
import com.dsy.dadui.common.enums.DeviceSourceEnum;
import com.dsy.dadui.common.enums.LogicValueEnum;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.common.utils.CommonKeyUtil;
import com.dsy.dadui.common.utils.DateUtil;
import com.dsy.dadui.common.utils.MD5;
import com.dsy.dadui.pc.web.form.org.UserListForm;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.form.user.UserTrialForm;
import com.dsy.dadui.pc.web.vo.org.ConListVO;
import com.dsy.dadui.pc.web.vo.org.UserListVO;
import com.dsy.dadui.pc.web.vo.user.UserVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgAdvert;
import com.dsy.dadui.sdk.entity.org.OrgCon;
import com.dsy.dadui.sdk.entity.org.OrgUser;
import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserExtend;
import com.dsy.dadui.sdk.entity.user.UserImg;
import com.dsy.dadui.sdk.enums.user.AccountStatusEnum;
import com.dsy.dadui.sdk.enums.user.UserTypeEnum;
import com.dsy.dadui.sdk.query.org.UserListQuery;
import com.dsy.dadui.sdk.service.org.OrgAdvertService;
import com.dsy.dadui.sdk.service.org.OrgConService;
import com.dsy.dadui.sdk.service.org.OrgService;
import com.dsy.dadui.sdk.service.org.OrgUserService;
import com.dsy.dadui.sdk.service.user.UserExtendService;
import com.dsy.dadui.sdk.service.user.UserService;

/**
 * 用户facade
 * @author Lenovo
 *
 */
@Service
public class OrgAdvertFacade {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private OrgAdvertService orgAdvertService;
	
	@Autowired
	private OrgUserService orgUserService;
	
	@Autowired
	private UserExtendService userExtendService;

	
	private static final String INIT_PASSWORD = "123456";

	/**
	 * 获取圈子列表
	 * @param userId
	 * @return
	 */
	public List<OrgAdvert> list() {
		//get OrgAdvert
		List<OrgAdvert> org = orgAdvertService.getList();

		return org;
		
	}
	
	
	
	
}

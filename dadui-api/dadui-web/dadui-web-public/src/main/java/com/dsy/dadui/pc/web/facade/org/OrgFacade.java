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
import com.dsy.dadui.pc.web.form.org.OrgForm;
import com.dsy.dadui.pc.web.form.org.UserListForm;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.form.user.UserTrialForm;
import com.dsy.dadui.pc.web.vo.org.ConListVO;
import com.dsy.dadui.pc.web.vo.org.UserListVO;
import com.dsy.dadui.pc.web.vo.user.UserVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.org.OrgCon;
import com.dsy.dadui.sdk.entity.org.OrgUser;
import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserExtend;
import com.dsy.dadui.sdk.entity.user.UserImg;
import com.dsy.dadui.sdk.enums.user.AccountStatusEnum;
import com.dsy.dadui.sdk.enums.user.UserTypeEnum;
import com.dsy.dadui.sdk.query.org.OrgQuery;
import com.dsy.dadui.sdk.query.org.UserListQuery;
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
public class OrgFacade {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private OrgConService orgConService;
	
	@Autowired
	private OrgUserService orgUserService;
	
	@Autowired
	private UserExtendService userExtendService;

	
	private static final String INIT_PASSWORD = "123456";

	/**
	 * 获取圈子列表
	 * @param orgForm
	 * @return
	 */
	public Page<Org> list(OrgForm orgForm) {
		//get org
		Page<Org> orgs= new Page<Org>();
		

		OrgQuery query = new OrgQuery();
		query.setQueryParam(orgForm);
		query.setOpenId(orgForm.getOpenId());
		query.setPaging(Boolean.TRUE);
		// get count
		int count = orgService.queryCount(query);
		if (count == 0) {
			return orgs;
		}
		//get list
		List<Org> org = orgService.getList(query);
		
		orgs.setTotalCount(count);
		orgs.setRecords(org);

		return orgs;
		
	}
	
	
	/**
	 * 查询群组内容列表
	 * @param orgId
	 * @param userId
	 * @return
	 */
	public List<ConListVO> conList(long orgId, String userId) {
		// TODO Auto-generated method stub
		List<ConListVO> conListVOList= Lists.newArrayList();
		
		List<OrgCon> orgCon = orgConService.getList(orgId);
		
		//query  user by create_user_id
		List<String> userIds = orgCon.stream().map(e -> e.getCreateUserId()).collect(Collectors.toList());
		
		// get user
		List<User> userList = userService.queryByIdList(userIds);
		
		//build the conListVO
		// build data
		orgCon.stream().forEach(m -> {
			List<User> s = userList.stream().filter(e -> e.getId() .equals(m.getCreateUserId()))
					.collect(Collectors.toList());
			ConListVO  conListVO= buildconListVO(m,s);
			conListVOList.add(conListVO);
		});
		return conListVOList;
	}
	
	/**
	 * 返回群组里面的用户LIST
	 * @param orgId
	 * @param userId
	 * @return
	 */
	public Page<UserListVO> userList(UserListForm queryParam, String userId) {
		
		Page<UserListVO> userListVOS = new Page<UserListVO>();
		
		UserListQuery query = new UserListQuery();
		query.setQueryParam(queryParam);
		query.setOrgId(queryParam.getOrgId());;
		query.setPaging(Boolean.TRUE);
		
		
		List<UserListVO> userListVOList= Lists.newArrayList();
		
		List<OrgUser> orgUser = orgUserService.getList(queryParam.getOrgId());
		
		List<String> userIds = orgUser.stream().map(e -> e.getUserId()).collect(Collectors.toList());
		
		
		//query user 
		List<User> userList = userService.queryByIdList(userIds);
		
		//query user extend info
		List<UserExtend> userExtendList = userExtendService.queryByIdList(userIds);
		
		// build data
		orgUser.stream().forEach(m -> {
			List<User> s = userList.stream().filter(e -> e.getId() .equals(m.getUserId()))
					.collect(Collectors.toList());
			List<UserExtend> ue = userExtendList.stream().filter(e -> e.getUserId().equals(m.getUserId()))
					.collect(Collectors.toList());
			UserListVO  userListVO= buildUserListVO(m,s,ue);
			userListVOList.add(userListVO);
		});
		
		//设置总的数量
		userListVOS.setTotalCount(10);
		
		//设置返回记录
		userListVOS.setRecords(userListVOList);

		return userListVOS;
	}
	
	
	// build userListVO
	private UserListVO buildUserListVO(OrgUser m, List<User> s, List<UserExtend> ue) {
		UserListVO  userListVO = new UserListVO();
		userListVO.setId(m.getUserId());
		if(null != s && !s.isEmpty()){
			userListVO.setAvatarUrl(s.get(0).getAvatarUrl());
			userListVO.setGender(s.get(0).getGender());
			userListVO.setNickname(s.get(0).getNickname());
		}
		
		if(null != ue && !ue.isEmpty()){
			userListVO.setBirthdayTime(ue.get(0).getBirthdayTime());
		}
		return userListVO;
	}


	//  build buildconListVO
	private ConListVO buildconListVO(OrgCon m, List<User> s) {
		ConListVO conListVO = new ConListVO();
		if(null != s && !s.isEmpty()){
			conListVO.setAvatarUrl(s.get(0).getAvatarUrl());
			conListVO.setCreateUserId(m.getCreateUserId());
			conListVO.setNickname(s.get(0).getNickname());
			conListVO.setCreateTime(m.getCreateTime());
			conListVO.setCon(m.getCon());
		}
		return conListVO;
	}

	
	
	
}

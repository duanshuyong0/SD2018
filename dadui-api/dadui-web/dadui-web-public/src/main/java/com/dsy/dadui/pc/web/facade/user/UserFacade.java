package com.dsy.dadui.pc.web.facade.user;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsy.dadui.common.constants.DeleteTagConstant;
import com.dsy.dadui.common.enums.DeviceSourceEnum;
import com.dsy.dadui.common.enums.LogicValueEnum;
import com.dsy.dadui.common.exception.BusinessException;
import com.dsy.dadui.common.utils.CommonKeyUtil;
import com.dsy.dadui.common.utils.DateUtil;
import com.dsy.dadui.common.utils.MD5;
import com.dsy.dadui.pc.web.form.user.UserEditFirstForm;
import com.dsy.dadui.pc.web.form.user.UserEditSecondForm;
import com.dsy.dadui.pc.web.form.user.UserForm;
import com.dsy.dadui.pc.web.form.user.UserTrialForm;
import com.dsy.dadui.pc.web.vo.user.UserDetailVO;
import com.dsy.dadui.pc.web.vo.user.UserVO;
import com.dsy.dadui.sdk.entity.org.Org;
import com.dsy.dadui.sdk.entity.user.User;
import com.dsy.dadui.sdk.entity.user.UserExtend;
import com.dsy.dadui.sdk.entity.user.UserImg;
import com.dsy.dadui.sdk.enums.user.AccountStatusEnum;
import com.dsy.dadui.sdk.enums.user.UserTypeEnum;
import com.dsy.dadui.sdk.service.org.OrgService;
import com.dsy.dadui.sdk.service.user.UserExtendService;
import com.dsy.dadui.sdk.service.user.UserImgService;
import com.dsy.dadui.sdk.service.user.UserService;
import com.sun.mail.handlers.message_rfc822;

/**
 * 用户facade
 * @author Lenovo
 *
 */
@Service
public class UserFacade {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private UserExtendService userExtendService;
	
	@Autowired
	private UserImgService userImgService;

	private static final String INIT_PASSWORD = "123456";

	@Value("${image.root}")
	private String imageRoot;
	
	@Transactional
	public UserVO login(UserForm userForm, HttpServletRequest request) {
		
		UserVO userVO = new UserVO();
		
		User user = userService.getByAccount(userForm.getOpenid());
		
		Boolean flag=false;
		//add user
		if (user == null) {
			user = new User();
			user.setId(CommonKeyUtil.genUniqueKey());
			user.setOpenid(userForm.getOpenid());
			user.setNickname(userForm.getNickname());
			user.setAvatarUrl(userForm.getAvatarUrl());
			user.setCountry(userForm.getCountry());
			user.setProvience(userForm.getProvience());
			user.setGender(userForm.getGender());
			user.setDeleteTag(DeleteTagConstant.NO);
			user.setCity(userForm.getCity());
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			flag = userService.insert(user);
		}
		
		userVO.setUserId(user.getId());
		userVO.setOpenId(user.getOpenid());
		
		//get org
//		List<Org> org = orgService.getList();
//		
//		userVO.setOrg(Lists.newArrayList());
//		org.stream().forEach(m -> {
//			userVO.getOrg().add(m);
//			});
//		
		//set org
//		userVO.setOrg(org);
		return userVO;
		
	}

	/**
	 * 填充用户
	 * 
	 * @time 下午7:27:50
	 * @param user
	 * @return
	 */
//	private UserVO buildUserVO(User user) {
//		UserVO userVO = new UserVO();
//		userVO.setAccountStatus(user.getAccountStatus());
//		userVO.setAvatar(user.getAvatar());
//		userVO.setIsFirstLogin(user.getIsFirstLogin());
//		userVO.setLoginAccount(user.getLoginAccount());
//		userVO.setLoginTime(new Date());
//		userVO.setName(user.getName());
//		// 账号过期时间
//		userVO.setOverdueTime(null);
//	
//		return userVO;
//	}


	/**
	 * 获取6位随机数
	 * 
	 * @author taojiagui(云启)
	 * @time 上午10:06:24
	 * @return
	 */
	private String getSixNumStr() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 得到用户信息
	 * 
	 * @author taojiagui(云启)
	 * @time 下午4:36:37
	 * @param userId
	 * @return
	 */
	public User getUserInfo(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		return userService.get(userId);
	}

	/**
	 * 更新用户
	 * 
	 * @author taojiagui(云启)
	 * @time 下午4:51:44
	 * @param user
	 * @return
	 */
	@Transactional
	public boolean updateUser(User user) {
		if (user == null) {
			return false;
		}
		user.setUpdateTime(new Date());
		return userService.update(user);
	}
	
	
	/**
	 * 
	* @Title: UserFacade.java 查询用户详情信息接口
	* @Package com.dsy.dadui.pc.web.facade.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 上午8:47:20 
	* @param userId  用户ID
	* @param loginUserId   当前登录用户ID 
	* @return
	* @version V1.0
	 */
	public UserDetailVO detail(String userId, String loginUserId) {
		
		UserDetailVO  userDetailVO = new UserDetailVO();
		userId=loginUserId;
		//query user
		User user = userService.get(loginUserId);
		
		UserExtend userExtend= new UserExtend();
		List<UserImg> userImg = Lists.newArrayList();
		
		//query user Extend
		if(user.getFirstEdit()>0){
		 userExtend= userExtendService.get(userId);
		
		//query user Img
		 userImg = userImgService.get(userId);
		 if(!userImg.isEmpty()){  
			 userImg.stream().forEach(m ->{
				 m.setImgPath(imageRoot+m.getImgPath());
			 });
		 }
		}
		
		//设置  userImg
		
		//build the data
		userDetailVO.setAvatarUrl(user.getAvatarUrl());
		userDetailVO.setCity(user.getCity());
		userDetailVO.setGender(user.getGender());
		userDetailVO.setNickname(user.getNickname());
		userDetailVO.setWechat(user.getWechat());
		userDetailVO.setIsAlone(user.getIsAlone());
		
		userDetailVO.setBirthdayTime(userExtend.getBirthdayTime());
		userDetailVO.setHeight(userExtend.getHeight());
		userDetailVO.setIsCar(userExtend.getIsCar());
		userDetailVO.setIsHouse(userExtend.getIsHouse());
		userDetailVO.setIntroduce(userExtend.getIntroduce());
		userDetailVO.setProfession(userExtend.getProfession());
		userDetailVO.setIncome(userExtend.getIncome());
		userDetailVO.setDegree(userExtend.getDegree());
		userDetailVO.setWeChatNum(userExtend.getWeChatNum());
		userDetailVO.setUserImg(userImg);
		userDetailVO.setRequire(userExtend.getRequire());
		return userDetailVO;
	}

	 
	/**   
	* @Title: 用户个人信息编辑第一步 
	* @Package com.dsy.dadui.pc.web.facade.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 下午3:46:35 
	* @param userEditFirstForm
	* @param userId
	* @return
	* @version V1.0   
	*/
	public Boolean editFirst(UserEditFirstForm userEditFirstForm, String userId) {
		
		Boolean flag = false;
		
		User user=userService.get(userId);
		
		if(user.getFirstEdit()>0){
			//不是第一次编辑，则直接更新
	//	user.setIsAlone(userEditFirstForm.get);
		user.setUpdateTime(new Date());
		user.setFirstEdit(10);
		flag = userService.update(user);
		
		UserExtend userExtend = new UserExtend();
		userExtend.setUserId(userId);
		userExtend.setBirthdayTime(DateUtil.parse(userEditFirstForm.getBirthday(), "YYYY-MM-DD"));
		userExtend.setUpdateTime(new Date());
		userExtend.setHeight(userEditFirstForm.getHeight());
		userExtend.setProfession(userEditFirstForm.getProfession());
		userExtend.setIncome(userEditFirstForm.getIncome());
		flag = userExtendService.updateBySet(userExtend);
		}else{
			//是第一次编辑，则直接插入extend表
			//	user.setIsAlone(userEditFirstForm.get);
			user.setUpdateTime(new Date());
			user.setFirstEdit(10);
			flag = userService.update(user);
			UserExtend userExtend = new UserExtend();
			userExtend.setUserId(userId);
			userExtend.setBirthdayTime(DateUtil.parse(userEditFirstForm.getBirthday(), "YYYY-MM-DD"));
			userExtend.setUpdateTime(new Date());
			userExtend.setHeight(userEditFirstForm.getHeight());
			userExtend.setProfession(userEditFirstForm.getProfession());
			userExtend.setIncome(userEditFirstForm.getIncome());
			flag = userExtendService.insert(userExtend);
			
		}
		return flag;
		
	}

	 
	/**   
	 * 用户信息编辑的第二个步骤
	* @Title: UserFacade.java 
	* @Package com.dsy.dadui.pc.web.facade.user 
	* @Description: TODO
	* @author duanshuyong  duanshuyong0@gmail.com
	* @date 2017年6月24日 下午4:41:34 
	* @param userEditSecondForm
	* @param userId
	* @return
	* @version V1.0   
	*/
	public Boolean editSecond(UserEditSecondForm userEditSecondForm, String userId) {

		Boolean flag = false;
		
		User user=userService.get(userId);
		
		if(user.getSecondEdit()>0){
			//不是第一次编辑，则直接更新
	//	user.setIsAlone(userEditFirstForm.get);
		user.setUpdateTime(new Date());
		
		// second edit不为空，即为第二次编辑
		
		user.setSecondEdit(10);;
		flag = userService.update(user);
		
		UserExtend userExtend = new UserExtend();
		userExtend.setUserId(userId);
		userExtend.setIntroduce(userEditSecondForm.getIntroduce());
		userExtend.setRequire(userEditSecondForm.getRequire());
		userExtend.setUpdateTime(new Date());
		
		flag = userExtendService.updateBySet(userExtend);
		}else{
			//是第一次编辑，则直接插入extend表
			//	user.setIsAlone(userEditFirstForm.get);
			user.setUpdateTime(new Date());
			user.setSecondEdit(10);
			flag = userService.update(user);
			
			UserExtend userExtend = new UserExtend();
			userExtend.setUserId(userId);
			userExtend.setIntroduce(userEditSecondForm.getIntroduce());
			userExtend.setRequire(userEditSecondForm.getRequire());
			userExtend.setUpdateTime(new Date());
			
			flag = userExtendService.insert(userExtend);
		}
		return flag;
	}

}

package com.dsy.dadui.pc.web.form.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户注册试用Form
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月22日
 * @since 1.0
 */
public class UserTrialForm {

	@NotBlank(message = "姓名不能为空")
	@Length(min = 1, max = 50, message = "姓名长度范围要求(1-50)位")
	private String name;

	@NotBlank(message = "登录账号不能为空")
	@Length(min = 11, max = 11, message = "手机号长度要求11位")
	private String loginAccount;

	@NotBlank(message = "公司名称不能为空")
	@Length(min = 6, max = 100, message = "公司名称长度范围要求(6-100)位")
	private String regCompany;

	@NotBlank(message = "邮箱不能为空")
	@Length(min = 5, max = 50, message = "邮箱长度范围长度要求(5-50)位")
	private String mail;

	private String ip;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getRegCompany() {
		return regCompany;
	}

	public void setRegCompany(String regCompany) {
		this.regCompany = regCompany;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}

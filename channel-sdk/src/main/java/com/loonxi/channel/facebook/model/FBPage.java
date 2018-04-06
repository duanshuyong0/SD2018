package com.loonxi.channel.facebook.model;

import java.util.Date;
import java.util.List;

/**
 * 公司主页简介
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月6日
 * @since 1.0
 */
public class FBPage {

	/** 公司id */
	private String id;
	/** 公司头像 */
	private String attar;
	/** 公司简介 */
	private String about;
	/** 开始日期 */
	private Date createdTime;
	/** 奖章荣誉 */
	private String awards;
	/** 公司详情 */
	private String description;
	/** 所属行业 */
	private String category;
	/** 地址 */
	private Location location;
	/** 网址 */
	private String website;
	/** 邮箱 */
	private List<String> emails;
	/** 名称 */
	private String name;
	/** @ 后的名称 */
	private String userName;
	/** 联系电话 */
	private String phone;
	/** 主营产品 */
	private String products;
	/** 主页地址 */
	private String homePage;
	/** 主页token*/
	private String token;
	/**
	 * 主页的点赞数
	 */
	private int likes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAttar() {
		return attar;
	}

	public void setAttar(String attar) {
		this.attar = attar;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}

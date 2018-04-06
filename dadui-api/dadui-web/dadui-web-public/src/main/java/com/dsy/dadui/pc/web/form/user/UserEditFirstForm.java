/**
 * 
 */
package com.dsy.dadui.pc.web.form.user;

 
/**   
* @Title: UserEditFirstForm.java 
* @Package com.dsy.dadui.pc.web.form.user 
* @Description: TODO
* @author duanshuyong  duanshuyong0@gmail.com
* @date 2017年6月24日 下午3:45:32 
* @version V1.0   
*/
public class UserEditFirstForm {
	
	/**
	 * 生日
	 */
	private String birthday;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 高度
	 */
	private int height;
	
	/**
	 * 收入
	 */
	private String income;
	
	/**
	 * 是否有房
	 */
	private Boolean hasHouse;
	
	/**
	 * 是否有车
	 */
	private Boolean hasCar;
	
	/**
	 * 职业
	 */
	private String profession;
	
	
	
	
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Boolean getHasHouse() {
		return hasHouse;
	}

	public void setHasHouse(Boolean hasHouse) {
		this.hasHouse = hasHouse;
	}

	public Boolean getHasCar() {
		return hasCar;
	}

	public void setHasCar(Boolean hasCar) {
		this.hasCar = hasCar;
	}
	
	
	
}

package com.loonxi.channel.facebook.model;

/**
 * 位置详情
 *
 * @author <a href="mailto:chenjingyun@loonxi.com"></a>
 * @version 1.0 2017年1月6日
 * @since 1.0
 */
public class Location {
	/** 城市 */
	private String city;
	/** 国家 */
	private String country;
	/** 纬度 */
	private double latitude;
	/** 经度 */
	private double longitude;
	/** 邮编 */
	private String postCode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
}

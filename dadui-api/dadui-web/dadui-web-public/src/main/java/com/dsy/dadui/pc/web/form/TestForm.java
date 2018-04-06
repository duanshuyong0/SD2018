package com.dsy.dadui.pc.web.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * Form test
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class TestForm {

	@NotEmpty // make sure name is not empty
	String name;
	@Range(min = 1, max = 150, message = "111") // age need between 1 and 150
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

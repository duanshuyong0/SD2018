package com.dsy.dadui.common.beans;

import org.springframework.util.Assert;

import com.dsy.dadui.common.enums.ResultCodeEnum;

/**
 * 结果包装对象
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class Result<T> extends Entity {

	private static final long serialVersionUID = -3065825063148438711L;

	// 返回码
	private int code = ResultCodeEnum.SUCCESS.getCode();
	private String message;
	private T data;

	public static <T> Result<T> from(Result<T> result) {
		Assert.notNull(result, "系统错误:非法的操作结果");
		return build(ResultCodeEnum.getResultCode(result.getCode()), result.getMessage(), result.getData());
	}

	public static <T> Result<T> success() {
		return build(ResultCodeEnum.SUCCESS, null, null);
	}

	public static <T> Result<T> success(T data) {
		return build(ResultCodeEnum.SUCCESS, null, data);
	}

	public static <T> Result<T> success(String message) {
		return build(ResultCodeEnum.SUCCESS, message, null);
	}

	public static <T> Result<T> success(String message, T content) {
		return build(ResultCodeEnum.SUCCESS, message, content);
	}

	public static <T> Result<T> failure() {
		return build(ResultCodeEnum.NORMAL_ERROR, null, null);
	}

	public static <T> Result<T> failure(String message) {
		return build(ResultCodeEnum.NORMAL_ERROR, message, null);
	}

	public static <T> Result<T> failure(String message, T content) {
		return build(ResultCodeEnum.NORMAL_ERROR, message, content);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Result<T> build(ResultCodeEnum code, String message, T data) {
		Result ajax = new Result();
		ajax.setMessage(message);
		ajax.setCode(code.getCode());
		ajax.setData(data);
		return ajax;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

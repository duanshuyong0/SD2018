package com.dsy.dadui.pc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsy.dadui.common.beans.Result;
import com.dsy.dadui.common.exception.BusinessException;

/**
 * 业务异常统一处理器
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年11月4日
 * @since 1.0
 */
@ControllerAdvice
public class BusinessExceptionHandler {

	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public Result<String> jsonErrorHandler(HttpServletRequest req, BusinessException e) throws Exception {
		return Result.failure(e.getMessage());
	}

}

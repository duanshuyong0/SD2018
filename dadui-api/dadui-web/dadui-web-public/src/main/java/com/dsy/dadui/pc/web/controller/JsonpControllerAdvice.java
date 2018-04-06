package com.dsy.dadui.pc.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Jsonp advice
 *
 * @author <a href="mailto:taojiagui@59store.com">云启</a>
 * @version 1.0 2016年10月10日
 * @since 1.0
 */
@ControllerAdvice
public class JsonpControllerAdvice extends AbstractJsonpResponseBodyAdvice {
	public JsonpControllerAdvice() {
		super("callback");
	}
}

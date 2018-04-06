package com.dsy.dadui.common.exception;

/**
 * 系统异常
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class SysException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String appError;

	private Throwable parentThrowable;

	public SysException(final String appError, final Throwable nestedThrowable) {
		super();
		this.appError = appError;
		this.parentThrowable = nestedThrowable;
	}

	public SysException(final String appError) {
		this(appError, null);
	}

	public String getAppError() {
		return appError;
	}

	public Throwable getParentThrowable() {
		return parentThrowable;
	}

}

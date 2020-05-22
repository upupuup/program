package com.navi.mini.program.common.exception;

/**
 * 自定义异常类
 * @Author: jiangzhihong
 * @CreateDate: 2020/5/22 10:09
 */
public class NoLoginException extends Exception {
	public NoLoginException() {
		super();
	}

	public NoLoginException(String message) {
		super(message);
	}

	public NoLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoLoginException(Throwable cause) {
		super(cause);
	}

	protected NoLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

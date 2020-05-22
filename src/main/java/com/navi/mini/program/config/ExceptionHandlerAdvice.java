package com.navi.mini.program.config;

import com.navi.mini.program.common.exception.NoLoginException;
import com.navi.mini.program.common.response.BaseResponse;
import com.navi.mini.program.common.utils.BaseResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/7/15 16:50
 * @Version: 1.0
 * @Description: 异常处理
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private static Logger logger = Logger.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler({NoLoginException.class})
	@ResponseStatus(HttpStatus.OK)
	public BaseResponse noLoginException(NoLoginException exception) {
		logger.info(exception.getMessage());
		return BaseResponseUtil.getBaseResponse("0003", "未登录，请登录", null);
	}

}

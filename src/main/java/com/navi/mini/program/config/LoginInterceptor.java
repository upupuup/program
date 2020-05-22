package com.navi.mini.program.config;

import com.navi.mini.program.common.exception.NoLoginException;
import com.navi.mini.program.common.utils.SessionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/12/5 15:01
 * @Version: 1.0
 * @Description: 拦截未登录
 */
@RestController
public class LoginInterceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (SessionUtils.getCurrentUser() == null) {
			throw new NoLoginException("未登录，请登录");
			// return false;
		}
		return true;
	}
}

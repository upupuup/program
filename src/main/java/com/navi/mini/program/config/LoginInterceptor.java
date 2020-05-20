package com.navi.mini.program.config;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/12/5 15:01
 * @Version: 1.0
 * @Description: [java类作用描述]
 */
@RestController
public class LoginInterceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		if (SessionUtils.getCurrentUser() == null) {
//			logger.info("未登录，请登录");
//			return false;
//		}
		return true;
	}
}

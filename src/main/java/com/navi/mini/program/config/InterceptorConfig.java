package com.navi.mini.program.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2019/12/5 14:58
 * @Version: 1.0
 * @Description: [java类作用描述]
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Bean
	public LoginInterceptor getPayInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getPayInterceptor()).addPathPatterns("/**").excludePathPatterns("/bisUser/getToken/**", "/bisUser/queryByToken",
				"/bisUser/register");
	}
}

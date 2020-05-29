package com.navi.mini.program.config;

import com.navi.mini.program.common.constant.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2020/04/10/ 16:26
 * @Version: 1.0
 * @Description:
 */
@Component
public class SolveWeChatInfo implements CommandLineRunner {

	@Value("${Wechat.app-id}")
	private String appId;
	@Value("${Wechat.app-secret}")
	private String appSecret;

	@PostConstruct
	public void transValues() {
		Constant.APP_ID = this.appId;
		Constant.SECRET = this.appSecret;
	}

	/**
	 * 将微信的基本信息配置到WxConfig类里
	 * @author: jiangzhihong
	 * @date: 2020/04/10/ 16:49
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		 this.transValues();
	}
}

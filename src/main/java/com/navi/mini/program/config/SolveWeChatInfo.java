package com.navi.mini.program.config;

import com.navi.mini.program.common.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: jiangzhihong
 * @CreateDate: 2020/04/10/ 16:26
 * @Version: 1.0
 * @Description: 项目启动时清除redis数据
 */
@Component
public class SolveWeChatInfo implements CommandLineRunner {
//	@Autowired
//	private RedisUtils redisUtils;

	@Value("${wechat.we-chat-access-token}")
	private String weChatAccessToken;
	@Value("${wechat.ticket-token}")
	private String ticketToken;
	@Value("${wechat.app-id}")
	private String appId;
	@Value("${wechat.app-secret}")
	private String appSecret;
//	@Value("${wechat.domain-name}")
//	private String domainName;
//	@Value("${wechat.send-url}")
//	private String sendUrl;

	@PostConstruct
	public void transValues() {
		Constant.WE_CHAT_ACCESS_TOKEN = this.weChatAccessToken;
		Constant.TICKET_TOKEN = this.ticketToken;
		Constant.APP_ID = this.appId;
		Constant.SECRET = this.appSecret;
//		WxConfig.DOMAIN_NAME = this.domainName;
//		WxConfig.SEND_URL = this.sendUrl;
	}

	/**
	 * 项目启动时清除redis数据和将微信的基本信息配置到WxConfig类里
	 * @author: jiangzhihong
	 * @date: 2020/04/10/ 16:49
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
//		redisUtils.del(weChatAccessToken);
//		redisUtils.del(ticketToken);
		this.transValues();
	}
}

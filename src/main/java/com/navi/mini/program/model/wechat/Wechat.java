package com.navi.mini.program.model.wechat;

import lombok.Data;

/**
 * 接受微信端的三个参数
 */
@Data
public class Wechat {
	private String iv;
	private String sessionKey;
	private String encryptedData;
}

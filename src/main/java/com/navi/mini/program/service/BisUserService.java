package com.navi.mini.program.service;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.bisuser.BisUser;

public interface BisUserService extends BaseService<BisUser> {
	void saveBisUser(BisUser bisUser) throws Exception;

	/**
	 * 使用opendis查询用户信息
	 * @param token 小程序openid（必须）
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/12 21:53
	 */
	BisUser queryByToken(String token) throws Exception;

	/**
	 * 获取token
	 * @param code 小程序传来的code（必须）
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/12 22:22
	 */
	String getToken(String code) throws Exception;
}
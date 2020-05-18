package com.navi.mini.program.service;

import com.alibaba.fastjson.JSONObject;
import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.bisuser.BisUser;

public interface BisUserService extends BaseService<BisUser> {
	/**
	 * 保存用户
	 * @param bisUser
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 9:48
	 */
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
	JSONObject getToken(String code) throws Exception;

	/**
	 * 登录
	 * @param bisUser 用户实体类
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 10:05
	 */
	void login(BisUser bisUser) throws Exception;

	/**
	 * 注册
	 * @param bisUser 用户实体类
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 10:13
	 */
	void register(BisUser bisUser) throws Exception;
}
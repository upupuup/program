package com.navi.mini.program.dao.bisuser;


import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.bisuser.BisUser;

import java.util.List;

public interface BisUserDao extends BaseDao<BisUser> {
	/**
	 * 使用opendis查询用户信息
	 * @param token 小程序openid（必须）
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/12 21:53
	 */
	BisUser queryByToken(String token, String validFlg) throws Exception;

	/**
	 * 使用手机号查询用户
	 * @param usrPhs
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 14:32
	 */
	List<BisUser> queryByPhone(String usrPhs, String validFlg) throws Exception;
}
package com.navi.mini.program.service.retlineup;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retlineup.RetLineUp;

import java.util.List;

public interface RetLineUpService extends BaseService<RetLineUp> {
	void saveRetLineUp(RetLineUp retLineUp) throws Exception;

	/**
	 * 查询送果人的排号信息
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 13:03
	 */
	RetLineUp queryByUserIdAndDate() throws Exception;

	/**
	 * 使用码头和日期查询
	 * @param eqptNo 码头
	 * @param qDate 日期
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 16:35
	 */
	List<RetLineUp> queryByEqptNoAndDate(String eqptNo, String qDate) throws Exception;
}
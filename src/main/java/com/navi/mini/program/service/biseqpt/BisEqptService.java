package com.navi.mini.program.service.biseqpt;


import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.common.SelectModel;

import java.util.List;

public interface BisEqptService extends BaseService<BisEqpt> {
	void saveBisEqpt(BisEqpt bisEqpt) throws Exception;

	/**
	 * 使用主键查询
	 * @param eqptId
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 12:57
	 */
	BisEqpt queryByEqptId(String eqptId) throws Exception;

	/**
	 * 查询所有的码头
	 * @param bisEqpt 码头对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 14:57
	 */
	List<SelectModel> queryAllDropList(BisEqpt bisEqpt) throws Exception;

	/**
	 * 查询所有的码头
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 15:48
	 */
	List<BisEqpt> queryAllList() throws Exception;
}
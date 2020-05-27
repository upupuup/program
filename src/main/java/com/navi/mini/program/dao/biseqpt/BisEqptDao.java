package com.navi.mini.program.dao.biseqpt;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.biseqpt.BisEqpt;

import java.util.List;

public interface BisEqptDao extends BaseDao<BisEqpt> {

	/**
	 * 使用主键查询
	 * @param eqptId 设备主键
	 * @param enable 是否启用，0：否，1：是
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 12:57
	 */
	BisEqpt queryByEqptId(String eqptId, Integer enable) throws Exception;

	/**
	 * 查询所有的码头
	 * @param enable 是否弃用
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 15:50
	 */
	List<BisEqpt> queryAllList(Integer enable) throws Exception;
}
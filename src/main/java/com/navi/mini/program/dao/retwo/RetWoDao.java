package com.navi.mini.program.dao.retwo;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retwo.RetWo;

import java.util.List;

public interface RetWoDao extends BaseDao<RetWo> {

	/**
	 * 查询更换码头待审批
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 15:38
	 */
	List<RetWo> queryChangeWharfApproveList(RetWo retWo) throws Exception;

	/**
	 * 根据id查询料单
	 * @param id
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 19:59
	 */
	RetWo queryById(String id) throws Exception;
}
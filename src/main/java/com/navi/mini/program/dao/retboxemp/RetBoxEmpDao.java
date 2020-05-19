package com.navi.mini.program.dao.retboxemp;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retboxemp.RetBoxEmp;

import java.util.List;

/**
 * 空箱子的dao
 */
public interface RetBoxEmpDao extends BaseDao<RetBoxEmp> {
	/**
	 * 使用申请人主键查询空箱子
	 * @param reqUserId 申请人主键
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/18 21:22
	 */
	List<RetBoxEmp> queryRetBoxEmpByUserId(String reqUserId) throws Exception;
}
package com.navi.mini.program.service.retboxemp;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retboxemp.RetBoxEmp;

import java.util.List;

public interface RetBoxEmpService extends BaseService<RetBoxEmp> {
	void saveRetBoxEmp(RetBoxEmp retBoxEmp) throws Exception;

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
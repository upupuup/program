package com.navi.mini.program.dao.retboxempno;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retboxempno.RetBoxEmpNo;

public interface RetBoxEmpNoDao extends BaseDao<RetBoxEmpNo> {

	/**
	 * 使用主键查询
	 * @param retBoxEmpNo 空箱单据对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 23:49
	 */
	RetBoxEmpNo queryByRetBoxEmpNo(String retBoxEmpNo) throws Exception;
}
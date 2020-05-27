package com.navi.mini.program.dao.retcurrentno;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retcurrentno.RetCurrentNo;

import java.util.List;

public interface RetCurrentNoDao extends BaseDao<RetCurrentNo> {

	/**
	 * 使用码头主键和今天日期查询
	 * @param eqptNo 码头主键
	 * @param currentDate 今天日期
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 16:08
	 */
	List<RetCurrentNo> queryByEqptNoAndDate(String eqptNo, String currentDate) throws Exception;
}
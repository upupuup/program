package com.navi.mini.program.service.retcurrentno;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retcurrentno.RetCurrentNo;

import java.util.List;

public interface RetCurrentNoService extends BaseService<RetCurrentNo> {
	void saveRetCurrentNo(RetCurrentNo retCurrentNo) throws Exception;

	/**
	 * 查询所有的看板信息
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 15:47
	 */
	List<RetCurrentNo> queryAllList() throws Exception;

	/**
	 * 使用码头和日期查询
	 * @param eqptId 码头主键
	 * @param today 日期
	 * @return
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/28 10:36
	 */
	List<RetCurrentNo> queryByEquipAndTodayDate(String eqptId, String today) throws Exception;
}
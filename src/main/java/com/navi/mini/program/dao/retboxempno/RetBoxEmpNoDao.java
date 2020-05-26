package com.navi.mini.program.dao.retboxempno;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retboxempno.RetBoxEmpNo;

import java.util.List;

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

	/**
	 * 查询是否有未领取的空箱
	 * @param reqUserId 申请人
	 * @param isGet 是否领取
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/26 11:05
	 */
	List<RetBoxEmpNo> queryHasRecordAndNotGet(String reqUserId, String isGet) throws Exception;

}
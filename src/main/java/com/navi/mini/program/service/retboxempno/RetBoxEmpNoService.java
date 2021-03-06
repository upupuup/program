package com.navi.mini.program.service.retboxempno;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retboxempno.RetBoxEmpNo;

import java.util.List;

public interface RetBoxEmpNoService extends BaseService<RetBoxEmpNo> {
	void saveRetBoxEmpNo(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 领框记录
	 * @param retBoxEmpNo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 22:48
	 */
	PageInfo<RetBoxEmpNo> queryBoxRecordList(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 使用主键查询
	 * @param retBoxEmpNo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 23:49
	 */
	RetBoxEmpNo queryByRetBoxEmpNo(String retBoxEmpNo) throws Exception;

	/**
	 * 审批框
	 * @param retBoxEmpNo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 0:07
	 */
	void getBoxApprove(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 领框审批记录
	 * @param retBoxEmpNo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 0:26
	 */
	PageInfo<RetBoxEmpNo> queryBoxApproveList(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 领框审批记录（码头巡检员）
	 * @param retBoxEmpNo
	 * @return
	 * @throws Exception
	 */
	PageInfo<RetBoxEmpNo> queryBoxRecordHisList(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 查询是否有未领取的空箱
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/26 11:05
	 */
	List<RetBoxEmpNo> queryHasRecordAndNotGet() throws Exception;

	/**
	 * 确认领框
	 * @param retBoxEmpNo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/27 10:09
	 */
	void getBoxConfig(RetBoxEmpNo retBoxEmpNo) throws Exception;

	/**
	 * 查询是否有未领取的并且通过的空箱
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/28 13:58
	 */
	RetBoxEmpNo queryHasRecordAndNotGetPass() throws Exception;
}
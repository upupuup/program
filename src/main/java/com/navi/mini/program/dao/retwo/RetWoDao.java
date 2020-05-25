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

	/**
	 * 根据时间查询最近的一条记录
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 1:53
	 */
	List<RetWo> queryBySendUsrId(String currentUserId) throws Exception;


	/**
	 * 查询不是该状态的数据(送果人）
	 * @param status
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 18:50
	 */
	List<RetWo> queryBySendUserIdAndNotStatus(String currentUserId, String status) throws Exception;

	/**
	 * 查询果农最近的料单
	 * @param currentUserId
	 * @param dataSeqId
	 * @return
	 * @throws Exception
	 */
	List<RetWo> queryRetBoxOrderByRecentTime(String currentUserId, String dataSeqId) throws Exception;

	/**
	 * 使用单号查询
	 * @param woNo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/24 13:12
	 */
	List<RetWo> queryByWoNo(String woNo) throws Exception;

	/**
	 * 使用单号和审批状态查询
	 * @param woNo 单号
	 * @param approvalStatus 审批状态
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/24 13:14
	 */
	List<RetWo> queryByWoNoAndNotApprove(String woNo, String approvalStatus) throws Exception;

	/**
	 * 送果历史
	 * @param retWo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/25 12:40
	 */
	List<RetWo> querySendFruitList(RetWo retWo) throws Exception;
}
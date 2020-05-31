package com.navi.mini.program.service.retwo;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retwo.RetWo;

import java.util.List;

public interface RetWoService extends BaseService<RetWo> {
	void saveRetWo(RetWo retWo) throws Exception;

	/**
	 * 查询更换码头待审批
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 15:28
	 */
	PageInfo<RetWo> queryChangeWharfApproveList(RetWo retWo) throws Exception;

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
	 * 审批跟换码头
	 * @param retWo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/21 21:41
	 */
	void changeWharfApprove(RetWo retWo) throws Exception;

	/**
	 * 查询更换码头记录
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 19:53
	 */
	PageInfo<RetWo> queryChangeWharfList(RetWo retWo) throws Exception;

	/**
	 * 送果历史
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 19:53
	 */
	PageInfo<RetWo> querySendFruitList(RetWo retWo) throws Exception;

	/**
	 * 送果人变更码头
	 * @param retWo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 1:44
	 */
	void changeWharf(RetWo retWo) throws Exception;

	/**
	 * 根据时间查询最近的一条记录
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 1:53
	 */
	RetWo queryRetBoxOrderByRecentTime() throws Exception;

	/**
	 * 查询不是该状态的数据
	 * @param status
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 18:50
	 */
	List<RetWo> queryByNotStatus(String status) throws Exception;

	/**
	 * 查询不是结束状态的数据
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 18:50
	 */
	List<RetWo> queryByNotEndStatus() throws Exception;

	/**
	 * 质检
	 * @param retWo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 19:55
	 */
	void inspection(RetWo retWo) throws Exception;

	/**
	 * 查询是否可以更换码头
	 * @param woNo 单号
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/24 12:56
	 */
	Boolean queryCanChangeWharf(String woNo) throws Exception;

	/**
	 * 开始投料
	 * @param retWo 料单对象
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/29 8:40
	 */
	void startFeeding(RetWo retWo) throws Exception;

	/**
	 * 结束投料
	 * @param retWo
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/31 13:50
	 */
	void endFeeding(RetWo retWo) throws Exception;
}
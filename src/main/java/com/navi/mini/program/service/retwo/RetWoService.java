package com.navi.mini.program.service.retwo;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.retwo.RetWo;

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
}
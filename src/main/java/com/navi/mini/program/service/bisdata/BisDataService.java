package com.navi.mini.program.service.bisdata;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.common.SelectModel;

import java.util.List;

public interface BisDataService extends BaseService<BisData> {
	void saveBisData(BisData bisData) throws Exception;

	/**
	 *	使用主键查询信息
	 * @param dataSeqId
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 14:12
	 */
	BisData queryByDataSeqId(String dataSeqId) throws Exception;

	/**
	 * 使用dataCate和dataExt查询
	 * @param dataCate
	 * @param dataExt
	 * @return
	 * @throws Exception
	 */
	List<BisData> queryByCateAndExt(String dataCate, String dataExt) throws Exception;

	/**
	 * 使用dataCate查询
	 * @param dataCate
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 19:05
	 */
	List<BisData> queryByCate(String dataCate) throws Exception ;

	/**
	 * 查询字典里的数据（下拉框用）
	 * @param dataCate
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 19:33
	 */
	List<SelectModel> queryAllDropList(String dataCate) throws Exception;
}
package com.navi.mini.program.dao.bisdata;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.bisdata.BisData;

import java.util.List;

public interface BisDataDao extends BaseDao<BisData> {

	/**
	 * 使用主键查询
	 * @param dataSeqId
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/22 14:13
	 */
	BisData queryByDataSeqId(String dataSeqId) throws Exception;

	/**
	 * 使用dataCate和dataExt查询
	 * @param dataCate
	 * @param dataExt
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 19:05
	 */
	List<BisData> queryByCateAndExt(String dataCate, String dataExt) throws Exception;

	/**
	 * 使用dataCate和dataExt查询
	 * @param dataCate
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 19:05
	 */
	List<BisData> queryByCate(String dataCate) throws Exception;
}
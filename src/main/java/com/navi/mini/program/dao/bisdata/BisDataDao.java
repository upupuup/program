package com.navi.mini.program.dao.bisdata;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.bisdata.BisData;

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
}
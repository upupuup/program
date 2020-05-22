package com.navi.mini.program.service.bisdata;

import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.bisdata.BisData;

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
}
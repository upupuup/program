package com.navi.mini.program.service.hisretwo;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.service.BaseService;
import com.navi.mini.program.model.hisretwo.HisRetWo;

public interface HisRetWoService extends BaseService<HisRetWo> {
	void saveHisRetWo(HisRetWo hisRetWo) throws Exception;

	/**
	 * 根据质检员查询记录
	 * @param hisRetWo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/23 8:30
	 */
	PageInfo<HisRetWo> queryByInspectionPerson(HisRetWo hisRetWo) throws Exception;
}
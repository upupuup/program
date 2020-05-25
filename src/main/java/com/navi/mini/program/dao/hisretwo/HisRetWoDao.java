package com.navi.mini.program.dao.hisretwo;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.hisretwo.HisRetWo;

public interface HisRetWoDao extends BaseDao<HisRetWo> {

	/**
	 * 使用主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/25 13:45
	 */
	HisRetWo queryById(String id) throws Exception;
}
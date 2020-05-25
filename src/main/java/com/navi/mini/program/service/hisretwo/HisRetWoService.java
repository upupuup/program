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

	/**
	 * 更换码头记录（送果人）
	 * @param hisRetWo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/25 10:27
	 */
	PageInfo<HisRetWo> queryChangeWharf(HisRetWo hisRetWo) throws Exception;

	/**
	 * 更换码头记录（码头巡视员）
	 * @param hisRetWo
	 * @return
	 * @throws Exception
	 * @Author: jiangzhihong
	 * @CreateDate: 2020/5/25 13:35
	 */
	PageInfo<HisRetWo> queryChangeWharfHis(HisRetWo hisRetWo) throws Exception;

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
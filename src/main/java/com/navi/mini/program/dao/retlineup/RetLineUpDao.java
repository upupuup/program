package com.navi.mini.program.dao.retlineup;

import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.model.retlineup.RetLineUp;

import java.util.List;

public interface RetLineUpDao extends BaseDao<RetLineUp> {

	/**
	 * 使用用户主键和日期查询送果人排号信息
	 * @param usrId
	 * @param qdate
	 * @return
	 * @throws Exception
	 */
	List<RetLineUp> queryByUserIdAndDate(String usrId, String qDate) throws Exception;

	/**
	 * 使用码头和日期查询
	 * @param eqptNo
	 * @param qDate
	 * @return
	 * @throws Exception
	 */
	List<RetLineUp> queryByEqptNoAndDate(String eqptNo, String qDate) throws Exception;
}
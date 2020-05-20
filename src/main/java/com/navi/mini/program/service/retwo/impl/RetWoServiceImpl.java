package com.navi.mini.program.service.retwo.impl;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.retwo.RetWoDao;
import com.navi.mini.program.model.retwo.RetWo;
import com.navi.mini.program.service.retwo.RetWoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetWoServiceImpl extends BaseServiceImpl<RetWo, RetWoDao> implements RetWoService {
	
	@Override
    public void saveRetWo(RetWo retWo) throws Exception{
		this.insert(retWo);
    }

	/**
	 * 分页查询数据
	 * @param retWo 料单对象
	 * @return
	 * @throws Exception
	 */
    @Override
	public PageInfo<RetWo> queryList(RetWo retWo) throws Exception {
		EmptyUtils.isEmpty("用户主键", retWo.getSendUsrId());
		PageInfo<RetWo> retWoPageInfo = super.queryList(retWo);
		List<RetWo> list = retWoPageInfo.getList();
//		if (!CollectionUtils.isEmpty(list)) {
//			for (RetWo retWoItem : list) {
//				if () {
//
//				}
//				retWoItem.setStartBoxTimestamp();
//			}
//		}
		return retWoPageInfo;
	}
}
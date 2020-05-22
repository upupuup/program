package com.navi.mini.program.service.bisdata.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.bisdata.BisDataDao;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.service.bisdata.BisDataService;
import org.springframework.stereotype.Service;

@Service
public class BisDataServiceImpl extends BaseServiceImpl<BisData, BisDataDao> implements BisDataService {
	
	@Override
    public void saveBisData(BisData bisData) throws Exception{

    }

    /**
     * 使用主键查询信息
     * @param dataSeqId
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 14:12
     */
    @Override
    public BisData queryByDataSeqId(String dataSeqId) throws Exception {
        EmptyUtils.isEmpty("主键", dataSeqId);
        return this.dao.queryByDataSeqId(dataSeqId);
    }
}
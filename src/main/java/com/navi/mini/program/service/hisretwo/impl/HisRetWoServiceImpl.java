package com.navi.mini.program.service.hisretwo.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.UUIDUtils;
import com.navi.mini.program.dao.hisretwo.HisRetWoDao;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.service.hisretwo.HisRetWoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HisRetWoServiceImpl extends BaseServiceImpl<HisRetWo, HisRetWoDao> implements HisRetWoService {

    @Transactional(rollbackFor = Exception.class)
	@Override
    public void saveHisRetWo(HisRetWo hisRetWo) throws Exception{
        hisRetWo.setId(UUIDUtils.generatePrimaryKey());
        this.insert(hisRetWo);
    }
}
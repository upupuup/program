package com.navi.mini.program.service.hisretwo.impl;

import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.UUIDUtils;
import com.navi.mini.program.dao.hisretwo.HisRetWoDao;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.service.hisretwo.HisRetWoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HisRetWoServiceImpl extends BaseServiceImpl<HisRetWo, HisRetWoDao> implements HisRetWoService {

    /**
     * 保存信息
     * @param hisRetWo 料单历史对象
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
	@Override
    public void saveHisRetWo(HisRetWo hisRetWo) throws Exception{
        hisRetWo.setId(UUIDUtils.generatePrimaryKey());
        Integer addType = hisRetWo.getAddType();
        // 添加方式为空，那么就直接设置正常添加即可
        if (addType == null) {
            hisRetWo.setAddType(Constant.RetWork.ADD_TYPE_NORMAL);
        }
        this.insert(hisRetWo);
    }
}
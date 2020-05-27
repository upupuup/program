package com.navi.mini.program.service.retlineup.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.DateUtils;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.common.utils.SessionUtils;
import com.navi.mini.program.dao.retlineup.RetLineUpDao;
import com.navi.mini.program.model.retlineup.RetLineUp;
import com.navi.mini.program.service.retlineup.RetLineUpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RetLineUpServiceImpl extends BaseServiceImpl<RetLineUp, RetLineUpDao> implements RetLineUpService {

    @Transactional(rollbackFor = Exception.class)
	@Override
    public void saveRetLineUp(RetLineUp retLineUp) throws Exception{

    }

    /**
     * 查询送果人的排号信息
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/27 13:03
     */
    @Override
    public RetLineUp queryByUserIdAndDate() throws Exception {
        // 使用用户主键和日期查询送果人排号信息
        List<RetLineUp> retLineUpList = this.dao.queryByUserIdAndDate(SessionUtils.getCurrentUserId(), DateUtils.getDefaultSys(DateUtils.FORMAT_YYMMDD));
        if (CollectionUtils.isEmpty(retLineUpList)) {
            return null;
        }
        return retLineUpList.get(0);
    }

    /**
     * 使用码头和日期查询
     * @param eqptNo 码头
     * @param qDate  日期
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/27 16:35
     */
    @Override
    public List<RetLineUp> queryByEqptNoAndDate(String eqptNo, String qDate) throws Exception {
        EmptyUtils.isEmpty("码头", eqptNo);
        EmptyUtils.isEmpty("日期", qDate);
        return this.dao.queryByEqptNoAndDate(eqptNo, qDate);
    }
}
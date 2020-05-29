package com.navi.mini.program.service.retcurrentno.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.DateUtils;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.retcurrentno.RetCurrentNoDao;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.retcurrentno.RetCurrentNo;
import com.navi.mini.program.model.retlineup.RetLineUp;
import com.navi.mini.program.service.biseqpt.BisEqptService;
import com.navi.mini.program.service.retcurrentno.RetCurrentNoService;
import com.navi.mini.program.service.retlineup.RetLineUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RetCurrentNoServiceImpl extends BaseServiceImpl<RetCurrentNo, RetCurrentNoDao> implements RetCurrentNoService {
    @Autowired
    private BisEqptService bisEqptService;
	@Autowired
    private RetLineUpService retLineUpService;

	@Override
    public void saveRetCurrentNo(RetCurrentNo retCurrentNo) throws Exception{

    }

    /**
     * 查询所有的看板信息
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/27 15:47
     */
    @Override
    public List<RetCurrentNo> queryAllList() throws Exception {
        // 查询所有的码头
        List<BisEqpt> bisEqptList = bisEqptService.queryAllList();
        if (CollectionUtils.isEmpty(bisEqptList)) {
            return Collections.emptyList();
        }

        List<RetCurrentNo> resultList = new ArrayList<>();
        // 根据码头主键查询
        for (BisEqpt bisEqpt : bisEqptList) {
            String eqptId = bisEqpt.getEqptId();
            // 使用码头和日期查询
            List<RetCurrentNo> retCurrentNoList = this.dao.queryByEqptNoAndDate(eqptId, DateUtils.getDefaultSys(DateUtils.FORMAT_YYMMDD));
            if (CollectionUtils.isEmpty(retCurrentNoList)) {
                continue;
            }
            RetCurrentNo retCurrentNo = retCurrentNoList.get(0);
            retCurrentNo.setEqptName(bisEqpt.getEqptName());

            // 查询等待人数
            List<RetLineUp> retLineUpList = retLineUpService.queryByEqptNoAndDate(eqptId, DateUtils.getDefaultSys(DateUtils.FORMAT_YYMMDD));
            retCurrentNo.setWaitNo(retLineUpList.size() - retCurrentNo.getCurNo());
            resultList.add(retCurrentNo);

        }
        return resultList;
    }

    /**
     * 使用码头和日期查询
     * @param eqptId 码头主键
     * @param today  日期
     * @return
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/28 10:36
     */
    @Override
    public List<RetCurrentNo> queryByEquipAndTodayDate(String eqptId, String today) throws Exception {
        EmptyUtils.isEmpty("码头主键", eqptId);
        EmptyUtils.isEmpty("日期", today);
        return this.dao.queryByEqptNoAndDate(eqptId, today);
    }
}
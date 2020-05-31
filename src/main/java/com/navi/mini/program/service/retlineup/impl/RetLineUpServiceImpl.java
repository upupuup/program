package com.navi.mini.program.service.retlineup.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.DateUtils;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.common.utils.SessionUtils;
import com.navi.mini.program.dao.retlineup.RetLineUpDao;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.retcurrentno.RetCurrentNo;
import com.navi.mini.program.model.retlineup.RetLineUp;
import com.navi.mini.program.service.biseqpt.BisEqptService;
import com.navi.mini.program.service.retcurrentno.RetCurrentNoService;
import com.navi.mini.program.service.retlineup.RetLineUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RetLineUpServiceImpl extends BaseServiceImpl<RetLineUp, RetLineUpDao> implements RetLineUpService {
    @Autowired
    private BisEqptService bisEqptService;
    @Autowired
    private RetCurrentNoService retCurrentNoService;

    @Transactional(rollbackFor = Exception.class)
	@Override
    public void saveRetLineUp(RetLineUp retLineUp) throws Exception{
        String eqptNo = retLineUp.getEqptNo();
        EmptyUtils.isEmpty("码头", eqptNo);
        BisEqpt bisEqpt = bisEqptService.queryByEqptId(eqptNo);
        EmptyUtils.isEmpty("码头", bisEqpt);
        String today = DateUtils.getDefaultSys(DateUtils.FORMAT_YYMMDD);

        List<RetLineUp> userRetLineUpList = this.dao.queryByEqptNoAndDateAndUserId(eqptNo, today, SessionUtils.getCurrentUserId());

        // 使用码头和日期查询
        List<RetLineUp> retLineUpList = this.queryByEqptNoAndDate(eqptNo, today);
        int size = retLineUpList.size();
        // 使用码头和日期查询总表
        List<RetCurrentNo> retCurrentNoList = retCurrentNoService.queryByEquipAndTodayDate(eqptNo, today);

        // 为空,说明是新增
        if (CollectionUtils.isEmpty(userRetLineUpList)) {
            // 设置号码
            retLineUp.setQNo(size + 1);
            // 如果为空,新增一条数据
            if (CollectionUtils.isEmpty(retCurrentNoList)) {
                RetCurrentNo retCurrentNo = new RetCurrentNo();
                // 默认新建的时候,当前排号为1
                retCurrentNo.setCurNo(1);
                retCurrentNo.setEqptNo(eqptNo);
                retCurrentNo.setTodayDate(today);
                retCurrentNo.setEvtDatatime(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));
                retCurrentNoService.saveRetCurrentNo(retCurrentNo);
                retLineUp.setWaitNo(retLineUp.getQNo() - 1);
            } else {
                retLineUp.setWaitNo(retLineUp.getQNo() - retCurrentNoList.get(0).getCurNo());
            }

            retLineUp.setQDate(today);
            retLineUp.setUsrId(SessionUtils.getCurrentUserId());
            retLineUp.setQStatus("0");
            retLineUp.setWaitTime(10);
            retLineUp.setEvtUsa(SessionUtils.getCurrentUserId());
            retLineUp.setEvtDatatime(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));

            this.insert(retLineUp);

        } else {
            if (CollectionUtils.isEmpty(retCurrentNoList)) {
                throw new Exception("看板信息错误");
            }
            RetCurrentNo retCurrentNo = retCurrentNoList.get(0);
            // 当前叫号加一
            retCurrentNo.setCurNo( + 1);
            retCurrentNo.setEvtDatatime(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));
            retCurrentNoService.saveRetCurrentNo(retCurrentNo);

            // 修改从表的状态,操作人和操作时间
            RetLineUp lineUp = userRetLineUpList.get(0);
            lineUp.setQStatus("1");
            lineUp.setEvtUsa(SessionUtils.getCurrentUserId());
            lineUp.setEvtDatatime(DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS));
            this.update(retLineUp);
        }
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
        String today = DateUtils.getDefaultSys(DateUtils.FORMAT_YYMMDD);
        // 使用用户主键和日期查询送果人排号信息
        List<RetLineUp> retLineUpList = this.dao.queryByUserIdAndDate(SessionUtils.getCurrentUserId(), today);
        if (CollectionUtils.isEmpty(retLineUpList)) {
            return null;
        }
        RetLineUp retLineUp = retLineUpList.get(0);
        // 查询码头信息
        BisEqpt bisEqpt = bisEqptService.queryByEqptId(retLineUp.getEqptNo());
        if (bisEqpt != null) {
            retLineUp.setEqptName(bisEqpt.getEqptName());
        }

        // 查询当前等待人数
        List<RetCurrentNo> retCurrentNoList = retCurrentNoService.queryByEquipAndTodayDate(bisEqpt.getEqptId(), today);
        if (CollectionUtils.isEmpty(retCurrentNoList)) {
            throw new Exception("没有改码头信息");
        }
        Integer waitNo = retCurrentNoList.get(0).getCurNo();
        // 设置等待人数
        waitNo = retLineUp.getQNo() - waitNo;
        // 如果排号小于0，那么设置为0
        waitNo = waitNo < 0 ? 0 : waitNo;
        retLineUp.setWaitNo(waitNo);
        return retLineUp;
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
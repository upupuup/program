package com.navi.mini.program.service.retboxempno.impl;


import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.*;
import com.navi.mini.program.dao.retboxempno.RetBoxEmpNoDao;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.model.retboxempno.RetBoxEmpNo;
import com.navi.mini.program.service.bisdata.BisDataService;
import com.navi.mini.program.service.bisuser.BisUserService;
import com.navi.mini.program.service.retboxempno.RetBoxEmpNoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetBoxEmpNoServiceImpl extends BaseServiceImpl<RetBoxEmpNo, RetBoxEmpNoDao> implements RetBoxEmpNoService {
    @Autowired
    private BisUserService bisUserService;
    @Autowired
    private BisDataService bisDataService;
	
	@Override
    public void saveRetBoxEmpNo(RetBoxEmpNo retBoxEmpNo) throws Exception{
        String retBoxEmp = retBoxEmpNo.getRetBoxEmpNo();
        if(StringUtils.isBlank(retBoxEmp)){
            // 校验字段
            Integer palletNum = retBoxEmpNo.getPalletNum();
            EmptyUtils.isEmpty("托数", palletNum);

            // 查询托数
            Integer queryPalletNum = bisDataService.queryPallet();
            // 比较托数
            if (palletNum > queryPalletNum) {
                throw new Exception("托数不能大于" + queryPalletNum + "托");
            }

            // 查询箱数
            Integer queryBoxNum = bisDataService.queryBox();
            Integer boxNum = BeanUtils.solveTwoNumMultiply(queryBoxNum, palletNum);
            retBoxEmpNo.setBoxNum(boxNum);

            // 设置必要值
            retBoxEmpNo.setRetBoxEmpNo(UUIDUtils.generateRetWoEmptyNo());
            retBoxEmpNo.setReqUserId(SessionUtils.getCurrentUserId());
            retBoxEmpNo.setApprovalStatus(Constant.Approve.APPROVE_WAIT_STATUS);
            retBoxEmpNo.setEvtUsr(SessionUtils.getCurrentUserId());
            String time = DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS);
            retBoxEmpNo.setEvtTimestamp(time);
            retBoxEmpNo.setApplyTime(time);
            this.insert(retBoxEmpNo);
        }else{
            this.update(retBoxEmpNo);
        }

    }



    /**
     * 分页查询
     * @param retBoxEmpNo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/24 16:21
     */
    @Override
    public PageInfo<RetBoxEmpNo> queryList(RetBoxEmpNo retBoxEmpNo) throws Exception {
        PageInfo<RetBoxEmpNo> retBoxEmpNoPageInfo = super.queryList(retBoxEmpNo);
        List<RetBoxEmpNo> list = retBoxEmpNoPageInfo.getList();
        if (!CollectionUtils.isEmpty(list)) {
            Map<String, String> userMap = new HashMap<>(16);
            for (RetBoxEmpNo empNo : list) {
                this.solveSendUser(empNo, userMap);
            }
        }
        return retBoxEmpNoPageInfo;
    }

    /**
     * 领框记录
     * @param retBoxEmpNo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 22:48
     */
    @Override
    public PageInfo<RetBoxEmpNo> queryBoxRecordList(RetBoxEmpNo retBoxEmpNo) throws Exception {
        retBoxEmpNo.setReqUserId(SessionUtils.getCurrentUserId());
        PageInfo<RetBoxEmpNo> retBoxEmpNoPageInfo = this.queryList(retBoxEmpNo);
        return retBoxEmpNoPageInfo;
    }

    /**
     * 领框审批记录
     * @param retBoxEmpNo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 0:26
     */
    @Override
    public PageInfo<RetBoxEmpNo> queryBoxApproveList(RetBoxEmpNo retBoxEmpNo) throws Exception {
        retBoxEmpNo.setApprovalStatus(Constant.Approve.APPROVE_END_STATUS);
        retBoxEmpNo.setEvtUsr(SessionUtils.getCurrentUserId());
        PageInfo<RetBoxEmpNo> retBoxEmpNoPageInfo = this.queryList(retBoxEmpNo);
        return retBoxEmpNoPageInfo;
    }

    /**
     * 领框审批记录（码头巡检员）
     * @param retBoxEmpNo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 0:26
     */
    @Override
    public PageInfo<RetBoxEmpNo> queryBoxRecordHisList(RetBoxEmpNo retBoxEmpNo) throws Exception {
        retBoxEmpNo.setApprovalStatus(Constant.Approve.APPROVE_WAIT_STATUS);
        retBoxEmpNo.setEvtUsr(SessionUtils.getCurrentUserId());
        PageInfo<RetBoxEmpNo> retBoxEmpNoPageInfo = this.queryList(retBoxEmpNo);
        return retBoxEmpNoPageInfo;
    }

    /**
     * 使用主键查询
     * @param retBoxEmpNo 空箱单据对象
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 23:49
     */
    @Override
    public RetBoxEmpNo queryByRetBoxEmpNo(String retBoxEmpNo) throws Exception {
        EmptyUtils.isEmpty("主键", retBoxEmpNo);
        RetBoxEmpNo retBox = this.dao.queryByRetBoxEmpNo(retBoxEmpNo);
        if (retBox != null) {
            String reqUserId = retBox.getReqUserId();
            if (StringUtils.isBlank(reqUserId)) {
                return retBox;
            }
            // 查询用户信息
            BisUser bisUser = bisUserService.queryByUserId(reqUserId);
            if (bisUser != null) {
                retBox.setReqUsername(bisUser.getUsrName());
            }
        }
        return retBox;
    }

    /**
     * 处理申请人信息
     * @param empNo 料单
     * @param userMap 送果人map
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/21 14:27
     */
    private void solveSendUser(RetBoxEmpNo empNo, Map<String, String> userMap) throws Exception {
        // 获取用户主键
        String reqUserId = empNo.getReqUserId();
        // 判断是否为空
        if (!StringUtils.isBlank(reqUserId)) {
            // 判断用户信息是否已经存在map里
            if (userMap.containsKey(reqUserId)) {
                empNo.setReqUsername(userMap.get(reqUserId));
            } else {
                // 查询用户信息
                BisUser bisUser = bisUserService.queryByUserId(reqUserId);
                if (bisUser != null) {
                    empNo.setReqUsername(bisUser.getUsrName());
                    userMap.put(reqUserId, bisUser.getUsrName());
                }
            }

        }
    }

    /**
     * 处理状态信息
     * @param empNo 空箱单据对象
     * @param statusMap
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/21 14:27
     */
    private void solveStatus(RetBoxEmpNo empNo, Map<String, String> statusMap) throws Exception {
        // 获取用户主键
        String approvalStatus = empNo.getApprovalStatus();
        // 判断是否为空
        if (!StringUtils.isBlank(approvalStatus)) {
            // 判断用户信息是否已经存在map里
            if (statusMap.containsKey(approvalStatus)) {
                empNo.setReqUsername(statusMap.get(approvalStatus));
            } else {
                // 查询状态信息
                BisData status = bisDataService.queryByDataSeqId(approvalStatus);
                if (status != null) {
                    empNo.setApprovalStatusName(status.getDataDesc());
                    statusMap.put(approvalStatus, status.getDataDesc());
                }
            }

        }
    }

    /**
     * 审批框
     * @param retBoxEmpNo
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 0:07
     */
    @Override
    public void getBoxApprove(RetBoxEmpNo retBoxEmpNo) throws Exception {
        // 判空
        String retBoxEmp = retBoxEmpNo.getRetBoxEmpNo();
        EmptyUtils.isEmpty("主键", retBoxEmp);
        EmptyUtils.isEmpty("审批结果", retBoxEmpNo.getApprovalResults());
        EmptyUtils.isEmpty("审批意见", retBoxEmpNo.getApprovalComments());
        // 使用主键查询
        RetBoxEmpNo empNo = this.dao.queryByRetBoxEmpNo(retBoxEmp);
        EmptyUtils.isEmpty("使用主键查询的对象", empNo);

        // 设置值
        String time = DateUtils.getDefaultSys(DateUtils.FORMAT_YYYYMMDD24HHMMSS);
        retBoxEmpNo.setApprovalStatus(Constant.Approve.APPROVE_END_STATUS);
        retBoxEmpNo.setEvtTimestamp(time);
        retBoxEmpNo.setEvtUsr(SessionUtils.getCurrentUserId());
        retBoxEmpNo.setConUserId(SessionUtils.getCurrentUserId());
        retBoxEmpNo.setApplyTime(time);

        // 更新
        this.saveRetBoxEmpNo(retBoxEmpNo);
    }
}
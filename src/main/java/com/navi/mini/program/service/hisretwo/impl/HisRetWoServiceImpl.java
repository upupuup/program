package com.navi.mini.program.service.hisretwo.impl;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.common.utils.SessionUtils;
import com.navi.mini.program.common.utils.UUIDUtils;
import com.navi.mini.program.dao.hisretwo.HisRetWoDao;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.model.hisretwo.HisRetWo;
import com.navi.mini.program.service.bisdata.BisDataService;
import com.navi.mini.program.service.biseqpt.BisEqptService;
import com.navi.mini.program.service.bisuser.BisUserService;
import com.navi.mini.program.service.hisretwo.HisRetWoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HisRetWoServiceImpl extends BaseServiceImpl<HisRetWo, HisRetWoDao> implements HisRetWoService {

    @Autowired
    private BisUserService bisUserService;
    @Autowired
    private BisEqptService bisEqptService;
    @Autowired
    private BisDataService bisDataService;

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

    @Override
    public PageInfo<HisRetWo> queryList(HisRetWo hisRetWo) throws Exception {
        PageInfo<HisRetWo> hisRetWoPageInfo = super.queryList(hisRetWo);
        List<HisRetWo> list = hisRetWoPageInfo.getList();

        // 存放码头信息
        Map<String, String> wharfMap = new HashMap<>(64);
        Map<String, String> userMap = new HashMap<>(64);
        Map<String, String> orchardistMap = new HashMap<>(64);
        Map<String, String> gradeMap = new HashMap<>(64);
        Map<String, String> statusMap = new HashMap<>(64);
        // 如果不为空，那么设置送果人信息，码头信息
        if (!CollectionUtils.isEmpty(list)) {
            // 遍历所有的数据
            for (HisRetWo ret : list) {
                this.solveSendUser(ret, userMap);
                this.solveWharf(ret, wharfMap, Constant.RetWork.CURRENT_WHARF);
                this.solveWharf(ret, wharfMap, Constant.RetWork.CHANGE_WHARF);
                this.solveOrchardist(ret, orchardistMap);
                this.solveGrade(ret, gradeMap);
                this.solveStatus(ret, statusMap);
            }
        }
        return hisRetWoPageInfo;
    }

    /**
     * 处理状态信息
     * @param
     * @param statusMap
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/21 14:27
     */
    private void solveStatus(HisRetWo ret, Map<String, String> statusMap) throws Exception {
        // 获取用户主键
        String status = ret.getStatus();
        // 判断是否为空
        if (!StringUtils.isBlank(status)) {
            // 判断用户信息是否已经存在map里
            if (statusMap.containsKey(status)) {
                ret.setStatusName(statusMap.get(status));
            } else {
                // 查询状态信息
                BisData queryStatus = bisDataService.queryByDataSeqId(status);
                if (queryStatus != null) {
                    ret.setStatusName(queryStatus.getDataDesc());
                    statusMap.put(status, queryStatus.getDataDesc());
                }
            }

        }
    }

    /**
     * 处理等级
     * @param ret
     * @param gradeMap
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 20:25
     */
    private void solveGrade(HisRetWo ret, Map<String, String> gradeMap) throws Exception {
        // 获取字典表主键
        String grade = ret.getGrade();
        // 判断是否为空
        if (!StringUtils.isBlank(grade)) {
            // 判断等级信息是否已经存在map里
            if (gradeMap.containsKey(grade)) {
                ret.setGradeName(gradeMap.get(grade));
            } else {
                // 查询等级信息
                BisData bisData = bisDataService.queryByDataSeqId(grade);
                if (bisData != null) {
                    ret.setGradeName(bisData.getDataDesc());
                    gradeMap.put(grade, bisData.getDataDesc());
                }
            }

        }
    }

    /**
     * 处理果农
     * @param ret
     * @param orchardistMap
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 13:44
     */
    private void solveOrchardist(HisRetWo ret, Map<String, String> orchardistMap) throws Exception{
        // 获取字典表主键
        String orchardist = ret.getOrchardist();
        // 判断是否为空
        if (!StringUtils.isBlank(orchardist)) {
            // 判断用户信息是否已经存在map里
            if (orchardistMap.containsKey(orchardist)) {
                ret.setOrchardistName(orchardistMap.get(orchardist));
            } else {
                // 查询果农信息
                BisData bisData = bisDataService.queryByDataSeqId(orchardist);
                if (bisData != null) {
                    ret.setOrchardistName(bisData.getDataDesc());
                    orchardistMap.put(orchardist, bisData.getDataDesc());
                }
            }

        }
    }

    /**
     * 处理送果人信息
     * @param ret 料单
     * @param userMap 送果人map
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/21 14:27
     */
    private void solveSendUser(HisRetWo ret, Map<String, String> userMap) throws Exception {
        // 获取用户主键
        String sendUsrId = ret.getSendUsrId();
        // 判断是否为空
        if (!StringUtils.isBlank(sendUsrId)) {
            // 判断用户信息是否已经存在map里
            if (userMap.containsKey(sendUsrId)) {
                ret.setSendUserName(userMap.get(sendUsrId));
            } else {
                // 查询送果人信息
                BisUser bisUser = bisUserService.queryByUserId(sendUsrId);
                if (bisUser != null) {
                    ret.setSendUserName(bisUser.getUsrName());
                    userMap.put(sendUsrId, bisUser.getUsrName());
                }
            }

        }
    }

    /**
     * 设置码头信息
     * @param ret 料单
     * @param wharfMap 码头map
     * @param currentOrChangeWharf 当前码头还是申请更换的码头
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/21 14:26
     */
    private void solveWharf(HisRetWo ret, Map<String, String> wharfMap, String currentOrChangeWharf) throws Exception {
        String wharf = "";
        if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
            wharf = ret.getInWharf();
        } else {
            wharf = ret.getInWharfChanger();
        }

        // 判断是否为空
        if (!StringUtils.isBlank(wharf)) {
            // 判断码头信息是否已经存在map里
            if (wharfMap.containsKey(wharf)) {
                if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
                    ret.setInWharfName(wharfMap.get(wharf));
                } else {
                    ret.setInWharfChangerName(wharfMap.get(wharf));
                }
            } else {
                // 查询码头信息
                BisEqpt bisEqpt = bisEqptService.queryByEqptId(wharf);
                if (bisEqpt != null) {
                    // 设置当前码头和更换码头信息
                    String eqptName = bisEqpt.getEqptName();
                    if (Constant.RetWork.CURRENT_WHARF.equals(currentOrChangeWharf)) {
                        ret.setInWharfName(eqptName);
                    } else {
                        ret.setInWharfChangerName(eqptName);
                    }

                    wharfMap.put(wharf, eqptName);
                }
            }

        }
    }

    /**
     * 根据质检员查询记录
     * @param hisRetWo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 8:30
     */
    @Override
    public PageInfo<HisRetWo> queryByInspectionPerson(HisRetWo hisRetWo) throws Exception {
        hisRetWo.setEvtUsr(SessionUtils.getCurrentUserId());
        hisRetWo.setAddType(Constant.RetWork.ADD_TYPE_INSPECTION);
        return this.queryList(hisRetWo);
    }

    /**
     * 更换码头记录(送果人)
     * @param hisRetWo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/25 10:27
     */
    @Override
    public PageInfo<HisRetWo> queryChangeWharf(HisRetWo hisRetWo) throws Exception {
        hisRetWo.setSendUsrId(SessionUtils.getCurrentUserId());
        hisRetWo.setAddType(Constant.RetWork.ADD_TYPE_CHANGE_APPROVE);
        hisRetWo.setApprovalStatus(Constant.Approve.APPROVE_END_STATUS);
        return this.queryList(hisRetWo);
    }

    /**
     * 更换码头记录（码头巡视员）
     * @param hisRetWo
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/25 13:35
     */
    @Override
    public PageInfo<HisRetWo> queryChangeWharfHis(HisRetWo hisRetWo) throws Exception {
        hisRetWo.setEvtUsr(SessionUtils.getCurrentUserId());
        hisRetWo.setAddType(Constant.RetWork.ADD_TYPE_CHANGE_APPROVE);
        hisRetWo.setApprovalStatus(Constant.Approve.APPROVE_END_STATUS);
        return this.queryList(hisRetWo);
    }

    /**
     * 使用主键查询
     * @param id
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/25 13:45
     */
    @Override
    public HisRetWo queryById(String id) throws Exception {
        EmptyUtils.isEmpty("主键", id);
        HisRetWo hisRetWo = this.dao.queryById(id);
        if (hisRetWo == null) {
            return hisRetWo;
        }

        // 处理各种字段
        this.solveManyInfo(hisRetWo);
        return hisRetWo;
    }

    /**
     * 处理各种字段
     * @param retWo
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 2:01
     */
    private void solveManyInfo(HisRetWo retWo) throws Exception {
        if (retWo != null) {
            // 查询送果人信息
            BisUser bisUser = bisUserService.queryByUserId(retWo.getSendUsrId());
            if (bisUser != null) {
                retWo.setSendUserName(bisUser.getUsrName());
            }

            // 查询操作人信息
            bisUser = bisUserService.queryByUserId(retWo.getSendUsrId());
            if (bisUser != null) {
                retWo.setEvtUsrName(bisUser.getUsrName());
            }

            // 查询码头信息
            BisEqpt wharf = bisEqptService.queryByEqptId(retWo.getInWharf());
            if (wharf != null) {
                retWo.setInWharfName(wharf.getEqptName());
            }

            String inWharfChanger = retWo.getInWharfChanger();
            if (!StringUtils.isBlank(inWharfChanger)) {
                // 查询更换码头信息
                wharf = bisEqptService.queryByEqptId(retWo.getInWharfChanger());
                if (wharf != null) {
                    retWo.setInWharfChangerName(wharf.getEqptName());
                }
            }

            // 设置码头信息
            BisData orchardist = bisDataService.queryByDataSeqId(retWo.getOrchardist());
            if (orchardist != null) {
                retWo.setOrchardistName(orchardist.getDataDesc());
            }

            // 等级信息
            String grade = retWo.getGrade();
            BisData bisData = bisDataService.queryByDataSeqId(grade);
            if (bisData != null) {
                retWo.setGradeName(bisData.getDataDesc());
            }

        }
    }
}
package com.navi.mini.program.service.biseqpt.impl;

import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.biseqpt.BisEqptDao;
import com.navi.mini.program.model.biseqpt.BisEqpt;
import com.navi.mini.program.model.common.SelectModel;
import com.navi.mini.program.service.biseqpt.BisEqptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BisEqptServiceImpl extends BaseServiceImpl<BisEqpt, BisEqptDao> implements BisEqptService {
	
	@Override
    public void saveBisEqpt(BisEqpt bisEqpt) throws Exception{
        String id = bisEqpt.getEqptId();
        if(StringUtils.isBlank(id)){
            this.insert(bisEqpt);
        }else{
            this.update(bisEqpt);
        }

    }

    /**
     * 使用主键查询
     * @param eqptId 设备主键
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 12:57
     */
    @Override
    public BisEqpt queryByEqptId(String eqptId) throws Exception {
        EmptyUtils.isEmpty("主键", eqptId);
        return this.dao.queryByEqptId(eqptId, Constant.Equipment.DISENABLE);
    }

    /**
     * 分页查询
     * @param bisEqpt 码头对象
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 14:58
     */
    @Override
    public PageInfo<BisEqpt> queryList(BisEqpt bisEqpt) throws Exception {
        bisEqpt.setEnable(Constant.Equipment.DISENABLE);
        return super.queryList(bisEqpt);
    }

    /**
     * 查询所有的码头
     * @param bisEqpt 码头对象
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/22 14:57
     */
    @Override
    public List<SelectModel> queryAllDropList(BisEqpt bisEqpt) throws Exception {
        bisEqpt.setEnable(Constant.Equipment.DISENABLE);
        List<BisEqpt> bisEqpts = this.dao.queryList(bisEqpt);

        List<SelectModel> selectModels = new ArrayList<>(bisEqpts.size());
        // 封装前端需要的下拉框数据
        if (!CollectionUtils.isEmpty(bisEqpts)) {
            // 设置值
            for (BisEqpt equpiment : bisEqpts) {
                SelectModel selectModel = new SelectModel();
                selectModel.setName(equpiment.getEqptName());
                selectModel.setValue(equpiment.getEqptId());
                selectModels.add(selectModel);
            }
        }
        return selectModels;
    }

    /**
     * 查询所有的码头
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/27 15:48
     */
    @Override
    public List<BisEqpt> queryAllList() throws Exception {
        return this.dao.queryAllList(Constant.Equipment.DISENABLE);
    }
}
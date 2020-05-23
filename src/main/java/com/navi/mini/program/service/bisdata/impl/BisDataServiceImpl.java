package com.navi.mini.program.service.bisdata.impl;

import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.bisdata.BisDataDao;
import com.navi.mini.program.model.bisdata.BisData;
import com.navi.mini.program.model.common.SelectModel;
import com.navi.mini.program.service.bisdata.BisDataService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 使用dataCate和dataExt查询
     * @param dataCate
     * @param dataExt
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 19:05
     */
    @Override
    public List<BisData> queryByCateAndExt(String dataCate, String dataExt) throws Exception {
        EmptyUtils.isEmpty("dataCate", dataCate);
        EmptyUtils.isEmpty("dataExt", dataExt);
        return this.dao.queryByCateAndExt(dataCate, dataExt);
    }

    /**
     * 使用dataCate查询
     * @param dataCate
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 19:05
     */
    @Override
    public List<BisData> queryByCate(String dataCate) throws Exception {
        EmptyUtils.isEmpty("dataCate", dataCate);
        return this.dao.queryByCate(dataCate);
    }

    /**
     * 查询字典里的数据（下拉框用）
     * @param dataCate
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/23 19:33
     */
    @Override
    public List<SelectModel> queryAllDropList(String dataCate) throws Exception {
        List<BisData> list = this.queryByCate(dataCate);

        List<SelectModel> selectModels = new ArrayList<>(list.size());
        // 封装前端需要的下拉框数据
        if (!CollectionUtils.isEmpty(list)) {
            // 设置值
            for (BisData bisData : list) {
                SelectModel selectModel = new SelectModel();
                selectModel.setValue(bisData.getDataSeqId());
                selectModel.setName(bisData.getDataDesc());
                selectModels.add(selectModel);
            }
        }
        return selectModels;
    }
}
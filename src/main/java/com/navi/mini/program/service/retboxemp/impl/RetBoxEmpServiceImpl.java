package com.navi.mini.program.service.retboxemp.impl;


import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.dao.retboxemp.RetBoxEmpDao;
import com.navi.mini.program.model.retboxemp.RetBoxEmp;
import com.navi.mini.program.service.retboxemp.RetBoxEmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetBoxEmpServiceImpl extends BaseServiceImpl<RetBoxEmp, RetBoxEmpDao> implements RetBoxEmpService {
	
	@Override
    public void saveRetBoxEmp(RetBoxEmp retBoxEmp) throws Exception{
        Long id = retBoxEmp.getId();
        if(id == null){
            this.insert(retBoxEmp);
        }else{
            this.update(retBoxEmp);
        }

    }

    /**
     * 使用申请人主键查询空箱子
     * @param reqUserId 申请人主键
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/18 21:22
     */
    @Override
    public List<RetBoxEmp> queryRetBoxEmpByUserId(String reqUserId) throws Exception {
        EmptyUtils.isEmpty("申请人主键", reqUserId);
        return this.dao.queryRetBoxEmpByUserId(reqUserId, Constant.Flag.INVALID_FLAG);
    }
}
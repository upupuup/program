package com.navi.mini.program.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.constant.Constant.PageHelperDefault;
import com.navi.mini.program.common.dao.BaseDao;
import com.navi.mini.program.common.model.BaseModel;
import com.navi.mini.program.common.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * <一句话功能简述> 数据访问层数据通用接口，所有的业务层处理类都需要继承该抽象类
 * <功能详细描述>
 * @author miaojinyong
 * @version V1.0[产品/模块版本]
 * @param <D>
 */
public class BaseServiceImpl<T extends BaseModel,D extends BaseDao<T>> implements BaseService<T> {

	@Autowired
	protected D dao;
	
	@Transactional(rollbackFor=Exception.class)
	@Override
    public int insert(T t) throws Exception {
        return this.dao.insert(t);
    }

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int batchInsert(List<T> tlist) throws Exception {
		if (CollectionUtils.isEmpty(tlist)) {
			throw new Exception("新增的数据为空");
		}

		return this.dao.batchInsert(tlist);
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
    public int update(T t) throws Exception {
        return this.dao.update(t);
    }
    
	@Transactional(rollbackFor=Exception.class)
	@Override
    public int physicsDeleteById(Long id) throws Exception {
        return this.dao.physicsDeleteById(id);
    }
    
	@Transactional(rollbackFor=Exception.class)
	@Override
    public int deleteById(Long id) throws Exception {
    	if(id == null || Constant.DEFAULT_INT == id){
        	throw new Exception("传入的参数为空");
        }
    	T t = queryById(id);
    	if(null != t){
    		return update(t);
    	}
        return Constant.DEFAULT_OPERATE_SUCCESS;
    }
    
	@Transactional(rollbackFor=Exception.class)
	@Override
    public int deleteByIds(String[] ids)  throws Exception {
    	List<T> tList = new ArrayList<T>();
    	for(int i=0,length = ids.length;i<length;i++){
    		String id = ids[i];
    		if(StringUtils.isBlank(id)){
    			continue;
    		}
    		T t =  queryById(Long.parseLong(id));
    		if(null == t){
    			continue;
    		}
    		tList.add(t);
    		dao.update(t);
    	}
    	
        return Constant.DEFAULT_OPERATE_SUCCESS;
    }

	@Override
    public PageInfo<T> queryList(T t) throws Exception {
    	if (t.getPageIndex() == 0) {
			t.setPageIndex(PageHelperDefault.PAGENUM);
		}else{
			t.setPageIndex(t.getPageIndex());
		}
		if (t.getPageSize() == 0) {
			t.setPageSize(PageHelperDefault.PAGESIZE);
		}
        PageHelper.startPage(t.getPageIndex(), t.getPageSize());
        List<T> list = this.dao.queryList(t);
        return new PageInfo<T>(list);
    }
	
	@Override
	public PageInfo<T> queryListWithoutCompanyId(T t) throws Exception {
		return null;
	}

	@Override
	public PageInfo<T> queryListWithCompanyIdList(T t) throws Exception {
		return null;
	}
	

	@Override
    public T queryById(Long id) throws Exception {
        if(id == null || Constant.DEFAULT_INT == id){
        	throw new Exception("传入的参数为空");
        }
        return this.dao.queryById(id);
    }

}

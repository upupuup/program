package com.navi.mini.program.common.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <一句话功能简述> 数据访问层数据通用接口，所有的业务层处理类都需要继承该抽象类
 * <功能详细描述>
 * @author miaojinyong
 * @version V1.0[产品/模块版本]
 */
public interface BaseService<T>{

    /**
     * 函数功能描述：插入操作示例
     * @param t
     * @return
     * @throws Exception
     */
    int insert(T t) throws Exception;

    /**
     * 函数功能描述：批量修改操作示例
     * @param tlist
     * @return
     * @throws Exception
     */
    int batchInsert(List<T> tlist) throws Exception;
    /**
     * 函数功能描述：修改操作示例
     * @param t
     * @return
     * @throws Exception
     */
    int update(T t) throws Exception;

    /**
     * 函数功能描述：根据ID进行物理删除
     * @param id 唯一标识符
     * @author miaojinyong
     * @return 影响行数
     * @throws Exception 
     */
    int physicsDeleteById(Long id) throws Exception;

    /**
     * 方法描述： 根据id删除一条记录
     * @param id
     * @return
     * @throws Exception
     */
    int deleteById(Long id)  throws Exception;

    /**
     * 方法描述： 批量删除
     * @param ids
     * @return
     * @throws Exception
     */
    int deleteByIds(String[] ids)  throws Exception;

    /**
     * 函数功能描述：查询所有记录
     * @param t
     * @return
     * @throws Exception
     */
    PageInfo<T> queryList(T t) throws Exception;
    
    
    /**
     * 分页查询不需要通过公司过滤的列表
     * @author: miaojy
     * @date: 2020年4月28日 上午9:42:54
     */
    PageInfo<T> queryListWithoutCompanyId(T t) throws Exception;
    
    /**
     * 分页查询多个公司的数据的列表
     * @author: miaojy
     * @date: 2020年4月28日 上午9:44:05
     */
    PageInfo<T> queryListWithCompanyIdList(T t) throws Exception;

    /**
     * 函数功能描述：根据ID查询单个记录
     * @param id
     * @return
     * @throws Exception
     */
    T queryById(Long id) throws Exception;
}

package com.navi.mini.program.common.dao;

import com.navi.mini.program.common.model.BaseModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <一句话功能简述> 数据访问层数据通用接口，所有的数据层实现类都需要实现该接口
 * <功能详细描述>
 * @author miaojinyong
 * @version V1.0[产品/模块版本]
 */
public interface BaseDao<T extends BaseModel> {

    /**
     * 函数功能描述：插入操作示例
     * @param t
     * @return
     * @throws Exception
     */
    int insert(T t) throws Exception;
    
    /**
     * @Description: 批量新增
     * @author: miaojinyong
     * @date: 2017年9月13日 下午12:49:42
     */
    int batchInsert(@Param("list") List<T> tList) throws Exception;

    /**
     * 函数功能描述：修改操作示例
     * @param t
     * @return
     * @throws Exception
     */
    int update(T t) throws Exception;
    
    /**
     * 函数功能描述：根据ID进行物理删除
     * @author: miaojinyong
     * @param id 唯一标识符
     * @return 影响行数
     */
    int physicsDeleteById(Long id) throws Exception;

    /**
     * 方法描述： 根据id删除一条记录
     * @param updateUserId
     * @param updateUserName
     * @param updateTime
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 方法描述： 批量删除记录
     * @param updateUserId
     * @param updateUserName
     * @param updateTime
     * @param ids
     * @return
     */
    int deleteByIdsForArray(@Param("updateUserId") long updateUserId, @Param("updateUserName") String updateUserName, @Param("updateTime") String updateTime, @Param("array") Long[] ids);
    
    /**
     * 批量删除
     * @author: miaojinyong
     * @date: 2018年4月26日 上午12:20:28
     */
    int deleteByIdsForList(@Param("updateUserId") long updateUserId, @Param("updateUserName") String updateUserName, @Param("updateTime") String updateTime, @Param("array") List<Long> ids);
    
    /**
     * 函数功能描述：查询所有object表记录
     * @author: miaojinyong
     * @param object 示例实体对象
     * @return 结果集合
     */
    List<T> queryList(T object) throws Exception;

    
}

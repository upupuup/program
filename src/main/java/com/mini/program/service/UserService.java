package com.mini.program.service;

import com.mini.program.bean.User;

import java.util.Map;

public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    Map<String, Object> login(User user);

    /**
     * 使用id查询
     * @param id
     * @return
     */
    Map<String, Object> queryById(Long id);

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    Map<String, Object> queryList(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Map<String, Object> insert(User user)  throws Exception;

    /**
     * 获取token
     * @param code
     * @return
     * @throws Exception
     */
	Map<String, Object> getToken(String code) throws Exception;
}

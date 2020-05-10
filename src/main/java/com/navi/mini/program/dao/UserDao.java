package com.navi.mini.program.dao;

import com.navi.mini.program.bean.User;

import java.util.List;

/**
 * @Description: 用户类dao
 * @Author:
 * @CreateDate: 2020/2/16 19:49
 */
public interface UserDao {
    /**
     * 插入
     * @return
     */
    void insert(User user);

    User queryById(Long id);

    List<User> queryList(User user);
}

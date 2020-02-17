package com.mini.program.service.impl;

import com.mini.program.bean.User;
import com.mini.program.dao.UserDao;
import com.mini.program.service.UserService;
import com.mini.program.utils.ResponseUtil;
import com.mini.program.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description: 用户类service
 * @Author:
 * @CreateDate: 2020/2/16 19:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> login(User user) {
        System.out.println(user.getUsername() + "==" + user.getPassword() + "---" + user.getCode());
        return ResponseUtil.getResponseSuccess();
    }

    @Override
    public Map<String, Object> queryById(Long id) {
        Map<String, Object> result = ResponseUtil.getResponseSuccess();
        result.put("user", userDao.queryById(id));
        return result;
    }

    @Override
    public Map<String, Object> queryList(User user) {
        Map<String, Object> result = ResponseUtil.getResponseSuccess();
        result.put("dataList", userDao.queryList(user));
        return result;
    }

    @Override
    public Map<String, Object> insert(User user) throws Exception {
        user.setId(UUIDUtils.generatePrimaryKey());
        userDao.insert(user);
        return ResponseUtil.getResponseSuccess();
    }
}

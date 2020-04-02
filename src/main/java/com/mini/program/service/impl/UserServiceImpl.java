package com.mini.program.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mini.program.bean.User;
import com.mini.program.dao.UserDao;
import com.mini.program.service.UserService;
import com.mini.program.utils.HttpUtils;
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

    /**
     * 获取token
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getToken(String code) throws Exception {
        String APPID = "wx38b00b683bf8be2d";
        String SECRET = "91d189e9ec39403f778d0b4893ca76ca";
        String url =  "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        JSONObject resultJson = HttpUtils.doGet(url);
        System.out.println(resultJson);
        return resultJson;
    }
}

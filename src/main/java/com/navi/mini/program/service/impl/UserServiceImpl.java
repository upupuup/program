package com.navi.mini.program.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.navi.mini.program.model.User;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.dao.UserDao;
import com.navi.mini.program.service.UserService;
import com.navi.mini.program.common.utils.HttpUtils;
import com.navi.mini.program.common.utils.RedisUtils;
import com.navi.mini.program.common.utils.ResponseUtil;
import com.navi.mini.program.common.utils.UUIDUtils;
import org.apache.commons.lang.StringUtils;
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
    private RedisUtils redisUtils;
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
        result.put("data", userDao.queryList(user));
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
//        redisUtils.getString(Constant.WE_CHAT_ACCESS_TOKEN);
        String weChatAccessToken = "";
        // 处理结果
        Map<String, Object> result = ResponseUtil.getResponseSuccess();
        if (StringUtils.isBlank(weChatAccessToken)) {
            // 拼接请求地址
            String url = Constant.URL.replace("#{0}", Constant.APP_ID).replace("#{1}", Constant.SECRET).replace("#{2}", code);
            // 调用微信接口
            JSONObject resultJson = HttpUtils.doGet(url);
            weChatAccessToken = (String) resultJson.get("openid");
            result.put("data", weChatAccessToken);
            // 放到redis中
            redisUtils.set(Constant.WE_CHAT_ACCESS_TOKEN, weChatAccessToken, 6000);
        } else {
            result.put("data", weChatAccessToken);
        }
        return result;
    }

}

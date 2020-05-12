package com.navi.mini.program.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.EmptyUtils;
import com.navi.mini.program.common.utils.HttpUtils;
import com.navi.mini.program.dao.bisuser.BisUserDao;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.service.BisUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class BisUserServiceImpl extends BaseServiceImpl<BisUser, BisUserDao> implements BisUserService {
	
	@Override
    public void saveBisUser(BisUser bisUser) throws Exception{
        Long id = bisUser.getId();
        if(id == null){
            this.insert(bisUser);
        }else{
            this.update(bisUser);
        }

    }

    /**
     * 使用opendis查询用户信息
     * @param token 小程序openid（必须）
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/12 21:53
     */
    @Override
    public BisUser queryByToken(String token) throws Exception {
        EmptyUtils.isEmpty("小程序openid", token);
        return this.dao.queryByToken(token);
    }

    /**
     * 获取token
     * @param code 小程序传来的code（必须）
     * @return
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/12 22:22
     */
    @Override
    public String getToken(String code) throws Exception {
        String weChatAccessToken = "";
        // 处理结果
        if (StringUtils.isEmpty(weChatAccessToken)) {
            // 拼接请求地址
            String url = Constant.URL.replace("#{0}", Constant.APP_ID).replace("#{1}", Constant.SECRET).replace("#{2}", code);
            // 调用微信接口
            JSONObject resultJson = HttpUtils.doGet(url);
            weChatAccessToken = String.valueOf(resultJson.get("openid"));
            // 放入redis中
            return weChatAccessToken;
        } else {
            return weChatAccessToken;
        }
    }
}
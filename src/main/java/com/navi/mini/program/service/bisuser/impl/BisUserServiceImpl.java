package com.navi.mini.program.service.bisuser.impl;

import com.alibaba.fastjson.JSONObject;
import com.navi.mini.program.common.constant.Constant;
import com.navi.mini.program.common.service.impl.BaseServiceImpl;
import com.navi.mini.program.common.utils.*;
import com.navi.mini.program.dao.bisuser.BisUserDao;
import com.navi.mini.program.model.bisuser.BisUser;
import com.navi.mini.program.service.bisuser.BisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户service类
 * @Author: jiangzhihong
 * @CreateDate: 2020/5/18 9:48
 */
@Service
public class BisUserServiceImpl extends BaseServiceImpl<BisUser, BisUserDao> implements BisUserService {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 保存用户
     * @param bisUser
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/18 9:48
     */
	@Override
    public void saveBisUser(BisUser bisUser) throws Exception{
	    // 设置送果人的类型
	    bisUser.setUsrHeadFlg(Constant.UserType.SEND_FRUIT);
        bisUser.setUsrId(UUIDUtils.generatePrimaryKey() + "A");
        bisUser.setValidFlg(Constant.UserConstants.VALID_FLAG);
        this.insert(bisUser);
        SessionUtils.setUserSession(bisUser);
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
    public JSONObject getToken(String code) throws Exception {
        // 拼接请求地址
        String url = Constant.URL.replace("#{0}", Constant.APP_ID).replace("#{1}", Constant.SECRET).replace("#{2}", code);
        // 调用微信接口
        return HttpUtils.doGet(url);
    }

    /**
     * 登录
     * @param bisUser 用户实体类
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/18 10:05
     */
    @Override
    public void login(BisUser bisUser) throws Exception {

    }

    /**
     * 注册
     * @param bisUser 用户实体类
     * @throws Exception
     * @Author: jiangzhihong
     * @CreateDate: 2020/5/18 10:13
     */
    @Override
    public void register(BisUser bisUser) throws Exception {
        // 校验用户姓名和手机号
        this.checkRegisterDate(bisUser);
        // 保存数据
        this.saveBisUser(bisUser);
    }

    /**
     * 注册的时候校验数据
     * @param bisUser
     */
    private void checkRegisterDate(BisUser bisUser) throws Exception {
        String usrName = bisUser.getUsrName();
        String usrPhs = bisUser.getUsrPhs();
        // 校验用户名
        EmptyUtils.isTooLong("用户姓名", usrName, 32);
        // 校验手机号
        EmptyUtils.isEmpty("手机号", usrPhs);
        // 校验手机号码格式
        MatchUtils.matchTelephone(usrPhs, true);
        // 使用手机号查询是否被注册
        List<BisUser> bisUserList = this.dao.queryByPhone(usrPhs, Constant.UserConstants.VALID_FLAG);
        if (!CollectionUtils.isEmpty(bisUserList)) {
            throw new Exception("该手机号已被注册");
        }
        // 校验openid
        EmptyUtils.isEmpty("openid", bisUser.getToken());
    }


}
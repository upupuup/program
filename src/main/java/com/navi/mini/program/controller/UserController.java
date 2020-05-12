package com.navi.mini.program.controller;

import com.navi.mini.program.model.User;
import com.navi.mini.program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 登录类
 * @Author:
 * @CreateDate: 2020/2/16 19:21
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/queryById")
    public Map<String, Object> queryById(@RequestBody User user) {
        return userService.queryById(user.getId());
    }

    @PostMapping("/queryList")
    public Map<String, Object> queryList(@RequestBody User user) {
        return userService.queryList(user);
    }

    @PostMapping("/userAdd")
    public Map<String, Object> insert(@RequestBody User user) throws Exception {
        return userService.insert(user);
    }

    @RequestMapping("/getToken/{code}")
    public Map<String, Object> getToken(@PathVariable String code) throws Exception {
//        HashMap<String, String> codeMap = new HashMap<>(8);
//        codeMap.put("openid", "oEite5a14ZR3bnC4rkTp7Rw-Qd8Q");
//        codeMap.put("session_key", "qP2UP998Yd4syZhoMepuyg==");
        return userService.getToken(code);
    }


}

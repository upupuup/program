package com.mini.program.controller;

import com.mini.program.bean.User;
import com.mini.program.service.UserService;
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


}

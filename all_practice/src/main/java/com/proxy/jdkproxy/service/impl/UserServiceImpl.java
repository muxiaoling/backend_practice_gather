package com.proxy.jdkproxy.service.impl;

import com.proxy.jdkproxy.service.UserService;

/**
 * @author muxiaoling
 * @date 2022/10/4 16:45
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询用户信息。。。");
    }

    @Override
    public void update() {
        System.out.println("更新用户信息。。。");
    }
}

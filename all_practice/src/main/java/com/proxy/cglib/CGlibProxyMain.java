package com.proxy.cglib;

import com.proxy.cglib.service.UserDao;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author muxiaoling
 * @date 2022/10/4 18:20
 */
public class CGlibProxyMain {
    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);  //设置父类
        enhancer.setCallback(logInterceptor);

        //创建代理类
        UserDao userDao = (UserDao)enhancer.create();
        userDao.update();
        userDao.select();
    }
}

package com.proxy.jdkproxy;

import com.proxy.jdkproxy.service.UserService;
import com.proxy.jdkproxy.service.impl.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author muxiaoling
 * @date 2022/10/4 16:55
 */
public class JDKProxyMain {
    public static void main(String[] args) {
        //被代理的对象
        UserService userService = new UserServiceImpl();
        //获取对应的类加载器
        ClassLoader classLoader = userService.getClass().getClassLoader();
        //获取所有接口的Class，这里userService只实现了一个接口
        Class[] interfaces = userService.getClass().getInterfaces();

        //创建一个传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        LogHandler logHandler = new LogHandler(userService);

        /**
         * 创建代理对象
         * 1.JDK会根据传入的参数信息动态地在内存中创建和.class文件等同的字节码
         * 2.然后根据相应的字节码转化成对应的class
         * 3.调用newInstance()创建代理实例
         */
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        //调用代理的方法
        proxy.select();
        proxy.update();
    }
}

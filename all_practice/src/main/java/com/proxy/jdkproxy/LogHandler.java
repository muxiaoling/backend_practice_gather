package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author muxiaoling
 * @date 2022/10/4 16:47
 */
public class LogHandler implements InvocationHandler {
    //被代理的对象,目标对象
    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy    Proxy类
     * @param method  要执行的方法
     * @param args    要执行方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //模拟方法执行之前的操作
        System.out.println(String.format("log start time [%s] ", new Date()));

        //调用目标对象的target方法
        Object result = method.invoke(target, args);

        //模拟方法执行之后的操作
        System.out.println(String.format("log end time [%s] ", new Date()));
        return result;
    }
}

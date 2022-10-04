package com.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author muxiaoling
 * @date 2022/10/4 18:04
 */
public class LogInterceptor implements MethodInterceptor {
    /**
     *
     * @param o            表示要增强的对象
     * @param method       表示拦截的方法
     * @param objects      表示参数列表，基本数据类型需要传入对应的包装类
     * @param methodProxy  表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(String.format("log start time [%s] ", new Date()));
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(String.format("log end time [%s] ", new Date()));
        return result;
    }
}

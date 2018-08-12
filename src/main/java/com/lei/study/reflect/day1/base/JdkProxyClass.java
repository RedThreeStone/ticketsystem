package com.lei.study.reflect.day1.base;
/**
 * @author lei
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class JdkProxyClass implements InvocationHandler {
    private  Object target;
   /**
     * 绑定对象
     * @param target 目标对象,被代理的对象
     * @return
     */
    public  Object bind(Object target){
        this.target=target;
        Object proxyInstance=Proxy.newProxyInstance(this.target.getClass().getClassLoader(),this.target.getClass().getInterfaces(),this);
        return  proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置通知");
        Object o=method.invoke(target,args);
        System.out.println("后置通知");
        return o;
    }
}

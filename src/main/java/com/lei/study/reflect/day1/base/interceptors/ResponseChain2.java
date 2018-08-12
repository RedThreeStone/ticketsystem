package com.lei.study.reflect.day1.base.interceptors;

import java.lang.reflect.Method;

public class ResponseChain2 implements  InterceptorService {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是前置3");
        return true;
    }

    @Override
    public boolean arroud(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是环绕3");
        return false;
    }

    @Override
    public boolean after(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是后置3");
        return false;
    }
}

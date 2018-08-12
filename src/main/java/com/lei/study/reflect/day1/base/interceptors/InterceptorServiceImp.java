package com.lei.study.reflect.day1.base.interceptors;


import java.lang.reflect.Method;

public class InterceptorServiceImp implements InterceptorService {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是前置方法");
        return false;
    }

    @Override
    public boolean arroud(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是环绕方法");
        return false;
    }

    @Override
    public boolean after(Object proxy, Object target, Method method, Object[] objects) {
        System.out.println("我是后置方法");
        return false;
    }
}

package com.lei.study.reflect.day1.base.interceptors;

import java.lang.reflect.Method;

/**
 * @author Admin
 */
public interface InterceptorService {
    /**
     * 前置方法
     * @param proxy 代理对象
     * @param target 被代理对象
     * @param method 方法
     * @param objects 参数列表
     * @return
     */
    public boolean before(Object proxy,Object target,Method method,Object[] objects);
    /**
     * 环绕方法
     * @param proxy 代理对象
     * @param target 被代理对象
     * @param method 方法
     * @param objects 参数列表
     * @return
     */

    public boolean arroud(Object proxy,Object target,Method method,Object[] objects);
    /**
     * 后置方法
     * @param proxy 代理对象
     * @param target 被代理对象
     * @param method 方法
     * @param objects 参数列表
     * @return
     */

    public boolean after(Object proxy,Object target,Method method,Object[] objects);
}

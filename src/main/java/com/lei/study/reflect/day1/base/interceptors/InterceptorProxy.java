package com.lei.study.reflect.day1.base.interceptors;
/**
 * @author Admin
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorProxy implements InvocationHandler {
    private String  interceptorStr ;
    private  Object target;

    public InterceptorProxy(String interceptorStr, Object target) {
        this.interceptorStr = interceptorStr;
        this.target = target;
    }

    public static   Object getTargetProxy(Object target, String interceptorStr){
        Object proxyInstance=Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorProxy(interceptorStr,target ));
        return  proxyInstance;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj=null;
        if(interceptorStr==null){
            System.out.println("我是没有拦截器的前置方法");
            obj=method.invoke(target,args);
            System.out.println("我是没有拦截器的后置方法");
        }else {
            InterceptorService interceptorService= (InterceptorService) Class.forName(interceptorStr).newInstance();
            if(interceptorService.before(proxy,target,method,args)){
                obj=method.invoke(target,args);
            }else {
                interceptorService.arroud(proxy,target,method,args);
            }
            interceptorService.after(proxy,target,method,args);
        }
        return obj;
    }
}

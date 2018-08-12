package com.lei.study.reflect.day1.base;
/**
 * @author Admin
 */

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private  Object target;
    public CglibProxy(Object obj){
        target = obj;
    }
    public  CglibProxy(){}
    public Object getProxy(Class cla){
        Enhancer enhancer =  new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(cla);
        return  enhancer.create();
    }
    public Object getProxy(Object target){
        this.target=target;
        Enhancer enhancer =  new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        //这里可以传构造方法的参数
        return  enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("拦截前方法");
       // Object invoke=method.invoke(target,objects);
        Object  invoke = methodProxy.invokeSuper(o,objects);
        System.out.println("拦截后方法");
        return invoke;
    }
}

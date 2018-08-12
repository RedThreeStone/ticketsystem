package com.lei.study.reflect.day1.test;

import com.lei.study.reflect.day1.base.CglibProxy;
import com.lei.study.reflect.day1.base.JdkProxyClass;
import com.lei.study.reflect.day1.base.ReflectService;
import com.lei.study.reflect.day1.base.ReflectServiceImp;
import com.lei.study.reflect.day1.base.interceptors.InterceptorProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @@author Admin
 */
public class ReflectTest {
    /**
     * 反射
     * @throws Exception
     */
    @Test
    public  void  saySomething() throws Exception{
        //如果给了类一个构造方法则原构造方法会失效.
        ReflectServiceImp reflectServiceImp = (ReflectServiceImp) Class.forName("com.lei.study.reflect.day1.base.ReflectServiceImp")
                .getConstructor(String.class).newInstance("leiZi");
        //这里可以说只是拿到了一个方法的声明,如果要调用方法还需要拿到一个实例对象哦
        Method sayMyName =Class.forName("com.lei.study.reflect.day1.base.ReflectServiceImp").getMethod("sayMyName", String.class);
        sayMyName.invoke(reflectServiceImp,"");
    }

    /**
     * jdk动态代理
     */
    @Test
    public  void invocationTest(){
        JdkProxyClass jdkProxyClass = new JdkProxyClass();
        ReflectService proxy= (ReflectService) jdkProxyClass.bind(new ReflectServiceImp("帅磊子"));
        proxy.sayMyName("");
    }
    @Test
    public  void  cglibTest(){
        CglibProxy cglibProxy = new CglibProxy(new ReflectServiceImp("帅磊子"));
        ReflectServiceImp reflectServiceImp=(ReflectServiceImp)cglibProxy.getProxy(new ReflectServiceImp("帅磊子").getClass());
        reflectServiceImp.setName("小明");
        reflectServiceImp.sayMyName("");

    }
    @Test
    public void  interceptorTest(){
        ReflectService reflectService= (ReflectService) InterceptorProxy.getTargetProxy(new ReflectServiceImp(),
                "com.lei.study.reflect.day1.base.interceptors.InterceptorServiceImp");
        reflectService.sayMyName("小明");
    }
    @Test
    public void  chainTest(){
        ReflectService reflectService= (ReflectService) InterceptorProxy.getTargetProxy(new ReflectServiceImp(),
                "com.lei.study.reflect.day1.base.interceptors.ResponseChain");
        ReflectService reflectService1= (ReflectService) InterceptorProxy.getTargetProxy(reflectService,
                "com.lei.study.reflect.day1.base.interceptors.ResponseChain1");
        ReflectService reflectService2= (ReflectService) InterceptorProxy.getTargetProxy(reflectService1,
                "com.lei.study.reflect.day1.base.interceptors.ResponseChain2");
        reflectService2.sayMyName("小刘");
    }
}

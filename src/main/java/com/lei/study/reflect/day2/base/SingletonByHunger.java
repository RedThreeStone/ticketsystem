package com.lei.study.reflect.day2.base;

/**单例模式饿汉式,指在服务器启动的时候就维护了一个实例变量,优点,资源创建的时候就已经加载,线程安全,缺点,也是因为在类加载的时候就已经创建,耗费资源
 * @author Admin
 */
public class SingletonByHunger {
    private static SingletonByHunger singletonByHunger=new SingletonByHunger();

    private  SingletonByHunger(){

    }
    public static SingletonByHunger getInstance(){
        return  singletonByHunger;
    }
}

package com.lei.study.reflect.day2.base;

/**
 * 单例模式懒汉式,指第一次调用的时候才维护一个单例,优点,速度快 缺点,线程不安全,虽然加了锁 但是效率低下
 */
public class SingletonByLazy {
    private static volatile SingletonByLazy singletonByLazy;

    private SingletonByLazy(){

    }
    public static SingletonByLazy getInstance(){
        if(singletonByLazy==null){
            synchronized (SingletonByLazy.class){
                if (singletonByLazy == null) {
                    singletonByLazy=new SingletonByLazy();
                }
            }
        }

        return  singletonByLazy;

    }
}

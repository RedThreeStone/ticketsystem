package com.lei.study.spring;

import org.springframework.stereotype.Component;

@Component
public class AopTestImp implements AopTest {
    @Override
    public void  print(String name,String age){
        System.out.println("我的名字是:"+name+",今年"+age+"岁.");
    }
}

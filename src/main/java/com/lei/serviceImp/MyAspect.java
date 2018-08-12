package com.lei.serviceImp;

import com.lei.study.spring.VerifierName;
import com.lei.study.spring.VerifierNameImp;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @DeclareParents(value = "com.lei.study.spring.*+",defaultImpl = VerifierNameImp.class)
    private VerifierName verifierName;
    @Pointcut("execution(* com.lei.study.spring.AopTestImp.print(..))")
    public void  point(){

    }
    @Before("point()")
    public void  before(){
        System.out.println("111111111111");
    }
    @After("point()&&args(name,age)")
    public void  after(String name,String age){
        System.out.println(name+"after:"+age);
    }
    @AfterReturning("point()&&args(name,age)")
    public void  afterReturn(String name,String age){
        System.out.println(name+"afterReturn:"+age);
    }
    @AfterThrowing("point()&&args(name,age)")
    public void  throwing(String name,String age){
        System.out.println(name+"AfterThrowing"+age);
    }
}

package com.lei.test;

import com.lei.study.spring.AopTest;
import com.lei.study.spring.VerifierName;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


public class AspectjTest extends BaseTest {
    @Autowired
    private AopTest aopTest;
    @Test
    public void testAspectJ(){
        VerifierName verifierName = (VerifierName) aopTest;
        if(verifierName.verifierName("")){
            aopTest.print("刘明","18");
        }
        ModelAndView modelAndView = new ModelAndView();
    }
}

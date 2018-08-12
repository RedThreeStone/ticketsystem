package com.lei.study.reflect.day2.base;

import java.util.Observer;

public class StaticFactroy {
    public static Observer getObserver(String type){
        if("1".equals(type)){
            return  new Seller1();
        }else if ("2".equals(type)){
            return  new Seller2();
        }else {
            return  null;
        }
    }
}

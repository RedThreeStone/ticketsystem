package com.lei.study.reflect.day2.test;

import com.lei.study.reflect.day2.base.ProductList;
import com.lei.study.reflect.day2.base.Seller1;
import com.lei.study.reflect.day2.base.Seller2;
import com.lei.study.reflect.day2.base.StaticFactroy;

public class Test {
    @org.junit.Test
    public void  testObserve(){
        ProductList productList=ProductList.getInstance();
        Seller1 seller1 = new Seller1();
        Seller2 seller2 = new Seller2();
        productList.addObserver(seller1);
        productList.addObserver(seller2);
        productList.addProduct("牙膏");
    }
    @org.junit.Test
    public void  staticeFactroyTest(){
        System.out.println(StaticFactroy.getObserver("1"));
    }
}

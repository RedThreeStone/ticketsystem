package com.lei.study.reflect.day2.base;

import java.util.Observable;
import java.util.Observer;

public class Seller1 implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Seller1收到新产品啦:"+arg.toString());
    }
}

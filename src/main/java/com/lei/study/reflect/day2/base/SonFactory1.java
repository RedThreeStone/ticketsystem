package com.lei.study.reflect.day2.base;

import java.util.Observer;

public class SonFactory1 implements IStaticFactory {
    @Override
    public Observer createSeller() {
        return new Seller1();
    }
}

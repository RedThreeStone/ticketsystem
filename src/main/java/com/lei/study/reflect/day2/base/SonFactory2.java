package com.lei.study.reflect.day2.base;

import java.util.Observer;

public class SonFactory2 implements IStaticFactory {
    @Override
    public Observer createSeller()
    {
        return new Seller2();
    }
}

package com.lei.study.reflect.day2.base;

import java.util.Observer;

public class FatherFactory implements IStaticFactory {
    @Override
    public Observer createSeller() {
        return new SonFactory1().createSeller();
    }
}

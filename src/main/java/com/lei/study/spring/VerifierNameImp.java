package com.lei.study.spring;

public class VerifierNameImp implements VerifierName {
    @Override
    public boolean verifierName(String name) {
        if (name == null || "".equals(name)) {
            return true;
        } else {
            return  false;
        }
    }
}

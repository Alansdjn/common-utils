package com.kevin.common.utils.genericity;

public abstract class Child implements Parent {

    @Override
    public <T> String getInfo(T info) {
        String processString = process();
        return info.toString() + processString;
    }
    
    protected String process() {
        // return default value empty String
        return "";
    }

}


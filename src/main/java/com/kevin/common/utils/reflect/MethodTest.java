package com.kevin.common.utils.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class<MethodTest> clazz = MethodTest.class;
        Method[] methods = clazz.getMethods();
        
        for (Method method : methods) {
            method.invoke(clazz.newInstance());
        }
    }
}



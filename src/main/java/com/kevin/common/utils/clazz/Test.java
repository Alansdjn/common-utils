package com.kevin.common.utils.clazz;

public class Test {

    public static int x;
    static {
        System.out.println("��̬���������");
        x = 1;
    }

    public Test(){
        System.out.println("���췽������");
        System.out.println(x);
    }
}



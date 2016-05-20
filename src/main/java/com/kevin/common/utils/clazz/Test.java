package com.kevin.common.utils.clazz;

public class Test {

    public static int x;
    static {
        System.out.println("静态代码块运行");
        x = 1;
    }

    public Test(){
        System.out.println("构造方法运行");
        System.out.println(x);
    }
}



package com.kevin.common.utils.exceptiontest;

public class ThrowExceptionInTryBlock {
    
    public static final int a = -1;
    public static final int b = Integer.MAX_VALUE;

    public static void test() {
        Integer integer = new Integer(22);
        Object object = (Object) integer;
        String string = (String) (Object) integer;
        System.out.println(string);
        try {
            throw new NullPointerException("is null!");
        } catch(NullPointerException e) {
//            e.printStackTrace();
            throw new Error("is error", e);
        }
    }
    
    public static void main(String[] args) {
        test();
    }
}



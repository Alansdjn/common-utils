package com.kevin.common.utils.json;


public class ParseJson {

    public static void invokeMethod() {
        getInvokeMethodName();
    }

    public static void getInvokeMethodName() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        
        System.out.println(className + "." + methodName);
    }
    
    public static void main(String[] args) {
        invokeMethod();
        
    }
}
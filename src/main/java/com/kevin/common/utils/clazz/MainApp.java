package com.kevin.common.utils.clazz;

public class MainApp {

    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        //ClassLoader loader=test.class.getClassLoader();
        //可以用别的classloader来load其他类
        ClassLoader loader=MainApp.class.getClassLoader();
        System.out.println("before load");
        Class c=loader.loadClass("clazz.Test"); 
        System.out.println("after load");
       
        System.out.println("------华丽的-----------------------分割线-----");
       
        System.out.println("before load newInstance");
        Test t=(Test) c.newInstance();
        System.out.println("after load newInstance");
       
        /*
        System.out.println("before forName");
        Class c2=Class.forName("clazz.Test");
        System.out.println("after forName");
        c2.newInstance();
       
        System.out.println("------华丽的-----------------------分割线-----");
       
        System.out.println("before forName false");
        Class c3=Class.forName("clazz.Test",false, loader);
        System.out.println("after forName false");
        Test test = (Test) c3.newInstance();*/
    }
}



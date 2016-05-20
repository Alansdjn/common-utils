package com.kevin.common.utils.clazz;

public class ClazzTest {

    public static void main(String[] args) {
        System.out.println(ClazzTest.class.getClassLoader());
        System.out.println(ClazzTest.class.getClassLoader().getParent());
        System.out.println(ClazzTest.class.getClassLoader().getParent().getParent());
    }
}



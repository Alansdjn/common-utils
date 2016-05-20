package com.kevin.common.utils.integertest;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = new Integer(3);                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
    }
}



package com.kevin.common.utils.exception;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 类RuntimeConstantPoolOOM.java的实现描述：方法去和运行时常量池溢出
 * @author kevin.ww 2016年6月5日 上午1:56:30
 */
public class RuntimeConstantPoolOOM {
    private  String str = "hello world!";

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while(true) {
//            list.add(String.valueOf(UUID.randomUUID().toString() + (i++)).intern());
//        }
        Field[] fields = RuntimeConstantPoolOOM.class.getDeclaredFields();
        Field field = fields[0];
        field.setAccessible(true);
        String object = (String) field.get(new RuntimeConstantPoolOOM());
        System.out.println(object);
    }
}



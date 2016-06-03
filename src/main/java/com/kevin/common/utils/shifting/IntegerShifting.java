package com.kevin.common.utils.shifting;

import org.springframework.util.StringUtils;

public class IntegerShifting {

    public static void main(String[] args) {
//        int a = 512;
//        int b = -512;
        
//        System.out.println(a);
//        System.out.println(a >>> 1);
//        System.out.println(b);
//        System.out.println(b >>> 1);
//        
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(a >>> 1));
//        System.out.println(Integer.toBinaryString(b));
//        System.out.println(Integer.toBinaryString(b >>> 1));
        
        int value = 0x20800000;
        String binString = Integer.toBinaryString(value);
        int lenth = 32 - binString.length();
        for (int i = 0; i < lenth; i++) {
            System.out.print('0');
        }
        System.out.println(Integer.toBinaryString(value));
        if ((value & 0x800000) != 0) {
            System.out.println(">>>");
            value |= 0xff000000;
        }
        binString = Integer.toBinaryString(value);
        lenth = 32 - binString.length();
        for (int i = 0; i < lenth; i++) {
            System.out.print('0');
        }
        System.out.println(Integer.toBinaryString(value));
    }
}



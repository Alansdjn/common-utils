package com.kevin.common.utils.booleantest;

public class BooleanTest {

    public static void main(String[] args) {
        String trueStr = "true";
        Boolean test = true;//Boolean.parseBoolean(trueStr);
        if (Boolean.TRUE == test) {
            System.out.println("Boolean.TRUE == test");
        }
        else {
            System.out.println("Boolean.TRUE != test");
        }
    }
}

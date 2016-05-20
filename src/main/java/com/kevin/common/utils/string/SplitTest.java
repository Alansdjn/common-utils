package com.kevin.common.utils.string;

public class SplitTest {

    public static void main(String[] args) {
        String toSplit = "aa";
        String[] splitedString = toSplit.split(";");
        System.out.println(splitedString.length);
    }

}



package com.kevin.common.utils.string;

public class ReverseStringTest {

    public static void main(String[] args) {
        String str = "阿里巴巴（中国）网络技术有限公司";
        
        System.out.println(reverseString(str));
        
        System.out.println(reverseStringRecursion2(str, ""));
    }
    
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static String reverseStringRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        return reverseStringRecursion(str.substring(1)) + str.charAt(0);
    }
    
    public static String reverseStringRecursion2(String dest, String src) {
        if (src == null) {
            src = "";
        }
        if (dest == null || dest.length() <= 1) {
            return dest + src;
        }
        
        return reverseStringRecursion2(dest.substring(1), src + dest.charAt(0));
    }
}



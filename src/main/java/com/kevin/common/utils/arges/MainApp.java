package com.kevin.common.utils.arges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    
    public static volatile int a = 0;
    public static final int b = 1;
    public static int c = 2;

    public static void main(String[] args) {
//        List<String> argList = new ArrayList<String>(Arrays.asList(args));
//        if (argList.size() > 0) {
//            for (String arg : argList) {
//                if ("online".equalsIgnoreCase(arg)) {
//                    System.setProperty("isOnline", "true");
//                    break;
//                }  
//            }
//        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        List<String> list = new ArrayList<String>(map.values());
        System.out.println(list);
        
        test("hello");
        
        getArgName(map);
    }
    
    public static void test(String str) {
        String local = str;
        System.out.println(local);
    }
    
    public static void getArgName(Object obj) {
        System.out.println(obj.getClass().getName());
    }
}



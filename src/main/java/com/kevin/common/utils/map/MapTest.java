package com.kevin.common.utils.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaaa");
        map.put("b", "bbbb");
        
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}



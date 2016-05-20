package com.kevin.common.utils.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongToString {

    public static void main(String[] args) {
       List<String> idList = new ArrayList<String>(Arrays.asList("1", "2222", "444")); 
       
       System.out.println(idList.contains(new Long(2222).toString()));
    }

}



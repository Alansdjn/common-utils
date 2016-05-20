package com.kevin.common.utils.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListRemoveTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        
        List<Integer> list2 = new ArrayList<Integer>();
        list2.addAll(list);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.addAll(list);
        
        System.out.println("before:" + list);
        remove1(list);
        System.out.println("before:" + list2);
        remove2(list2);
        System.out.println("before:" + list3);
        remove3(list3);

    }
    
    public static void remove1(List list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        System.out.println(list);
    }

    public static void remove2(List list) {
        int size = list.size();
        for (int i = size - 1; i > -1; i--) {
            list.remove(i);
        }

        System.out.println(list);
    }

    public static void remove3(List list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }

        System.out.println(list);
    }

}



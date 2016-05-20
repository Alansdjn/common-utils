package com.kevin.common.utils.sort;

import java.util.Comparator;

public interface Sorter {

    <T extends Comparable<T>> void sort(T[] list);
    
    <T> void sort(T[] list, Comparator<T> comp);
}



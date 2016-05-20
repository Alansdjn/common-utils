package com.kevin.common.utils.sort;

import java.util.Comparator;


public class BubbleSorter implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            int end = len - i;
            for (int j = 0; j < end; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    swap(list[j], list[j + 1]);
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            int end = len - i;
            for (int j = 0; j < end; j++) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    swap(list[j], list[j + 1]);
                    swapped = true;
                }
            }
        }
    }

    private <T> void swap(T first, T second) {
        T tmp = first;
        first = second;
        second = tmp;
    }
}



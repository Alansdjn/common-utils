package com.kevin.common.utils.loop;

public class MultiLoop {

    public static void main(String[] args) {
        A:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (i == 2) {
                        System.out.println(i + ", " + j + ", " + k);
                        break A;
                    }
                }
            }
            
        }
    }
}



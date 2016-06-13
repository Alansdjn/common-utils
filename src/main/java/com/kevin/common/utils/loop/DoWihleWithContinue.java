package com.kevin.common.utils.loop;

public class DoWihleWithContinue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("begin");
        int i = 0;
        do {
            if (i == 0) {
                i++;
                continue;
            } else {
                System.out.println(i);
            }
        }while(false);
        System.out.println("end, i = " + i);
    }
}



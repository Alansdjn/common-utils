package com.kevin.common.utils.recursion;

public class TailRecursion {

    static int  function(int i) {
        if (i == 0) {
            System.out.println("end");
            return i;
        }
        
        System.out.println("go on " + i);
        --i;
        return function(i);
    }
    
    public static void main(String[] args) {
        function(5);
    }
}



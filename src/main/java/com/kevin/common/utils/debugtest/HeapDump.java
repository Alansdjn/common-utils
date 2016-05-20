package com.kevin.common.utils.debugtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapDump {

    public static void main(String[] args) throws IOException, InterruptedException {
        String test = "this is a test code for HeapDump";
        
        System.out.println(test);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println("line: " + line);
            if ("gc".equals(line)) {
                System.out.println("System.gc() begin");
                System.gc();
                System.out.println("System.gc() end");
                break;
            }
        }
        line = br.readLine();
    }

}



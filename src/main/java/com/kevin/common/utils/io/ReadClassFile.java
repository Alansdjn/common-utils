package com.kevin.common.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadClassFile {

    public static void main(String[] args) throws IOException {
        String path = "D:/lunaworkspace/common.utils/target/classes/com/kevin/common/utils/arges/MainApp.class";
//        File file = new File(path);
//        InputStream in = new FileInputStream(file);
//        byte[] b = new byte[1024];
//        in.read(b);
//        System.out.println(b.toString());
        readFileByBytes(path);
    }
    
    public static void readFileByBytes(String path) {
        File classFile = new File(path);
        InputStream in = null;
        System.out.println("begin to read class file:");
        try {
            in = new FileInputStream(classFile);
            int tmpByte;
            int count = 0;
            while( (tmpByte = in.read()) != -1) {
                String hexStr = Integer.toHexString(tmpByte);
                if (hexStr.length() < 2) {
                    hexStr = "0" + hexStr;
                }
                System.out.print(hexStr.toUpperCase());
                if (++ count % 16 == 0) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println();
        System.out.println("finish to read class file.");
    }
}



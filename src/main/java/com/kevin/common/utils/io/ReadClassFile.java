package com.kevin.common.utils.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadClassFile {

    public static void main(String[] args) throws IOException {
        String path = "D:/lunaworkspace/common.utils/target/classes/com/kevin/common/utils/arges/MainApp.class";
        File file = new File(path);
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println(b.toString());
    }
}



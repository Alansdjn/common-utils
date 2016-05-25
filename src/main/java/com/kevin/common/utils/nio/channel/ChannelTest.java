package com.kevin.common.utils.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("src/main/java/com/kevin/common/utils/arges/MainApp.java","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
 
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
 
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
 
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        method1();
    }
}



package com.kevin.common.utils.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * ��HeapOOM.java��ʵ��������ģ��OOM
 * @author kevin.ww 2016��6��5�� ����1:32:39
 */
public class HeapOOM {

    static class OOMObject{
        
    }
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}



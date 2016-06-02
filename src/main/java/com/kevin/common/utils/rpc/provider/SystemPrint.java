package com.kevin.common.utils.rpc.provider;

import com.kevin.common.utils.rpc.api.PrintText;

public class SystemPrint implements PrintText {

    @Override
    public String print(String text) {
        System.out.println(text);
        return "ϵͳ�Ѵ�ӡ:" + text;
    }

}



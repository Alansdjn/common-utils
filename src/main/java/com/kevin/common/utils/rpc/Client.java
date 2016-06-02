package com.kevin.common.utils.rpc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kevin.common.utils.rpc.api.PrintText;

public class Client {

    public static void main(String[] args) {
        BeanFactory apx = new ClassPathXmlApplicationContext("classpath:spring-config-client.xml");
        PrintText pt = (PrintText) apx.getBean("caishengSimpleRemoteProxyPrintText");
        System.out.println(pt.print("远程调用演示"));
    }

}



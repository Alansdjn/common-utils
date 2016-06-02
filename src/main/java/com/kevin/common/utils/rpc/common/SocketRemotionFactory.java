package com.kevin.common.utils.rpc.common;

import java.lang.reflect.Proxy;

import com.kevin.common.utils.rpc.consumer.SocketConsumerProxy;

public class SocketRemotionFactory {

    private RemoteDataSource dataSource;
    public SocketRemotionFactory(RemoteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Object getRemoteClientProxy(){

        Object result = null;

        Class<?> clazz = dataSource.getInterfaceClass();
        if (clazz == null){
            return "错误的client 代理，无对应的class";
        }

        Class<?>[] clazzArray = new Class[1];
        clazzArray[0] = clazz;
        try{
            result = Proxy.newProxyInstance(clazz.getClassLoader(), clazzArray, new SocketConsumerProxy(dataSource));
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}



package com.kevin.common.utils.rpc.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

import com.kevin.common.utils.rpc.common.RemoteDataSource;


public class SocketConsumerProxy implements InvocationHandler {

    private Object target;
    
    private RemoteDataSource dataSource;
    
    public SocketConsumerProxy(RemoteDataSource dataSource){
        this.dataSource = dataSource;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StringBuffer stream = this.buildRpcRequest(proxy, method, args);

        Object object = null;
        try{
            long startTime =  System.currentTimeMillis();
            System.out.println("New rpc client send " + stream.toString() + "  time:" + startTime);
            // socket connect
            Socket socket=new Socket(dataSource.getIp(), dataSource.getPort());

            // request
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            os.println(stream.toString());
            os.flush();

            // read response
            BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            object = br.readLine();

            long endTime =  System.currentTimeMillis();
            System.out.println("client read from service:" + object + "  time:" + (endTime - startTime));
        }catch (IOException e){
            e.printStackTrace();
            object = e.toString();
        }

        return object;
    }

    private StringBuffer buildRpcRequest(Object proxy, Method method, Object[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("version:%s|##|cypher:%s|##|interfaceName:%s|##|interface:%s|##|method:%s|##|params:", 
                                    dataSource.getVersion(), 
                                    dataSource.getCypher(), 
                                    dataSource.getInterfaceName(), 
                                    dataSource.getInterfaces(), 
                                    method.getName()));

        for (Object obj : args) {
            buffer.append(obj.getClass().getName() + "+" + obj.toString() + ",");
        }
        return buffer;
    }

}
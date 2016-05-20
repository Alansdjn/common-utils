package com.kevin.common.utils.dymaicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    String getInfos1();
    String getInfos2();
    void setInfo(String infos1, String infos2);
    void display();
}

class HelloImpl implements Hello {

    private volatile String infos1;
    private volatile String infos2;
    
    @Override
    public String getInfos1() {
        // TODO Auto-generated method stub
        return infos1;
    }

    @Override
    public String getInfos2() {
        // TODO Auto-generated method stub
        return infos2;
    }

    @Override
    public void setInfo(String infos1, String infos2) {
        // TODO Auto-generated method stub
        this.infos1 = infos1;
        this.infos2 = infos2;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println(infos1 + "\t" + infos2);
    }
    
}

class AOPFactory implements InvocationHandler {

    private Object proxyed;
    
    public AOPFactory(Object proxyed){
        this.proxyed = proxyed;
    }
    
    public void printInfo(String info, Object...args) {
        System.out.println(info);
        if (args == null) {
            System.out.println("\t 空值");
        } else {
            for (Object obj : args) {
                System.out.println(obj + "\t");
            }
        }
    }
    
    @Override
    public Object invoke(Object proxyed, Method method, Object[] args) throws Throwable {
        System.out.println("=====> 调用方法名：" + method.getName());
        Class<?>[] variables = method.getParameterTypes();
        for (Class<?> typevariable : variables) {
            System.out.println("=============> " + typevariable.getName());
        }
        printInfo("传入参数为：", args);
        Object result = method.invoke(this.proxyed, args);
        printInfo("返回的参数为：",result);
        printInfo("返回值类型为：",method.getReturnType());
        return result;
    }
    
}
public class DynamicProxy {

    public static Object getBean(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object obj = Class.forName(className).newInstance();
        InvocationHandler handler = new AOPFactory(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) getBean("dymaicproxy.HelloImpl");
            hello.setInfo("kevin", "ww");
            hello.getInfos1();
            hello.getInfos2();
            hello.display();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}



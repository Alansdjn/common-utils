package com.kevin.common.utils.rpc.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.kevin.common.utils.rpc.common.RemoteDataSource;

public class SocketProvider {

    private RemoteDataSource dataSource;

    public SocketProvider(RemoteDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Object provide() throws Throwable {
        ServerSocket serverSocket = new ServerSocket(dataSource.getPort());
        while (true) {
            Socket socket = null;
            try {
                //接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
                socket = serverSocket.accept();
                this.getRpcRequest(socket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getRpcRequest(Socket socket) {
        try {
            System.out.println("rpc client accepted " + socket.getInetAddress() + ":" + socket.getPort() + "   time:" + System.currentTimeMillis());
            // 接收服务器的反馈
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String msg = br.readLine();

            System.out.println("读到远程调用请求:" + msg);
            Object obj  = this.parseRpcClientRequest(msg);

            // 接收服务器的反馈
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            os.println(obj.toString());
            os.flush();

            System.out.println("rpc server return " + obj + ":" + socket.getPort() + "   time:" + System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object parseRpcClientRequest(String msg) {
        Object result = "";
        if (!StringUtils.hasText(msg)){
            return result;
        }

        String[] infos = msg.split("\\|##\\|");
        Map<String, String> infoMap = new HashMap<String, String>();
        for(String info : infos){
            String[] pair = info.split(":");
            infoMap.put(pair[0], pair[1]);
        }
        if (infoMap.isEmpty()){
            return "无调用参数";
        }

        if (!dataSource.getCypher().equals(infoMap.get("cypher"))){
            return "加密串不对";
        }

        if (!dataSource.getVersion().equals(infoMap.get("version"))){
            return "服务版本号不对";
        }

        String interfaces = infoMap.get("interface");
        String interfaceName = infoMap.get("interfaceName");
        String methodName = infoMap.get("method");
        String params = infoMap.get("params");

        if(!StringUtils.hasText(interfaces) || !StringUtils.hasText(methodName) || !StringUtils.hasText(interfaceName)){
            return "无调用接口或者方法 或者接口beanName";
        }

        // bean
        Object obj = dataSource.getRemotionFactory().getRemoteClientProxy();
        if(obj == null){
            return "未找到对应的服务";
        }

        // bean 和 interface对应关系
        boolean isInterfaceRight = false;
        Class<?>[] clazzArray = obj.getClass().getInterfaces();
        for (Class<?> clazz : clazzArray){
            if (clazz.getName().equals(interfaces)){
                isInterfaceRight = true;
                break;
            }
        }
        if (isInterfaceRight == false){
            return "错误的bean Name 和 interface对应关系";
        }


        // 参数对应的类和对象
        String[] paramsArray = params.split(",");
        Class<?>[] paramsClazzArray = new Class<?>[paramsArray.length];
        Object[] paramObjArray = new Object[paramsArray.length];
        try{
            for (int i = 0; i < paramsArray.length; i ++){
                String paramInfo = paramsArray[i];
                if (!StringUtils.hasText(paramInfo)) {  // 过滤掉多余的逗号
                    continue;
                }

                String[] paramsInfos = paramInfo.split("\\+");

                Class c = Class.forName(paramsInfos[0]);
                paramsClazzArray[i] = c;
                paramObjArray[i] = paramsInfos[1];
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return "未找到参数对应的类名:" +e.toString();
        }


        try {
            Method method = obj.getClass().getMethod(methodName, paramsClazzArray);
            result = method.invoke(obj, paramObjArray);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return "未找到参数对应的方法名称:" +e.toString();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
            return "无效的调用:" +e.toString();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return "无效的目标地址:" +e.toString();
        }

        result = "我是服务器代理aop, result=" + result;
        return result;
    }
}



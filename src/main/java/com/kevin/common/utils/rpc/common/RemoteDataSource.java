package com.kevin.common.utils.rpc.common;

public class RemoteDataSource {

    private String ip = "127.0.0.1";
    private int port =  9090;              // 端口
    private String interfaces;             // 接口全路径
    private String interfaceName;          // 接口名
    private String version;
    private String cypher ="default";       // 密码
    private Class<?> interfaceClass;       // 类文件

    private SocketRemotionFactory remotionFactory;

    public void init(){
        remotionFactory = new SocketRemotionFactory(this);

        try {
            interfaceClass = Class.forName(interfaces);
        } catch (ClassNotFoundException e) {

        }
    }

    public Object getClientObject(){
        return remotionFactory.getRemoteClientProxy();
    }

    
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    
    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    
    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    
    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    
    /**
     * @return the interfaces
     */
    public String getInterfaces() {
        return interfaces;
    }

    
    /**
     * @param interfaces the interfaces to set
     */
    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    
    /**
     * @return the interfaceName
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    
    /**
     * @param interfaceName the interfaceName to set
     */
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    
    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    
    /**
     * @return the cypher
     */
    public String getCypher() {
        return cypher;
    }

    
    /**
     * @param cypher the cypher to set
     */
    public void setCypher(String cypher) {
        this.cypher = cypher;
    }

    
    /**
     * @return the interfaceClass
     */
    public Class<?> getInterfaceClass() {
        return interfaceClass;
    }

    
    /**
     * @param interfaceClass the interfaceClass to set
     */
    public void setInterfaceClass(Class<?> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    
    /**
     * @return the remotionFactory
     */
    public SocketRemotionFactory getRemotionFactory() {
        return remotionFactory;
    }

    
    /**
     * @param remotionFactory the remotionFactory to set
     */
    public void setRemotionFactory(SocketRemotionFactory remotionFactory) {
        this.remotionFactory = remotionFactory;
    }

}



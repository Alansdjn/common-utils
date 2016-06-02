package com.kevin.common.utils.rpc.provider;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.kevin.common.utils.rpc.common.RemoteDataSource;


public class CaishengRemoteSimpleProviderBean implements FactoryBean, InitializingBean {

    private RemoteDataSource remoteDataSource = new RemoteDataSource();  // 远程数据源

    private SocketProvider provider;
    
    public void init() throws Exception {
        this.afterPropertiesSet();
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        remoteDataSource.init();

        provider = new SocketProvider(remoteDataSource);
    }

    @Override
    public Object getObject() throws Exception {
        try {
            provider.provide();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public Class getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }

    
    /**
     * @return the remoteDataSource
     */
    public RemoteDataSource getRemoteDataSource() {
        return remoteDataSource;
    }

    
    /**
     * @param remoteDataSource the remoteDataSource to set
     */
    public void setRemoteDataSource(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    
    /**
     * @return the provider
     */
    public SocketProvider getProvider() {
        return provider;
    }

    
    /**
     * @param provider the provider to set
     */
    public void setProvider(SocketProvider provider) {
        this.provider = provider;
    }

}



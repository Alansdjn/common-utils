package com.kevin.common.utils.rpc.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;


public class CaishengRemoteSimpleConsumerBean implements FactoryBean, InitializingBean {

    private RemoteDataSource remoteDataSource = new RemoteDataSource();  // 远程数据源
    
    @Override
    public void afterPropertiesSet() throws Exception {
        remoteDataSource.init();
    }

    @Override
    public Object getObject() throws Exception {
        return remoteDataSource.getClientObject();
    }

    @Override
    public Class getObjectType() {
        return remoteDataSource.getClientObject().getClass();
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
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

}



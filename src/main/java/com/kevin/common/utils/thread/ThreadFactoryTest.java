package com.kevin.common.utils.thread;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryTest implements ThreadFactory {
    
    private final String poolName;
    
    public ThreadFactoryTest(String poolName){
        this.poolName = poolName;
    }
    /* (non-Javadoc)
     * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
     */
    @Override
    public Thread newThread(Runnable arg0) {
        return null;
    }

}



package com.kevin.common.utils.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();
        
        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    reentrantLock.lock();
                    System.out.println("我要等一个新信号 " + this);
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("拿到信号！！" + this);
                reentrantLock.unlock();
            }
            
        },"waitThread").start();
        
        new Thread(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                reentrantLock.lock();
                System.out.println("我拿到了锁 " + this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                condition.signalAll();
                try {
                    System.out.println("通知所有人，休息1秒钟");
                    Thread.sleep(11000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                System.out.println("休息结束！！" + this);
                reentrantLock.unlock();
            }
            
        }, "signalThread").start();
    }
}



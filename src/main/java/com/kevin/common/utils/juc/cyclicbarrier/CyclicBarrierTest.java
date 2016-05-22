package com.kevin.common.utils.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(4);
        new Thread(new CyclicBarrierRunnable("a", cb)).start();
        new Thread(new CyclicBarrierRunnable("b", cb)).start();
        new Thread(new CyclicBarrierRunnable("c", cb)).start();
        new Thread(new CyclicBarrierRunnable("d", cb)).start();
        Thread.sleep(1000);
        System.out.println(cb.getNumberWaiting());
//        cb.reset();
        System.out.println(cb.getNumberWaiting());
    }
}

class CyclicBarrierRunnable implements Runnable {
    
    private String name;
    private CyclicBarrier cb;
    
    
    public CyclicBarrierRunnable(String name, CyclicBarrier cb){
        this.name = name;
        this.cb = cb;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Thread " + name + " await...");
            cb.await();
        } catch (InterruptedException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}


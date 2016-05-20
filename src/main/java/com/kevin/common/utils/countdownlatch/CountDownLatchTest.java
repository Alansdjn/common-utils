package com.kevin.common.utils.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        
        new Thread(new CountDownLatchRunnable(countDownLatch, "Thread A")).start();
        new Thread(new CountDownLatchRunnable(countDownLatch, "Thread B")).start();
        System.out.println("main begin ...");
        countDownLatch.await();
        System.out.println("main end ...");
    }

}

class CountDownLatchRunnable implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;
    
    public CountDownLatchRunnable(CountDownLatch countDownLatch, String name){
        this.countDownLatch = countDownLatch;
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(name + " count: " + countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println(name + " begin...");
		System.out.println(name + " finished...");
    }
    
}

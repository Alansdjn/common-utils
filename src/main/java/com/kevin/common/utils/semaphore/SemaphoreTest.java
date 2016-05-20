package com.kevin.common.utils.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {

                /* (non-Javadoc)
                 * @see java.lang.Runnable#run()
                 */
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        semaphore.release();
                    } catch (InterruptedException e) {
                        
                    }
                }
            };
            service.execute(run);
        }
        service.shutdown();
    }

}



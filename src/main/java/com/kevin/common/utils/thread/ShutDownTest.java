package com.kevin.common.utils.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            service.submit(new Callable<Void>(){
                
                @Override
                public Void call() throws Exception {
                    System.out.println("sleep 5 seconds");
                    Thread.sleep(5000);
                    System.out.println("after 5 seconds... ");
                    return null;
                }
                
            });
            
            service.shutdown();
            service.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("task interrupted");
        } finally {
            if (!service.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            service.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}



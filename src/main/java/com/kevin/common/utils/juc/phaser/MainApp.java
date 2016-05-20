package com.kevin.common.utils.juc.phaser;

import java.util.concurrent.Phaser;

public class MainApp {
    
    public static void main(String[] args) {
        Phaser first = new Phaser(1);
        Phaser second = new Phaser(1);
        Phaser third = new Phaser(1);
        
        Runnable r1 = new PhaserTest(first, second, "A");
        Runnable r2 = new PhaserTest(second, third, "B");
        Runnable r3 = new PhaserTest(third, first, "C");
        
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();

//        first.arrive();
    }
}

class PhaserTest implements Runnable {

    private Phaser first;
    private Phaser second;
    private String name;
    
    public PhaserTest(Phaser first, Phaser second, String name){
        this.first = first;
        this.second = second;
        this.name = name;
    }
    
    @Override
    public void run() {
        while(true) {
            System.out.println(first.getPhase());
	        System.out.println(first.awaitAdvance(first.getPhase()));
	        System.out.println(name);
//	        first.register();
	        try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	        second.arrive();
        }
    }
    
}

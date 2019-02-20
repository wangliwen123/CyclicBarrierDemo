package com.example.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙*******");
        });
        for (int i = 1; i <=7; i++) {
            final int tempInt = i;
            new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName()+"\t 收集到第"+tempInt+"颗神珠");
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}

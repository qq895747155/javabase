package com.handl.java.demo_18;

import java.util.concurrent.CountDownLatch;

/**
 * Created by handl on 2017/10/22.
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(20);

        new Thread(new BB(latch,1)).start();

        Thread.sleep(1000);
        for (int i = 0; i < 20; i++) {
            new Thread(new AA(latch,i)).start();
        }

    }
}

class AA implements Runnable{

    CountDownLatch latch;
    int i;

    public AA( CountDownLatch latch,int i) {
        this.latch =latch;
        this.i=i;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println("111---"+i);
    }
}

class BB implements Runnable{
    CountDownLatch latch;
    int i;
    public BB( CountDownLatch latch,int i) {
        this.latch =latch;
        this.i=i;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("22222--------"+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

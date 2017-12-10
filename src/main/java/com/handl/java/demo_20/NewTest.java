package com.handl.java.demo_20;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by handl on 2017/10/26.
 */
public class NewTest {
    private static volatile long _longVal = 0;
    private final static Object obj = new Object();

    private static class LoopVolatile implements Runnable {
        public void run() {
            synchronized (obj){
                long val = 0;
                while (val < 10000000) {
                    _longVal++;
                    val++;
                }
            }
        }
    }

    private static class LoopVolatile2 implements Runnable {
        public void run() {
            synchronized (obj) {
                long val = 0;
                while (val < 10000000) {
                    _longVal++;
                    val++;
                }
            }
        }
    }

    private  void testVolatile(){
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile2());
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);
    }

    public static void main(String[] args) {
       new NewTest().testVolatile();

    }
}

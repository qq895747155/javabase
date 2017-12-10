package com.handl.java.demo_20;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by handl on 2017/10/22.
 */
public class ThreadPool implements Serializable{
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(20);

    public synchronized void add(int i){
        boolean b = queue.offer(i);
        if (!b){
            try {
                notifyAll();
                wait();
                queue.offer(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void read(){
        Integer i = queue.poll();
        if ( i == null ){
            notifyAll();
        }else {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndSet(5);

        ThreadPool threadPool = new ThreadPool();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 99; i++) {
                    threadPool.add(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    threadPool.read();
                }
            }
        }).start();

    }
}


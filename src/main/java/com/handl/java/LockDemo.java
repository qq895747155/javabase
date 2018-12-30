package com.handl.java;

/**
 * Created by handl on 2018/5/25.
 */
public class LockDemo implements Runnable {

    boolean b = false;

    private synchronized void get() throws InterruptedException {
        while (!b){
            System.out.println("进入等待了。。。");
            this.wait();
        }
        System.out.println("等待结束。。。。。。");
    }


    private synchronized void put(){
        if (!b)
            b = true;
        this.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();

        new Thread(lockDemo).start();
        System.out.println("等待5秒。。。。。");
        Thread.sleep(5000);
        System.out.println("开始唤醒。。。");
        lockDemo.put();

    }

    @Override
    public void run() {
        try {
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.handl.java.demo_18;

/**
 * Created by handl on 2017/10/21.
 */
public class Test {

    public static void main(String[] args) {

        A a = new A();

        for (int i = 0; i < 1000; i++) {
            new Thread(a).start();
        }
    }
}

class A implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+",,,,,,hahahahahaha");
    }
}

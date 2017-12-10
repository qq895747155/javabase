package com.handl.java.demo_11;

/**
 * Created by handl on 2017/10/11.
 */
public class ThreadClass {


    public static void test(Test test){
        test.setI(test.getI()+1);
    }
    public synchronized static void test2(Test test){
        test.setI(0);
    }

    public static void main(String[] args) {
        final Test test = new Test();
        boolean flag = false;
           final boolean finalFlag = true;
           for (int i=0;i<2;i++){
               new Thread(
                       new Runnable() {
                           public void run() {
                               while (finalFlag){
                                   test(test);
                                   System.out.println(Thread.currentThread()+","+test.getI());
                               }
                           }
                       }
               ).start();
           }

        while (true){
        }

    }

}

class Test{
    private volatile int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

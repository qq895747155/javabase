package com.handl.java.demo_17;

import java.util.concurrent.*;

/**
 * Created by handl on 2017/10/21.
 */
public class JdkFutureTest {
    public static void main(String[] args) {

        //线程管理器
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //通过sumbit执行可以回去到线程执行结果，就是Future
        Future<JdkFutureTest> future = executorService.submit(new Callable<JdkFutureTest>() {

            public JdkFutureTest call() throws Exception {
                return null;
            }
        });

        //获取真实结果
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

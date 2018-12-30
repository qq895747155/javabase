package com.handl.java;

import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by handl on 2018/5/20.
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(1);
        executors.submit(new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        }));
        executors.shutdown();

        BlockingDeque queue = new LinkedBlockingDeque();
//        queue.offer()o
        List<String > list = new Vector<>(5);
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        System.out.println(list.size());
        list.forEach(s -> System.out.println(s));

//        CopyOnWriteArrayList
//        ConcurrentHashMap
    }
}

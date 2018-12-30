package com.handl.java.java8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {
    private static final int THREAD_HOLD = 2; //限定分割任务大小
    private int start,end;
    public CountTask(int start,int end){
        this.start = start; this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;

        if((end - start) <= THREAD_HOLD){////如果任务足够小就计算
            for(int i=start;i<=end;i++)
                sum += i;
        }else{
            int middle = (start + end) / 2;
            CountTask left = new CountTask(start,middle);
            CountTask right = new CountTask(middle+1,end);
            left.fork();//执行子任务
            right.fork();//执行子任务
            int lResult = left.join();//获取子任务结果
            int rResult = right.join();//获取子任务结果
            sum = lResult + rResult;
        }
        return sum;
    }
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool(); //使用ForkJoinPool来调用任务
        CountTask task = new CountTask(1,4);
        Future<Integer> result = pool.submit(task);//使用ForkJoinPool来调用任务
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
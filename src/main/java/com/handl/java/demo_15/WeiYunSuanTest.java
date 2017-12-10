package com.handl.java.demo_15;

/**
 * Created by handl on 2017/10/21.
 */
public class WeiYunSuanTest {

    public static void main(String[] args) {
//        System.out.println( 4 >> 1);  //2
//        System.out.println( 4 >> 2);  //1
//        System.out.println( 8 >> 2);  //2
//        System.out.println( 4 << 1);  //8
//        System.out.println( 4 << 2);  //16
//        System.out.println( 4 << 2 >> 3);  //2

        long l1 = System.currentTimeMillis();
        for (int i=0;i<999999;i++)
            add(10,10);
        System.out.println(System.currentTimeMillis()-l1);

        long l2 = System.currentTimeMillis();
        for (int i=0;i<999999;i++)
            add2(10,10);
        System.out.println(System.currentTimeMillis()-l2);

    }

    static int add(int a, int b) //递归形式
    {
        if(b==0) //递归结束条件：如果右加数为0，即不再有进位了，则结束。
            return a;
        int s = a^b;
        int c = (a&b)<<1; //进位左移1位，达到进位的目的。
        return add(s, c); //再把'和'和'进位'相加。递归实现。
    }

    static int add2(int a, int b) //递归形式
    {
        return a+b;
    }
}

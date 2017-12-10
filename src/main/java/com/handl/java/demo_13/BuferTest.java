package com.handl.java.demo_13;

import java.nio.ByteBuffer;

/**
 * Created by handl on 2017/10/19.
 */
public class BuferTest {

    public static void main(String[] args) {
        ByteBuffer b = ByteBuffer.allocate(20); //设置缓冲大小为20

        System.out.println("初始化："+b.position()+","+b.limit()+","+b.capacity());

        //写入输入到缓冲,写10个 此时位置是10 ，容量和上限是20
        for (int i=0;i<10;i++)
            b.put((byte) i);

        System.out.println("写入之后："+b.position()+","+b.limit()+","+b.capacity());

        //切换模式
        b.flip();
        System.out.println("切换读模式后："+b.position()+","+b.limit()+","+b.capacity());

        //开始读取数据，读取5个
        for (int i=0;i<5;i++)
            System.out.println(b.get());

        System.out.println("读取之后："+b.position()+","+b.limit()+","+b.capacity());

        //读完后切换
        b.compact();//将未读的缓冲区数据移动至缓冲区头部，位置设置为未读数据的下一位
        System.out.println("切换写模式后："+b.position()+","+b.limit()+","+b.capacity());

        //再次写入
        for (int i=0;i<5;i++)
            b.put((byte) i);
        System.out.println("写入之后："+b.position()+","+b.limit()+","+b.capacity());

        //写入后再次切换
//        b.flip();
        b.rewind();
        System.out.println("切换模式后："+b.position()+","+b.limit()+","+b.capacity());

        for (int i=0;i<10;i++)
            System.out.println(b.get());
        System.out.println("读取后："+b.position()+","+b.limit()+","+b.capacity());
        //清除缓冲后
        b.rewind();
        System.out.println("读取准备："+b.position()+","+b.limit()+","+b.capacity());

        //清除缓冲后
        b.clear();
        System.out.println("清除后："+b.position()+","+b.limit()+","+b.capacity());
    }
}

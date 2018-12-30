package com.handl.java;

import java.nio.ByteBuffer;

/**
 * Created by handl on 2018/5/19.
 */
public class NIOTest {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        System.out.println("position="+byteBuffer.position()+",capacity="+byteBuffer.capacity()+",limit="+byteBuffer.limit());

        for (int i = 0; i < 5; i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("position="+byteBuffer.position()+",capacity="+byteBuffer.capacity()+",limit="+byteBuffer.limit());

        byteBuffer.flip();

        System.out.println("position="+byteBuffer.position()+",capacity="+byteBuffer.capacity()+",limit="+byteBuffer.limit());

        byte b1 = byteBuffer.get();
        System.out.println("b1="+b1);

        byte b2 = byteBuffer.get();
        System.out.println("b1="+b2);
        System.out.println("position="+byteBuffer.position()+",capacity="+byteBuffer.capacity()+",limit="+byteBuffer.limit());

        byteBuffer.mark();

        byteBuffer.reset();
        byteBuffer.put((byte) 1);
    }
}

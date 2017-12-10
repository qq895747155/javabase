package com.handl.java.demo_10;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Created by handl on 2017/10/6.
 */
public class IoTest {
    public static void main(String[] args) {
        OutputStream outputStream;
        Writer writer;
        FilterInputStream filterInputStream;
        System.out.println();
        DataInputStream dataInputStream = new DataInputStream(
                new ByteArrayInputStream(new byte[10])
        );
        BufferedReader bufferedReader;
        PrintWriter printWriter;
        BufferedReader bufferedReader1;
        StringReader stringReader;
        ByteBuffer byteBuffer;
    }
}

package com.handl.java;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.function.Predicate;

/**
 * Created by handl on 2018/5/18.
 */
public class FileTest {
    public static void main(java.lang.String[] args) throws IOException {
        File file = new File("D:\\192.txt");
        File file2 = new File("D:\\20.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file2);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        byte[] b = new byte[1024*1000];
        while (inputStream.read(b) > 0){

            String s = new String(b);
            byte [] bbb = s.getBytes("ISO-8859-1");
//           outputStream.write(bbb);
            bufferedWriter.write(new String(bbb,"GB2312"));
            

        }
    }

//    public static void main(java.lang.String[] args) throws IOException {
//        File file = new File("D:\\192.txt");
//        File file2 = new File("D:\\20.txt");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
//        String s = "";
//        while ((s = bufferedReader.readLine()) != null){
//            byte[] bytes =s.getBytes("ISO-8859-1");
//            String s2 = new String(bytes,"GB2312");
//            bufferedWriter.write(s2);
//        }
//    }
}

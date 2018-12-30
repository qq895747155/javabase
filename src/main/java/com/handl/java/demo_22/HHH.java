package com.handl.java.demo_22;

import java.io.UnsupportedEncodingException;

/**
 * Created by handl on 2018/5/18.
 */
public class HHH {

    public static void main(String[] args) {
        try {
           byte[] bytes = "19ËêÐ¡0×îÜ³Ë¬µÄÒ»´Î".getBytes("ISO-8859-1");
           String s = new String(bytes,"GBK");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

package com.handl.java.demo_21;

/**
 * Created by handl on 2017/11/16.
 */
public class AAA {

    Long l;

    public AAA(Long l) {
        this.l = l;
    }

    public static void main(String[] args) {
        AAA a,b,c;
        a= new AAA(21L);
        b= new AAA(21L);
        c =b;
        System.out.println(a.equals(b));
        System.out.println(b != c);
        System.out.println();
        System.out.println();

    }
}

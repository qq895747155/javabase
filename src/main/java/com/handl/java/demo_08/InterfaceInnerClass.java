package com.handl.java.demo_08;

/**
 * Created by handl on 2017/10/4.
 */
public interface InterfaceInnerClass {
    void say();

    class Test implements InterfaceInnerClass{
        public static String str="iiii";
        public String str2 = "2222";
        public void say() {
            System.out.println("hahaha");
        }

        public static void main(String[] args) {
            System.out.println( Test.str);
            new Test().say();
            System.out.println(new Test().str2);
        }
    }

}

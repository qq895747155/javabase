package com.handl.java.demo_02;

/**
 * Created by handl on 2017/10/1.
 */
public class Test {

    private int i1;

    public Test(int i1) {
        System.out.println("this="+this);
        test();
        System.out.println("this="+this);
        this.i1 = i1;
        test();
    }

    public void test(){
        int i2;
        System.out.println("i1==="+this.i1);  //类的基本属性按照类型默认初始化
//        System.out.println("i2==="+i2);  局部的基本类型属性必须要初始化
    }

    public static void main(String[] args) {
        //测试类构造器中调用其它方法，类的实例化是否已经完成
        new Test(1199);
    }

}

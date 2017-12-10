package com.handl.java.demo_01;

/**
 * Created by handl on 2017/10/1.
 */
public class Test {

    public void setNameZi(){
        //this.name 子类不能直接使用父类的私有属性
    }

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.setName("hahah");  //只能调用父类的公开方法使用
        zi.getName();
    }
}

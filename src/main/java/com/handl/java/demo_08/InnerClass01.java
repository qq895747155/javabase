package com.handl.java.demo_08;

/**
 * Created by handl on 2017/10/4.
 */
public class InnerClass01 {  //外部类

    private int i=5;

    private static String name = "hahahah";

    void say(){
        System.out.println("1");
    }
    //这是一个私有的非静态的内部类
    private class InnerClass{   //内部类

        public InnerClass01 getOutherClass(){
            //内部类中直接使用外部类属性
            System.out.println("i="+i);
            //外部类.this代表外部类对象引用，在内部内中使用外部类时这样获取
            return InnerClass01.this;
        }
    }
    //静态内部类
    public static class InnerClassB{
        public void staticClassSay(){
            System.out.println(name);
        }
    }

    public InnerClass getInner(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        InnerClass01 outherClass = new InnerClass01();
        //通过外部类方法获取内部类
        InnerClass01.InnerClass innerClass = outherClass.getInner();
        innerClass.getOutherClass();
        //在其他类中获取内部类
        InnerClass01.InnerClass innerClass1 = new InnerClass01().new InnerClass();


        //静态内部类,创建不需要依赖外部类
        InnerClassB innerClassB = new InnerClassB();
        innerClassB.staticClassSay();

    }

}

package com.handl.java.java8;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

/**
 * Created by handl on 2018/6/1.
 */
public class 分离方法行为 {

    public static void main(String[] args) {
        //准备数据
        Apple apple1 = new Apple("绿色",80);
        Apple apple2 = new Apple("绿色",120);
        Apple apple3 = new Apple("红色",140);
        Apple apple4 = new Apple("绿色",20);
        Apple apple5 = new Apple("红色",60);
        Apple apple6 = new Apple("绿色",150);
        List<Apple> list = new ArrayList<>();
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        list.add(apple4);
        list.add(apple5);
        list.add(apple6);

        //关键实现
        分离方法行为 f = new 分离方法行为();
//        f.cate(list,Apple::filterCl).forEach(a -> System.out.println(a.getCl()));
        //方法引用::的前面代指方法所在的类型，后面代指方法名称
        f.cate(list,Apple2 :: filterCl).forEach(a -> System.out.println(a.getCl()));

//方法引用 1：静态方法
        Function<String,Integer> function = Integer::parseInt;

        Integer ll = function.apply("12345");
        System.out.println(ll);
        Apple apple = get(Apple :: new);


    }

    public static  <T> T get(Supplier<T> supplier){
        return supplier.get();
    }

    //抽离公共部分
    public List<Apple> cate(List<Apple> apples,Predicate<Apple> predicate){
        List<Apple> apples1 = new ArrayList<>();
        for (Apple apple : apples){
            //重点，体现方法传递的用处
            if (predicate.test(apple)){
                apples1.add(apple);
            }
        }
        return apples1;
    }

}


class Apple2{
    //比较颜色
    public static boolean filterCl(Apple apple){
        return apple.getCl().equals("绿色");
    }
}

//创建为谓词
interface Predicate<T>{
    public boolean test(T t);

}


//比较对象
class Apple{
    private String cl;
    private Integer wi;

    //比较颜色
    public static boolean filterCl(Apple apple){
        return apple.getCl().equals("绿色");
    }
    //比较重量
    public boolean filterWi(Apple apple){
        return apple.getWi() > 100;
    }

    public Apple() {
    }

    public Apple(String cl, Integer wi) {
        this.cl = cl;
        this.wi = wi;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public Integer getWi() {
        return wi;
    }

    public void setWi(Integer wi) {
        this.wi = wi;
    }
}

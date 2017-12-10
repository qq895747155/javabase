package com.handl.java.demo_21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by handl on 2017/11/13.
 */
public class LambdaTest {

    public static void main(String[] args) {
//        TestLambdaTest i = (x,y) -> x + y;
//        System.out.println(i.add(4,5));

        List<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        Stream<Integer> a = list.stream();
//        Stream<Double> aa = a.map(p -> p);
//        list.stream().mapToInt(e -> e.hashCode()).reduce()
        int sum = list.stream()
                .mapToInt(e -> e)
                .reduce(0 , (x, y) -> x + y);
        System.out.println("sum==="+sum);

    }
}

interface TestLambdaTest{
    int add(int x,int y);
}

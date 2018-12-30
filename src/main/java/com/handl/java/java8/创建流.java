package com.handl.java.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by handl on 2018/6/12.
 */
public class 创建流 {

    public static void main(String[] args) {
        //1数值创建流
        Stream.of("aa","bb");
        //2数组创建流
        int[] numbers = {324,52,34,13,456,3,21,46};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
        //3文件创建流
        try(Stream<String> lines = Files.lines(
                Paths.get("data.txt"), Charset.defaultCharset()
        )){
            long count = lines.flatMap(s -> Arrays.stream(s.split(" "))).distinct().count();

        }catch (IOException e){

        }


    }
}

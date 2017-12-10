package com.handl.java.demo_10;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by handl on 2017/10/6.
 */
public class FileTest {

    public static void main(String[] args) {
        //"."指的是项目的根目录也就是D:\javabase
        File file = new File(".");
        String regex;
        final String finalRegex = "pom.xml";
        String[] files = file.list(new FilenameFilter() {//匿名内部类方式的文件过滤器
            private Pattern pattern = Pattern.compile(finalRegex);
            //将为dir目录下的所有文件调用此方法，name是文件名
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        if (files == null){
            System.out.println("nullllll");
            System.exit(0);
        }
        else
            System.out.println("not nullllll");
        for (String s :files)
            System.out.println(s);
    }
}

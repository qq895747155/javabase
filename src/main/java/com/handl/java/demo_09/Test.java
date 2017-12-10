package com.handl.java.demo_09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handl on 2017/10/5.
 */
public class Test {
    static Map<String,?> map;
    public static Map<String,?> getStringMap(){
        return map = new HashMap<String, String>();
    }
    public static Map<String,?> getIntegerMap(){
        return map = new HashMap<String, Integer>();
    }
    public static void main(String[] args) {

    }
}

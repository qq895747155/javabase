package com.handl.java.demo_03;

import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.util.*;

/**
 * Created by handl on 2017/10/1.
 */
public class Test{
    public static <T> List<T> list(){
        return new ArrayList<T>();
    }

    public static <T> void say(T t){
        System.out.println(t.getClass().getName());
    }

    public static <T> void say2(List<T> a){
        System.out.println(a.getClass().getName());
    }

/*    public static void main(String[] args) {
//        SoftReference softReference
//        System.out.println(list().getClass().getName());
//        say(list());
//        say2(list());

        Hashtable hashtable = new Hashtable();
//        hashtable.put(null,"111");
//        System.out.println("table=="+hashtable.get(null));
        HashMap hashMap = new HashMap();
        hashMap.put(null,"111");
        System.out.println("map=="+hashMap.get(null));
    }*/

    public static void main(String[] args) {
//        long l1 = System.currentTimeMillis();
//        String s = null;
//        for (int i=0;i<59999;i++)
//            s+="1";
//        System.out.println(System.currentTimeMillis() - l1);

//        long l2 = System.currentTimeMillis();
//        StringBuffer sb = new StringBuffer(256);
//        for (int i=0;i<59999;i++)
//            sb.append(i);
//        System.out.println(System.currentTimeMillis()-l2);

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        for (int i=0;i<9999999;i++){
            list1.add(i);
            list2.add(i);
        }
        long l1 = System.currentTimeMillis();
        list1.add(list1.size()>>1,6);
        System.out.println(System.currentTimeMillis() - l1);

        long l2 = System.currentTimeMillis();
        list1.remove(list1.size()>>1);
        System.out.println(System.currentTimeMillis() - l2);

        long l3 = System.currentTimeMillis();
        list2.add(list2.size()>>1,6);
        System.out.println(System.currentTimeMillis() - l3);

        long l4 = System.currentTimeMillis();
        list2.remove(list2.size()>>1);
        System.out.println(System.currentTimeMillis() - l4);

    }

}


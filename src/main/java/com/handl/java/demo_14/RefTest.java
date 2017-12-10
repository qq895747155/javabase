package com.handl.java.demo_14;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by handl on 2017/10/20.
 */
public class RefTest {

    @Override
    public String toString() {
        return "soft ref...";
    }


    public static void main(String[] args) {
        //创建强引用
        RefTest test = new RefTest();

        //创建引用队列
        ReferenceQueue<RefTest> queue = new ReferenceQueue<RefTest>();
        //创建软引用,参数软引用对象和回收队列
//        SoftReference<RefTest> softReference = new SoftReference<RefTest>(test,queue);
        WeakReference<RefTest> softReference = new WeakReference<RefTest>(test,queue);

        //强引用置为软引用
        test = null;
        int i=0;
        List<RefTest[]> list = new ArrayList<RefTest[]>();
        while (true){
            RefTest refTest2 = softReference.get();
            if (refTest2!= null)
                System.out.println(refTest2.toString()+",,,,,i="+i);
            else{
                System.out.println("ok");
                //从引用队列获取对象
                try {
                    refTest2 = queue.remove().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1111,"+ refTest2);
                break;
            }
            list.add(new RefTest[]{new RefTest()});
            i++;
            //gc回收
//            System.gc();
        }

    }

}

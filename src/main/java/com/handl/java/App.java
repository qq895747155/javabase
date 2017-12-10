package com.handl.java;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    private int i;
    public static void main( String[] args ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String str = "jxeqFXJFZAPVyhoI&imei=289dff07669d7a23de0ef88d2f7129e7&conv_time=1509342407249";
//
//        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        md5.update((str).getBytes("UTF-8"));
//        byte b[] = md5.digest();
//
//        int i;
//        StringBuffer buf = new StringBuffer("");
//
//        for(int offset=0; offset<b.length; offset++){
//            i = b[offset];
//            if(i<0){
//                i+=256;
//            }
//            if(i<16){
//                buf.append("0");
//            }
//            buf.append(Integer.toHexString(i));
//        }
//
//        String s = buf.toString();
//        System.out.println("result = " + s);

        System.out.println("md5:"+getMD5(str));
        System.out.println("length:"+getMD5(str).length());

    }


    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return fillMD5(md5);
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }


    public static String fillMD5(String md5){
        return md5.length()==32?md5:fillMD5("0"+md5);
    }
}

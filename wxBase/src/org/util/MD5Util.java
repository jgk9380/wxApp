package org.util;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;

public class MD5Util {
    public final static String encodeMD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','f','g'};       
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args)  {
        System.out.println(MD5Util.encodeMD5("182325"));
       // = c89add2f305d3c392b3124ecd096c34a
        String info="1565155434115651554341*广宽1c89add2f305d3c392b3124ecd096c34a";

        try {
            System.out.println(MD5Util.encodeMD5(new String(info.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //= aa0a2b775cb0d5854ee1dfc633c08cd5
        System.out.println(MD5Util.encodeMD5("15651554341156515543411c89add2f305d3c392b3124ecd096c34a"));
//        754ee769215fc6cc2e001cc18183f736

    }
}


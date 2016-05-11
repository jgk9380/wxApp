// Decompiled by Jad v1.5.7f. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MD5.java

package org.util.smsone.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{

    public MD5()
    {
    }

    public static String md5(byte b[])
        throws NoSuchAlgorithmException
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(b, 0, b.length);
        return byteArrayToHexString(md5.digest());
    }

    public static byte[] md5(String data)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
 
       return md5.digest(data.getBytes("UTF-8"));
//        byte b[] = data.getBytes("UTF8");
//        md5.update(b, 0, b.length);
//        return byteArrayToHexString(md5.digest());
    }
    
    public static String Md5(String plainText) {
        try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                        i = b[offset];
                        if (i < 0)
                        i += 256;
                        if (i < 16)
                        buf.append("0");
                        buf.append(Integer.toHexString(i));
                }
//                System.out.println("result: " + buf.toString());// 32位的加密
        return buf.toString().substring(8, 24);// 16位的加密
    } catch (NoSuchAlgorithmException e) {
                 e.printStackTrace();
    }
    return "";
}

    private static String byteArrayToHexString(byte b[])
    {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < b.length; i++)
            sb.append(byteToHexString(b[i]));

        return sb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if(n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static String hexDigits[] = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "a", "b", "c", "d", "e", "f"
    };

}

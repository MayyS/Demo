package edu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    private static String[] strArray={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String md5(String password){
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("md5");
            byte[]bytes=messageDigest.digest(password.getBytes());
            StringBuffer sb=new StringBuffer();
            for(byte b:bytes){
                sb.append(binToHex(b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String binToHex(byte num){
        int targetNum=0;
        targetNum=num<0?num+256:num;
        int fir=targetNum/16;
        int sec=targetNum%16;
        return strArray[fir]+strArray[sec];
    }
}

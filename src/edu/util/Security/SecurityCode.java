package edu.util.Security;

import java.util.Arrays;

public class SecurityCode {
     public enum SecurityCodeLevel{Simple,Medium,Hard};

     public static String getSecurityCode(){
         return getSecurityCode(4,SecurityCodeLevel.Medium,false);
     }

     public static String getSecurityCode(int lenght,SecurityCodeLevel level,boolean isCanRepea){
         int len=lenght;
         char[] codes=new char[61];
         for (int i=0; i<9; i++){
             codes[i]=(char)('0'+i+1);
         }
         for (int i=0; i<26; i++){
             codes[9+i]=(char)('a'+i);
             codes[35+i]=(char)('A'+i);
         }

         if(level==SecurityCodeLevel.Simple){
             codes= Arrays.copyOfRange(codes,0,9);
         }
         else if (level==SecurityCodeLevel.Medium){
             codes=Arrays.copyOfRange(codes,0,34);
         }

         int n=codes.length;
         char []result=new char[len];

         if(isCanRepea){
             for (int i=0; i<len; i++){
                 int res=(int)(Math.random()*n);
                 result[i]=codes[res];
             }
         }
         else{
             for (int i=0; i<len; i++){
                 int res=(int)(Math.random()*n);
                 result[i]=codes[res];
                 codes[res]=codes[n-1];
                 n--;
             }
         }

         return String.valueOf(result);
     }

}

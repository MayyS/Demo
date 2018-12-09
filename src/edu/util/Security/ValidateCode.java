package edu.util.Security;

public class ValidateCode {
    public static String getValidateCode(){
        int len=6;
        char[] codes=new char[10];
        char[] result=new char[len];
        for (int i=0; i<10; i++){
            codes[i]=(char)('0'+i);
            System.out.print(codes[i]);
        }
        System.out.println();
        for (int i=0; i<len; i++){
            int res=(int)(Math.random()*10);
            result[i]=codes[res];
        }
        return String.valueOf(result);
    }
}

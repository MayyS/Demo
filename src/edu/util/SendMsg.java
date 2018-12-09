package edu.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class SendMsg {

    private final String url1="http://gbk.api.smschinese.cn";
    private static final String uid;
    private static final String pwd;

    static {
        uid="酱汁酱汁";
        pwd="d41d8cd98f00b204e980";
    }

    private PostMethod getPost(){
        PostMethod postMethod=new PostMethod(url1);
        postMethod.addRequestHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=gbk");
        return postMethod;
    }

    private HttpClient getClient(){
        return new HttpClient();
    }
    public void sentMsg(String phoneNumber,String text) throws IOException {
        PostMethod postMethod=getPost();
        String txt="验证码:"+text;
        System.out.println(txt);
        NameValuePair []datas={
                new NameValuePair("Uid",uid),new NameValuePair("Key",pwd),
                new NameValuePair("smsMob",phoneNumber),new NameValuePair("smsText",txt)
        };
        postMethod.setRequestBody(datas);
        HttpClient httpClient=getClient();
        httpClient.executeMethod(postMethod);
        Header[] headers=postMethod.getRequestHeaders();
        int statusCode=postMethod.getStatusCode();
        System.out.println("statusCode ="+statusCode);
        for (Header header: headers){
            System.out.println(header.toString());
        }
        String result=new String(postMethod.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result);
        postMethod.releaseConnection();
    }
}

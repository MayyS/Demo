package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.util.Security.ValidateCode;
import edu.util.SendMsg;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ValidateAction extends ActionSupport implements SessionAware, RequestAware {
    private Map<String,Object> session;
    private Map<String,Object> request;
    private String valCode;
    private String phone;
    private SendMsg sendMsg=new SendMsg();

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request=map;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void sendValidateCode() throws IOException {
        String validateCode= ValidateCode.getValidateCode();
        sendMsg.sentMsg(phone,validateCode);
        session.put("validateCode",validateCode);
        System.out.println(phone+" : "+validateCode);
        getPrintWrite().print("send successfully!");
    }

    private PrintWriter getPrintWrite() throws IOException{
        HttpServletResponse response= (HttpServletResponse) request.get(ServletActionContext.HTTP_RESPONSE);
        response.setContentType("text/html;charset=utf-8");
        return response.getWriter();
    }

    public void checkValidateCode() throws IOException {
        String rgt= (String) session.get("validateCode");
        if(valCode.equals(rgt)){
            System.out.println("OK");
            getPrintWrite().print(true);
        }else{
            getPrintWrite().print(false);
            System.out.println("validateCode:"+rgt+"   "+"yourcode: "+valCode);
        }
    }

}

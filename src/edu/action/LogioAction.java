package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.business.common.Cart;
import edu.entity.User;
import edu.service.UserService;
import edu.service.impl.UserSeriveImpl;
import edu.util.Md5Utils;
import org.apache.struts2.ServletActionContext;

public class LogioAction  extends ActionSupport {
    private String account;
    private String password;
    private String scode;

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private UserService userService=new UserSeriveImpl();


    private boolean checkScode(){

        String rigthCode=(String)ActionContext.getContext().getSession().get("securityCode");
//        System.out.println(rigthCode+"       "+scode);
        return rigthCode.equals(getScode());
    }

    public String login(){
        User user=new User();
        user.setAccount(account);
        user.setPassword(Md5Utils.md5(password));
        ActionContext actionContext=ActionContext.getContext();
        User loginuser=userService.checkIn(user);
        if(!checkScode()){
            actionContext.put("msg","wrong");
            addActionMessage(getText("login.scode"));
            return "login";
        }
        else if(loginuser!=null) {
            actionContext.getSession().put("user",loginuser);
            actionContext.put("msg","ok");
            actionContext.getSession().put("cart",new Cart());
            return SUCCESS;
        }
        else{
            actionContext.put("msg","wrong");
            addActionMessage(getText("login.error"));
            return "login";
        }
    }

    public String logout(){
        ActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }
    public void validateLogin(){
        if("".equals(account)||"".equals(password)) {
            ActionContext.getContext().put("msg", "wrong");
            clearErrorsAndMessages();
            addActionError(getText("login.error.empty"));
        }
        else{
            login();
        }
    }
}

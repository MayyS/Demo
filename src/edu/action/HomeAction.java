package edu.action;

import com.opensymphony.xwork2.ActionContext;

public class HomeAction {

    private String fg_account;

    public String getFg_account() {
        return fg_account;
    }

    public void setFg_account(String fg_account) {
        this.fg_account = fg_account;
    }

    public  String moviePage(){
        ActionContext.getContext().put("msg","is ok");
        return "moviePage";
    }
    public String myIndex(){
        return "myIndex";
    }
    public String homePage(){
        return "homePage";
    }
    public  String bookPage() { return "bookPage";}
    public String registerPage(){
        return "registerPage";
    }
    public String forget(){
        return "forget";
    }
    public String changePwd(){
        System.out.println("changPwd="+fg_account);
        return "changePwd";
    }
}

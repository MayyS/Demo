package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.base.action.BaseAction;
import edu.business.common.Orders;
import edu.entity.PageResult;
import edu.entity.User;
import edu.service.UserService;
import edu.service.impl.UserSeriveImpl;
import edu.util.Md5Utils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UserAction extends BaseAction implements ModelDriven<User> {
    private User user=new User();

    private UserService userService=new UserSeriveImpl();
    @Override
    public User getModel() {
        return user;
    }

    public String register(){
        int i=userService.save(getModel());
        if(i==-1) {
            addFieldError("account",getText("register.error.account_exist"));
            System.out.println("NO");
            return INPUT;
        }
        System.out.println("ok");
        return "registerSuccess";
    }

    public void addMovie(){

    }
    public void rmMovie(){

    }

    public String myOders(){
        user=(User)ActionContext.getContext().getSession().get("user");
        List<Orders>orders=new ArrayList<>();
        for(Orders ord:user.getOderss()){
            orders.add(ord);
        }
        pageResult=new PageResult(orders.size(),getPageNo(),getPageSize(),orders);
        return "myOders";
    }

    public String changePwd(){
        String userPassword=user.getPassword();
        String userAccount=user.getAccount();
        Criterion criterion= Restrictions.eq("account",userAccount);
        user=userService.findUser(criterion);
        user.setPassword(Md5Utils.md5(userPassword));
        System.out.println(user.toString());
        userService.update(user);
        return "changeSuccess";
    }
}

package edu.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext actionContext=actionInvocation.getInvocationContext();
        Object user=actionContext.getSession().get("user");
        if(user!=null){
            return actionInvocation.invoke();
        }else{
            actionContext.put("msg","wrong");
            actionContext.put("Tips","login first");
            return "login";
        }
    }
}

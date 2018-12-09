package edu.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.util.Security.SecurityCode;
import edu.util.Security.SecurityImage;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import java.io.ByteArrayInputStream;
import java.util.Map;


@ParentPackage("struts-default")
@Namespace("/")

@Results({
        @Result(name = "success",type = "stream",params = {
                "contentType","image/jpeg",
                "inputName","imageStream",
                "bufferSize","4096"
        })
})

public class SecurityAction extends ActionSupport implements SessionAware {

    private ByteArrayInputStream imageStream;
    private Map<String,Object>session;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Action("imageCode")
    public String execute()throws Exception{
        String securityCode= SecurityCode.getSecurityCode();
        imageStream= SecurityImage.getImageAsInputStream(securityCode);
        session.put("securityCode",securityCode);
        return SUCCESS;
    }
}

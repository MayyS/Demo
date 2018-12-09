package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import java.io.File;
import java.io.IOException;

public class FileUploadAction extends ActionSupport {
    private File file;
    private String fileFileName;
    private String fileContentType;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String moviePhoto(){

        String uploadPath= ServletActionContext.getServletContext().getRealPath("/upload");
        String uploadPath2="/Users/SW/Desktop/Demo/web/upload";
        uploadPath=uploadPath2;

        System.out.println(uploadPath);
        if(file!=null) {
            if(this.getFileContentType().equals("image/jpeg")){
                name=name+".jpg";
            }else{
                name=name+".png";
            }
            File savFile = new File(uploadPath, name);

            try {
                FileUtils.copyFile(file,savFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("YES"+" "+this.getFileFileName()+" "+this.getFileContentType());
            System.out.println("yes"+" "+name);
            return SUCCESS;
        }
        else{
            System.out.println("NO");
            return INPUT;
        }
    }

}

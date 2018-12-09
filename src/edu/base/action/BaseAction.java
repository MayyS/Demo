package edu.base.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.entity.PageResult;

public class BaseAction extends ActionSupport {
    private Integer pageNo=1;
    private Integer pageSize=100;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageResult pageResult;

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }
}

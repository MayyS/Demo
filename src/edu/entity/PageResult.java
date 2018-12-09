package edu.entity;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
    private long totalCount;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private List items;

    public PageResult(long totalCount, int pageNo, int pageSize, List items) {
        super();
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.items = items==null?new ArrayList<>():items;
        if(totalCount>0){
            this.pageNo=pageNo;
            int page=(int)(totalCount/pageSize);
            page+=totalCount%pageSize==0?0:1;
            this.totalPage=page;
        }else{
            this.pageNo=0;
            this.totalPage=0;
        }
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}

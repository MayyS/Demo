package edu.business.bookstore;

import edu.base.action.BaseAction;
import edu.business.bookstore.service.BookService;
import edu.business.bookstore.service.impl.BookServiceImpl;

public class BookAction extends BaseAction {

    private  String val;
    private  String attr;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    BookService bookService=new BookServiceImpl();
    public String bookList(){
        String hql="from Book";
        pageResult=bookService.findObject(hql,getPageNo(),getPageSize());
        return "bookList";
    }
    public String search(){
        pageResult=bookService.searchObject(getAttr(),getVal(),1,getPageSize());
        return "bookList";
    }

}

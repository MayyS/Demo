package edu.business.bookstore.service.impl;

import edu.business.bookstore.dao.BookDao;
import edu.business.bookstore.dao.impl.BookDaoImpl;
import edu.business.bookstore.entity.Book;
import edu.business.bookstore.service.BookService;
import edu.entity.PageResult;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public List<Book> findObject(String hql) {
        return bookDao.findObject(hql);
    }

    @Override
    public int save(Book entity) {
        return bookDao.save(entity);
    }

    @Override
    public void update(Book entity) {
        bookDao.update(entity);
    }

    @Override
    public void delete(Book entity) {
        bookDao.delete(entity);
    }

    @Override
    public PageResult findObject(String hql, Integer pageNo, Integer pageSize) {
        List<Book>books=bookDao.findObject(hql,pageNo,pageSize);
        Long totalCount=bookDao.findTotalCount();
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,books);
        return pageResult;
    }

    @Override
    public PageResult searchObject(String attr, String val, Integer pageNo, Integer pageSize) {
        List<Book>books=bookDao.searchObject(attr,val,pageNo,pageSize);
        Long totalCount=bookDao.findTotalCount(attr,val);
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,books);
        return pageResult;
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public Book findById(String id) {
        return bookDao.findById(id);
    }
}

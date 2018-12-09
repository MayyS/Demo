package edu.business.bookstore.dao;

import edu.base.dao.BaseDao;
import edu.business.bookstore.entity.Book;

public interface BookDao  extends BaseDao<Book> {
    public Book findById(String id);
}

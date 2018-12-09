package edu.business.bookstore.dao.impl;

import edu.base.dao.impl.BaseDaoimpl;
import edu.business.bookstore.dao.BookDao;
import edu.business.bookstore.entity.Book;
import edu.util.HibernateUtils;
import org.hibernate.Session;

public class BookDaoImpl extends BaseDaoimpl<Book> implements BookDao {
    @Override
    public Book findById(String id) {
        Session session=HibernateUtils.getSession();
        Book obj=(Book) session.get(Book.class,id);
        session.close();
        return obj;
    }
}

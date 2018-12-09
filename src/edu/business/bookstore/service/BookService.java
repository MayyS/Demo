package edu.business.bookstore.service;

import edu.base.service.BaseService;
import edu.business.bookstore.entity.Book;

public interface BookService extends BaseService<Book> {
    public Book findById(String id);
}

package com.atguigu.service;

import com.atguigu.model.Book;
import com.atguigu.model.PageBean;

import java.util.List;

/**
 * @author lixw
 * @create 2020-11-28 16:51
 */
public interface BookService {
    List<Book> findAllBook();

    boolean saveBook(Book book);

    boolean delBook(int id);

    Book getBook(int id);

    boolean updateBook(Book book1);

    PageBean<Book> getBookPage(int pageNo);

    PageBean<Book> findPageBookCondition(int pageNo, String title);
}

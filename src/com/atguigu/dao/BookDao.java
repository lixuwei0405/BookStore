package com.atguigu.dao;

import com.atguigu.model.Book;

import java.util.List;

/**
 * @author lixw
 * @create 2020-11-28 16:51
 */
public interface BookDao {
    List<Book> findAllBook();

    boolean saveBook(Book book);

    boolean delBook(int id);

    Book getBook(int id);

    boolean updateBook(Book book1);

    //查询图书表有多少条记录
    Integer selectCountBook();

    //每页数据list集合
    List<Book> getBookPage(Integer begin, Integer limit);

    Integer selectCountBookCondition(String title);

    List<Book> getBookPageCondition(Integer begin, Integer limit, String title);
}

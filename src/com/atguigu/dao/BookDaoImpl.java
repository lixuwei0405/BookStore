package com.atguigu.dao;

import com.atguigu.model.Book;
import com.atguigu.utils.BaseDBUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixw
 * @create 2020-11-28 16:51
 */
public class BookDaoImpl extends BaseDBUtils implements BookDao {
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book order by id DESC";
        return getBeanList(sql, Book.class);
    }

    @Override
    public boolean saveBook(Book book) {
        String sql = "insert into t_book values(null,?,?,?,?,?,?)";
        Object[]  params = {book.getTitle(),book.getAuthor(),book.getPrice(),book.getStock(),book.getSales(),book.getImgpath()};
        int count = update(sql, params);
        return count>0;
    }

    @Override
    public boolean delBook(int id) {
        String sql = "delete from t_book where id = ?";
        int count = update(sql, id);
        return count>0;
    }

    @Override
    public Book getBook(int id) {
        String sql = "select * from t_book where id = ?";
        return getBean(sql,Book.class,id);
    }

    @Override
    public boolean updateBook(Book book1) {
        String sql = "update t_book set title=?,price=?,author=?,stock=?,sales=? where id=?";
        Object[] paramArr = {book1.getTitle(),book1.getPrice(),book1.getAuthor(),book1.getStock(),book1.getSales(),book1.getId()};
        int count = update(sql, paramArr);
        return count>0;
    }

    //查询图书表有多少条记录
    @Override
    public Integer selectCountBook() {
        String sql = "SELECT COUNT(*) FROM t_book";
        Object count = getCount(sql);
        //把object类型转换int类型
        //转换方式：把object转换字符串，把字符串转换int
        Integer countInt = Integer.valueOf(count+"");
        return countInt;
    }

    //每页数据list集合
    @Override
    public List<Book> getBookPage(Integer begin, Integer limit) {
        String sql = "SELECT * FROM t_book LIMIT ?,?";
        List<Book> beanList = getBeanList(sql, Book.class, begin, limit);
        return beanList;
    }

    @Override
    public Integer selectCountBookCondition(String title) {
        String sql = "select count(*) from t_book where 1=1";
        List<Object> list = new ArrayList<>();
        if(title!=null && !"".equals(title)){
            sql+=" and title like ? ";
            list.add("%"+title+"%");
        }
        Object count = getCount(sql, list.toArray());
        return Integer.parseInt(count.toString());
    }

    @Override
    public List<Book> getBookPageCondition(Integer begin, Integer limit, String title) {
        String sql = "select * from t_book where 1=1 ";
        List<Object> list = new ArrayList<>();

        if(title!=null && !"".equals(title)){
            sql+="and title like ? ";
            list.add("%"+title+"%");
        }
        sql+=" limit ?,?";
        list.add(begin);
        list.add(limit);
        List<Book> beanList = getBeanList(sql, Book.class, list.toArray());
        return beanList;
    }
}

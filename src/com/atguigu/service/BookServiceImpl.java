package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.BookDaoImpl;
import com.atguigu.model.Book;
import com.atguigu.model.PageBean;

import java.util.List;

/**
 * @author lixw
 * @create 2020-11-28 16:51
 */
public class BookServiceImpl implements BookService {
    private BookDao bookdao = new BookDaoImpl();
    @Override
    public List<Book> findAllBook() {
        return bookdao.findAllBook();
    }

    @Override
    public boolean saveBook(Book book) {
        return bookdao.saveBook(book);
    }

    @Override
    public boolean delBook(int id) {
        return bookdao.delBook(id);
    }

    @Override
    public Book getBook(int id) {
        return bookdao.getBook(id);
    }

    @Override
    public boolean updateBook(Book book1) {
        return bookdao.updateBook(book1);
    }

    @Override
    public PageBean<Book> getBookPage(int pageNo) {
        //根据当前页得到分页所有数据，封装到PageBean对象里面
        PageBean<Book> pageBean = new PageBean<>();
        //当前页
        Integer pageNoInt = Integer.valueOf(pageNo);
        pageBean.setPageNo(pageNoInt);

        //总记录数：查询数据库得到
        BookDao dao = new BookDaoImpl();
        Integer totalCount = dao.selectCountBook();
        pageBean.setTotalCount(totalCount);

        //每页显示记录数 3
        Integer limit = 3;
        pageBean.setLimit(limit);

        //总页数
        Integer totalPage = 0;
        if(totalCount%limit==0) { //整除
            totalPage= totalCount/limit;
        } else {
            totalPage= totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);

        //开始位置
        //(当前页-1)*每页记录数
        Integer begin = (pageNoInt-1)*limit;
        pageBean.setBegin(begin);

        //每页数据list集合
        List<Book> list = dao.getBookPage(begin,limit);
        pageBean.setList(list);

        return pageBean;
    }

    @Override
    public PageBean<Book> findPageBookCondition(int pageNo, String title) {
        //根据当前页得到分页所有数据
        PageBean<Book> pageBean = new PageBean<>();
        pageBean.setPageNo(pageNo);
        //获取记录数
        Integer totalCount = bookdao.selectCountBookCondition(title);
        pageBean.setTotalCount(totalCount);
        //每页显示
        Integer limit = 3;
        pageBean.setLimit(limit);
        //总页数
        Integer totalPage = 0;
        if(totalCount%limit==0){
            totalPage = totalCount/limit;
        }else {
            totalPage = totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);
        //每页开始的位置
        Integer begin = (pageNo-1)*limit;
        pageBean.setBegin(begin);
        //每页数据的集合
        List<Book> list = bookdao.getBookPageCondition(begin,limit,title);
        pageBean.setList(list);
        return pageBean;
    }
}

package com.atguigu.controller;

import com.atguigu.model.Book;
import com.atguigu.model.PageBean;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author lixw
 * @create 2020-11-28 16:50
 */
@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();



    protected void findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listbook = bookService.findAllBook();
        request.setAttribute("listbook", listbook);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        Map<String, String[]> bookMap = request.getParameterMap();
        try {
            BeanUtils.populate(book, bookMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = bookService.saveBook(book);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/book?action=getPageBook");
        } else {
            request.setAttribute("msg", "添加图书失败！");
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
        }
    }

    protected void delBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean flag = bookService.delBook(id);
        if (flag) {
            response.sendRedirect(request.getContextPath() + "/book?action=getPageBook");
        } else {
            request.setAttribute("msg", "删除图书失败！");
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
        }
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBook(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request,response);

    }

      protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book1 = new Book();
          try {
              BeanUtils.populate(book1,request.getParameterMap());
          }catch (Exception e){
              e.printStackTrace();
          }
        boolean flag = bookService.updateBook(book1);
          if (flag) {
              response.sendRedirect(request.getContextPath() + "/book?action=getPageBook");
          } else {
              request.setAttribute("msg", "修改图书失败！");
              request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request,response);
          }

    }

    protected void getPageBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页pageNo
        String str = request.getParameter("pageNo");
        int pageNo = Integer.parseInt(str);
        PageBean<Book> pagebean = bookService.getBookPage(pageNo);
        request.setAttribute("pageBean",pagebean);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void getPageBookCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页pageNo
        String str = request.getParameter("pageNo");
        String title = request.getParameter("title");
        int pageNo = Integer.parseInt(str);
        PageBean<Book> pagebean = bookService.findPageBookCondition(pageNo,title);
        request.setAttribute("pageBean",pagebean);
        request.setAttribute("title",title);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void getPageBookFront(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页pageNo
        String str = request.getParameter("pageNo");
        String title = request.getParameter("title");
        int pageNo = Integer.parseInt(str);
        PageBean<Book> pagebean = bookService.findPageBookCondition(pageNo,title);
        request.setAttribute("pageBean",pagebean);
        request.setAttribute("title",title);
        request.getRequestDispatcher("/main.jsp").forward(request,response);
    }
}

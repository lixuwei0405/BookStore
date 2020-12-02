package com.atguigu.controller;

import com.atguigu.model.Book;
import com.atguigu.model.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lixw
 * @create 2020-12-02 19:24
 */
@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void addCartBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取添加图书id
        String id = request.getParameter("id");
        //2.根据图书的id查询图书对象
        Book book = bookService.getBook(Integer.parseInt(id));
        //3.把购物车存放到session判断是否是第一次
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addBookCart(book);
        //跳转到购物车页面
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clearCart();
        }else {
//            response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
            response.sendRedirect(request.getContextPath()+"/cart?action=showCart");
        }
    }
    protected void deleteItemCast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteCartItem(id);
        response.sendRedirect(request.getContextPath()+"/cart?action=showCart");
    }
}

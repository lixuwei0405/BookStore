package com.atguigu.controller;

import com.atguigu.model.Cart;
import com.atguigu.model.CartItem;
import com.atguigu.model.User;
import com.atguigu.model.orders.Orders;
import com.atguigu.model.orders.OrdersItem;
import com.atguigu.service.OrderServiceImpl;
import com.atguigu.service.OrdersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lixw
 * @create 2020-12-04 18:40
 */
@WebServlet(name = "OrdersServlet",urlPatterns = "/orders")
public class OrdersServlet extends BaseServlet {
    //生成订单
    protected void createOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断用户是否是登录
       User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
            return;
        }
        //从购物车中取出数据
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart ==null){
            response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
            return;
        }
        //把订单所需的所有数据封装到orders中
        Orders orders = new Orders();
        //订单id
        String oid = UUID.randomUUID().toString();
        oid = oid.replaceAll("-", "");
        orders.setOid(oid);
        //下单时间
        orders.setOrderstime(new Date());
        //总金额
        orders.setTotalprice(cart.getTotalAmount());
        //支付状态默认为1
        orders.setState(1);
        //订单所属用户
        orders.setUser(user);
        //封装订单项，在cart的map中
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            OrdersItem ordersItem = new OrdersItem();
            String itemId = UUID.randomUUID().toString().replaceAll("-","");
            ordersItem.setItemid(itemId);//订单项id
            ordersItem.setAmount(cartItem.getAmount());//小计
            ordersItem.setBook(cartItem.getBook());//图书
            ordersItem.setCount(cartItem.getBookNum());//购买数量
            ordersItem.setOrders(orders);
            orders.getList().add(ordersItem);
        }

        //添加orders里面所有数据到数据库表
        OrdersService ordersService = new OrderServiceImpl();
        ordersService.saveOrders(orders);
        cart.clearCart();
        //跳转到订单的显示页面
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
        return;
    }


}

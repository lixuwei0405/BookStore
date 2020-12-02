package com.atguigu.utils;

import com.atguigu.model.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User result = userService.login(user);
        if(result!=null){
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");

        }else{
//            response.sendRedirect(request.getContextPath()+"/pages/user/login.html");
            request.setAttribute("msg", "用户名或密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

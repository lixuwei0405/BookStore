package com.atguigu.utils;

import com.atguigu.model.User;
import com.atguigu.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //使用对象进行对数据进行封装
        User user = new User();
        //使用beanUtils工具类进行set
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = userService.register(user);
        if(flag){
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/pages/user/register.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

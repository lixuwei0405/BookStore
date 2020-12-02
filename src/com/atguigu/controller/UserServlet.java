package com.atguigu.controller;

import com.atguigu.model.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author lixw
 * @create 2020-11-28 9:53
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        Map<String, String[]> param = request.getParameterMap();
        try {
            BeanUtils.populate(user,param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User result = userService.login(user);
        if(result!=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",result);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
//            response.sendRedirect(request.getContextPath()+"/pages/user/login.html");
            request.setAttribute("msg", "用户名或密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }

    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //验证码校验
        //1 获取表单输入的验证码
        String code = request.getParameter("code");
        //2 获取图片验证码，从session获取
        HttpSession session = request.getSession();
        String sessionCode = (String)session.getAttribute("KAPTCHA_SESSION_KEY");

        //比较
        if(!code.equals(sessionCode)) { //验证码不一样
            request.setAttribute("msg","验证码不正确");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }

        //2  调用service
        UserService userService = new UserServiceImpl();
        boolean flag = userService.register(user);

        //3 判断
        if(flag) { //注册成功
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
            //return;
        } else { //失败
            response.sendRedirect(request.getContextPath()+"/pages/user/regist.jsp");
        }
    }

}

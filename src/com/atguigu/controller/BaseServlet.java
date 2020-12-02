package com.atguigu.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author lixw
 * @create 2020-11-28 9:48
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    public BaseServlet() {
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            //获取提交过来的action值，和执行方法名称一样
            String methodName = req.getParameter("action");
            //获取当前运行时class对象
            Class aClass = this.getClass();
            //获取类的方法
            Method m = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //让获取方法执行
            m.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

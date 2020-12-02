<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/27
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.sendRedirect(request.getContextPath()+"/book?action=getPageBookFront&pageNo=1");
%>

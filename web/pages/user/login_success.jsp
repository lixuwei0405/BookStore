<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/27
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }
    </style>
</head>
<body>
<div id="header">
    <a href="<%=request.getContextPath()%>/index.jsp">
        <img class="logo_img" alt="" src="<%=request.getContextPath()%>/static/img/logo.gif" />
    </a>
    <div>
        <span>欢迎<span class="um_span">张总</span>光临尚硅谷书城</span>
        <a href="<%=request.getContextPath()%>/pages/order/order.html">我的订单</a>
        <a href="<%=request.getContextPath()%>/index.jsp">注销</a>&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <h1>欢迎回来 <a href="<%=request.getContextPath()%>/index.jsp">转到主页</a></h1>

</div>

<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
</div>
</body>
</html>
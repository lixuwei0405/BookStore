<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/28
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/css/style.css" >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/minireset.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/common.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/cart.css" />
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
            font-size: 26px;
        }
        .oid{
            color: red;
            font-weight: bolder;
        }
    </style>
</head>
<body>

<!--	<div id="header">-->
<!--			<img class="logo_img" alt="" src="<%=request.getContextPath()%>/static/img/logo.gif" >-->
<!--			<span class="wel_word">结算</span>-->
<!--			<div>-->
<!--				<span>欢迎<span class="um_span">张总</span>光临尚硅谷书城</span>-->
<!--				<a href="../order/order.html">我的订单</a>-->
<!--				<a href="<%=request.getContextPath()%>/index.html">注销</a>&nbsp;&nbsp;-->
<!--				<a href="<%=request.getContextPath()%>/index.html">返回</a>-->
<!--			</div>-->
<!--	</div>-->
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="<%=request.getContextPath()%>/index.html">
                <img src="<%=request.getContextPath()%>/static/img/logo.gif" alt=""
                /></a>
            <span>我的购物车</span>
        </div>
        <div class="header-right">
            <h3>欢迎<span>张总</span>光临尚硅谷书城</h3>
            <div class="order"><a href="../order/order.html">我的订单</a></div>
            <div class="destory"><a href="<%=request.getContextPath()%>/index.html">注销</a></div>
            <div class="gohome">
                <a href="<%=request.getContextPath()%>/index.html">返回</a>
            </div>
        </div>
    </div>
</div>

<div id="main">
    <h1>你的订单已结算，订单号为:<span class="oid" style="color: hotpink">${orders.oid}</span></h1>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>
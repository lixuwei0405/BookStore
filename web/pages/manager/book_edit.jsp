<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/minireset.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/common.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/style.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/cart.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bookManger.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/register.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/book_edit.css" />
</head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            function titleIsEmpty(){
                $("#titleErrMsg").css('visibility','hidden')
                if ($("input[name='title']").val()==""){
                    $("#titleErrMsg").css('visibility','visible')
                    return false;
                }
            }
            function priceIsEmpty(){
                $("#priceErrMsg").css('visibility','hidden')
                if ($("input[name='price']").val()==""){
                    $("#priceErrMsg").css('visibility','visible')
                    return false;
                }
            }
            function authorIsEmpty(){
                $("#authorErrMsg").css('visibility','hidden')
                if ($("input[name='author']").val()==""){
                    $("#authorErrMsg").css('visibility','visible')
                    return false;
                }
            }
            function stockIsEmpty(){
                $("#stockErrMsg").css('visibility','hidden')
                if ($("input[name='stock']").val()==""){
                    $("#stockErrMsg").css('visibility','visible')
                    return false;
                }
            }
            function salesIsEmpty(){
                $("#salesErrMess").css('visibility','hidden')
                if ($("input[name='sales']").val()==""){
                    $("#salesErrMess").css('visibility','visible')
                    return false;
                }
            }
            $("input[name='title']").blur(titleIsEmpty)
            $("input[name='price']").blur(priceIsEmpty)
            $("input[name='author']").blur(authorIsEmpty)
            $("input[name='stock']").blur(stockIsEmpty)
            $("input[name='sales']").blur(salesIsEmpty)
            if(!${empty msg}){
                alert("${msg}");
            }
            $("form").submit(titleIsEmpty).submit(priceIsEmpty).submit(authorIsEmpty).submit(stockIsEmpty).submit(salesIsEmpty)
        })


    </script>
<body>
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="<%=request.getContextPath()%>/index.html">
                <img src="<%=request.getContextPath()%>/static/img/logo.gif" alt=""
                /></a>
            <h1>编辑图书</h1>
        </div>
        <div class="header-right">
            <a href="./book_manager.html" class="order">图书管理</a>
            <a href="./order_manager.html" class="destory">订单管理</a>
            <a href="<%=request.getContextPath()%>/index.html" class="gohome">返回商城</a>
        </div>
    </div>
</div>
<div class="login_banner">
    <div class="register_form">
        <form action="<%=request.getContextPath()%>/book?action=addBook" method="post">
            <div class="form-item">
                <div>
                    <label>名称:</label>
                    <input  type="text" name="title" placeholder="请输入名称" />
                </div>
                <span id="titleErrMsg" class="errMess" >请输入正确的名称</span>
            </div>
            <div class="form-item">
                <div>
                    <label>价格:</label>
                    <input type="number" name="price" placeholder="请输入价格" />
                </div>
                <span id="priceErrMsg" class="errMess">请输入正确数字</span>
            </div>
            <div class="form-item">
                <div>
                    <label>作者:</label>
                    <input type="text" name="author" placeholder="请输入作者" />
                </div>
                <span id="authorErrMsg" class="errMess">请输入正确作者</span>
            </div>
            <div class="form-item">
                <div>
                    <label>销量:</label>
                    <input type="number" name="stock" placeholder="请输入销量" />
                </div>
                <span id="stockErrMsg" class="errMess">请输入正确销量</span>
            </div>
            <div class="form-item">
                <div>
                    <label>库存:</label>
                    <input type="number" name="sales" placeholder="请输入库存" />
                </div>
                <span id="salesErrMess" class="errMess">请输入正确库存</span>
            </div>

            <button class="btn">提交</button>
        </form>
    </div>
</div>
<div class="bottom">
    尚硅谷书城.Copyright ©2015
</div>
</body>
</html>


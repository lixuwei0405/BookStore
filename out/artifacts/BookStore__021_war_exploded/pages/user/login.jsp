<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/27
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>尚硅谷会员登录页面</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/static/css/style.css" />
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function(){
            //单击submit按钮时， 验证用户名&密码是否为空
            $("#sub_btn").click(function () {
                //获取用户名数据
                var unValue = $("#username").val();
                if(unValue == ""){
                    // alert("用户名不能为空，请重新输入！");
                    $(".errorMsg").html("用户名不能为空，请重新输入！").css("color","red");
                    return false;
                }
                //验证密码
                var pwdVaule = $("#password").val();
                if(pwdVaule == ""){
                    // alert("密码不能为空，请重新输入！");
                    $(".errorMsg").html("密码不能为空，请重新输入！").css("color","red");
                    return false;
                }

            });

            if(!${empty msg}){
                $(".errorMsg").html("<span style='color: red'>${msg}</span>");
            }

        });
    </script>
</head>
<body>
<div id="login_header">
    <a href="<%=request.getContextPath()%>/index.jsp">
        <img class="logo_img" alt="" src="<%=request.getContextPath()%>/static/img/logo.gif" />
    </a>
</div>

<div class="login_banner">
    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">请输入用户名和密码</span>
                </div>
                <div class="form">
                    <form action="<%=request.getContextPath()%>/user?action=login" method="post">
                        <label>用户名称：</label>
                        <input
                                class="itxt"
                                type="text"
                                placeholder="请输入用户名"
                                autocomplete="off"
                                tabindex="1"
                                name="username"
                                id="username"
                        />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input
                                class="itxt"
                                type="password"
                                placeholder="请输入密码"
                                autocomplete="off"
                                tabindex="1"
                                name="password"
                                id="password"
                        />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                    <div class="tit">
                        <a href="<%=request.getContextPath()%>/pages/user/regist.jsp">立即注册</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="bottom">
      <span>
        尚硅谷书城.Copyright &copy;2015
      </span>
</div>
</body>
</html>


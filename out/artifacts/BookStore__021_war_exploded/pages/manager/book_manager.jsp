<%--
  Created by IntelliJ IDEA.
  User: lixuwei
  Date: 2020/11/28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/minireset.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/common.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/cart.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bookManger.css"/>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
    function SelectPage(id) {
        var title = $("input[name='title']").val();
        window.location = "${pageContext.request.contextPath}/book?action=getPageBookCondition&pageNo="+id+"&title="+title;
    }
    $(function () {
        $(".del").click(function () {
            return  confirm("您确定要删除这条记录吗?");
        })
        var title = $("input[name='title']").val();
        $("#goto").click(function () {
            var id = $("#gotoPage").val();
            if(id<1 || id>${pageBean.totalPage}){
                alert("请输入正确的页数")
            }else {
                window.location = "${pageContext.request.contextPath}/book?action=getPageBookCondition&pageNo="+id+"&title="+title;
            }
        })
    })
</script>
<body>
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="<%=request.getContextPath()%>/index.html">
                <img src="<%=request.getContextPath()%>/static/img/logo.gif" alt=""
                /></a>
            <h1>图书管理系统</h1>
        </div>
        <div class="header-right">
            <a href="#" class="order">图书管理</a>
            <a href="./order_manager.html" class="destory">订单管理</a>
            <a href="<%=request.getContextPath()%>/index.html" class="gohome">返回商城</a>
        </div>
    </div>
</div>
<div class="list">
    <div class="w">
        <div class="add">
            <a href="<%=request.getContextPath()%>/pages/manager/book_edit.jsp">添加图书</a>
        </div>
        <div>
            图书名称：<input id="titleid" type="text" name="title" value="${title}"/>
            <input type="button" value="查询" onclick="SelectPage(1)"/>
        </div>
        <table>
            <thead>
            <tr>
                <th>图片</th>
                <th>商品名称</th>
                <th>价格</th>
                <th>作者</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageBean.list}" var="book">
                <tr>
                    <td>
                        <img src="<%=request.getContextPath()%>/static/uploads/huozhe.jpg" alt=""/>
                    </td>
                    <td>${book.title}</td>
                    <td>
                            ${book.price}
                    </td>
                    <td>${book.price}</td>
                    <td>${book.stock}</td>
                    <td>${book.sales}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/book?action=getBook&id=${book.id}">修改</a>
                        <a href="book_edit.jsp" class="del" >删除</a>
                            <%-- href="<%=request.getContextPath()%>/book?action=delBook&id=${book.id}"--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="footer">
            <div class="footer-right">
                <div><a href="#" onclick="SelectPage(1)">首页</a></div>
                <c:if test="${pageBean.pageNo!=1}">
                    <div><a href="#" onclick="SelectPage(${pageBean.pageNo-1})">上一页</a></div>
                </c:if>
                <ul>
                    <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="i">
                        <c:if test="${pageBean.pageNo==i}">
                            <li id="selectId" class="active" onclick="SelectPage(${i})">${i}</li>
                        </c:if>
                        <c:if test="${pageBean.pageNo!=i}">
                            <li id="selectId" onclick="SelectPage(${i})">${i}</li>
                        </c:if>
                    </c:forEach>
                </ul>
                <c:if test="${pageBean.pageNo!=pageBean.totalPage}">
                    <div><a href="#" onclick="SelectPage(${pageBean.pageNo+1})">下一页</a></div>
                </c:if>
                <div><a href="#" onclick="SelectPage(${pageBean.totalPage})">末页</a></div>
                <span>共${pageBean.totalPage}页</span>
                <span>${pageBean.totalCount}条记录</span>

                <span>到第</span>
                <input type="text" id="gotoPage"/>
                <span>页</span>
                <button id="goto">确定</button>
            </div>
        </div>
    </div>
</div>
<div class="bottom">
    <div class="w">
        <div class="top">
            <ul>
                <li>
                    <a href="">
                        <img src="<%=request.getContextPath()%>/static/img/bottom1.png" alt=""/>
                        <span>大咖级讲师亲自授课</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="<%=request.getContextPath()%>/static/img/bottom.png" alt=""/>
                        <span>课程为学员成长持续赋能</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <img src="<%=request.getContextPath()%>/static/img/bottom2.png" alt=""/>
                        <span>学员真是情况大公开</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="content">
            <dl>
                <dt>关于尚硅谷</dt>
                <dd>教育理念</dd>
                <!-- <dd>名师团队</dd>
                <dd>学员心声</dd> -->
            </dl>
            <dl>
                <dt>资源下载</dt>
                <dd>视频下载</dd>
                <!-- <dd>资料下载</dd>
                <dd>工具下载</dd> -->
            </dl>
            <dl>
                <dt>加入我们</dt>
                <dd>招聘岗位</dd>
                <!-- <dd>岗位介绍</dd>
                <dd>招贤纳师</dd> -->
            </dl>
            <dl>
                <dt>联系我们</dt>
                <dd>http://www.atguigu.com</dd>
                <dd></dd>
            </dl>
        </div>
    </div>
    <div class="down">
        尚硅谷书城.Copyright ©2015
    </div>
</div>
</body>
</html>


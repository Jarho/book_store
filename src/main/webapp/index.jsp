<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>商城主页</title>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script language="javascript" charset="utf-8">
        var user = "${sessionScope.generalUser}";
    </script>
</head>
<body>
<!-- 标题 -->
<div class="title fixheight">201631106032&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刘家豪</div>
<!-- 导航条 -->
<div class="navdiv fixheight">
    <ul class="nav nav1 fixheight">
        <li><a href="user_login.html">登录</a></li>
        <li><a href="register.html">注册</a></li>
        <li><a href="admin_login.html">管理商品</a></li>
    </ul>
    <ul class="nav nav2 fixheight">
        <li><span class="username">
					用户名：${sessionScope.generalUser.name }&nbsp; <a class="quit">退出</a>
			</span></li>
        <li><a href="show_cart.jsp">购物车</a></li>
        <li><a href="admin_login.html">管理商品</a></li>
    </ul>
</div>
<!-- 搜索框 -->
<div class="search">
    <input type="text" placeholder="请输入商品编号"/>
    <button>查询</button>
</div>
<!-- 表格 -->
<div class="content fixheight">
    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>价格</th>
            <th>库存</th>
            <th>添加</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
<div class="page">
    <a href="#" class="prev">上一页</a>
    <span>第<span class="pageNum"></span>/<span class="totalPageNum"></span>页</span>
    <a href="#" class="next">下一页</a>
</div>
</body>
</html>
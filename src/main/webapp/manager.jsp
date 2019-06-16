<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理商品</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript" src="lib/jquery-1.7.2-min.js"></script>
<script type="text/javascript" src="js/manager.js"></script>
</head>
<body>
	<!-- 标题 -->
	<div class="title fixheight">1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</div>

	<!-- 导航条 -->
	<div class="navdiv fixheight">
		<ul class="nav fixheight">
			<li><span class="manager">管理员：${sessionScope.adminUser.name }</span></li>
			<li><a href="add_commodity.jsp">添加商品</a></li>
			<li><a href="index.jsp">返回首页</a></li>
		</ul>
	</div>

	<!-- 搜索框 -->
	<div class="search">
		<input type="text" placeholder="请输入商品编号" value="${requestScope.id }" />
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
					<th colspan="2">管&nbsp;&nbsp;理</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<div class="page">
			<a href="#" class="prev">上一页</a>
			<span>第<span class="pageNum"></span>/<span class="totalPageNum"></span>页</span>
			<a href="#" class="next">下一页</a>
		</div>
</body>
</html>
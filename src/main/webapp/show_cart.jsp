<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="css/cart.css" />
<script type="text/javascript" src="lib/jquery-1.7.2-min.js"></script>
<script type="text/javascript" src="js/show_shopping_cart.js"></script>
    <script language="javascript" charset="utf-8">
        var user = "${sessionScope.generalUser}";
</script>
</head>
<body>
	<!-- 标题 -->
	<div class="title fixheight">201631106032&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;刘家豪</div>

	<!-- 导航条 -->
	<div class="navdiv fixheight">
		<ul class="nav nav2 fixheight">
			<li></li>
			<li><span class="username">用户名：${sessionScope.generalUser.name }</span></li>
			<li><a href="index.jsp">返回首页</a></li>
		</ul>
	</div>

	<!-- 表格 -->
	<div class="content fixheight">
		<table>
			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>价格</th>
					<th>数量</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">总计</td>
					<td class="totalPrice"></td>
					<td class="totalNum"></td>
                    <td><a class='buy'>结算</a></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div class="page">
			<a href="#" class="prev">上一页</a>
			<span>第<span class="pageNum"></span>/<span class="totalPageNum"></span>页</span>
			<a href="#" class="next">下一页</a>
		</div>
</body>
</html>
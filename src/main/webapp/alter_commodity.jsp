<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
<link rel="stylesheet" href="css/update.css">
<script type="text/javascript" src="lib/jquery-1.7.2-min.js"></script>
<script type="text/javascript" src="js/update.js"></script>
</head>
<body>
	<div id="login">
		<h2>
			<span class="fontawesome-plus-sign"></span>修改商品
		</h2>
		<fieldset>

			<p>
				<label for="id">商品编号</label><span class="idInfo"></span>
			</p>
			<p>
				<input type="text" class="id" placeholder="${param.id }">
			</p>

			<p>
				<label for="name">商品名称</label> <span class="nameInfo"></span>
			</p>

			<p>
				<input type="text" class="name" placeholder="${param.name }">
			</p>

			<p>
				<label for="price">商品价格</label> <span class="priceInfo"></span>
			</p>

			<p>
				<input type="text" class="price" placeholder="${param.price }">
			</p>

			<p>
				<label for="num">商品库存</label> <span class="numInfo"></span>
			</p>

			<p>
				<input type="text" class="num" placeholder="${param.num }">
			</p>
			<input type="hidden" class="beforeId" value="${param.id }" />
			<p>
				<button class="submit">修改</button>
				<button class="back">返回</button>
			</p>

		</fieldset>
	</div>
</body>
</html>
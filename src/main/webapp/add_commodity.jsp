<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>添加商品</title>
    <link rel="stylesheet" href="css/update.css"/>
    <script type="text/javascript" src="lib/jquery-1.7.2-min.js"></script>
    <script type="text/javascript" src="js/add.js"></script>
</head>

<body>
<div id="login">
    <h2>
        <span class="fontawesome-plus-sign"></span>添加商品
    </h2>
    <fieldset>

        <p>
            <label for="id">商品编号</label><span class="idInfo"></span>
        </p>
        <p>
            <input type="text" class="id" placeholder="请输入商品编号">
        </p>

        <p>
            <label for="name">商品名称</label>
            <span class="nameInfo"></span>
        </p>

        <p>
            <input type="text" class="name" placeholder="请输入商品名称">
        </p>

        <p>
            <label for="price">商品价格</label>
            <span class="priceInfo"></span>
        </p>

        <p>
            <input type="text" class="price" placeholder="请输入商品价格">
        </p>

        <p>
            <label for="num">商品库存</label>
            <span class="numInfo"></span>
        </p>

        <p>
            <input type="text" class="num" placeholder="请输入商品库存">
        </p>
        <p>
            <button class="submit">添加</button>
            <button class="back">返回</button>
        </p>
    </fieldset>
</div>
</body>
</html>

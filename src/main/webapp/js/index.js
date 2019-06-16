$(function() {

	/**
	 * 页面刚打开时查询所有商品
	 */
	searchCommodity("",1);

	/**
	 * 监听查询按钮
	 */
	$(".search button").click(function() {
		searchCommodity($(this).prev().val(),1);
	});

	/**
	 * AJAX获取并显示商品
	 */
	function searchCommodity(id,pageNum) {
		//封装请求参数
		var args = {"id" : id, "pageNum":pageNum};
		$("tbody").empty();
		$(".content .noCommodity").remove();
		//发送异步请求
		$.getJSON("queryCommodity", args, function(data) {
			if (data.list != "") {
				$(".noCommodity").hide();
				$("table").show();
                $(".page").show();
				for (var i = 0; i < data.list.length; i++) {
					$("tbody").append("<tr>" + 
							"<td id='id'>" + data.list[i].id + "</td>"+ 
							"<td>" + data.list[i].name + "</td>" + 
							"<td>￥"+ data.list[i].price + "</td>" + 
							"<td id='num'>"+ data.list[i].num + "</td>" + 
							"<td><a class='buy'>添加</a></td>"+
							"</tr>");
				}
				//设置页脚
				$(".page .pageNum").text(data.pageNum);
				$(".page .totalPageNum").text(data.totalPageNum);
				$(".page .prev").attr("value",data.prevPage);
				$(".page .next").attr("value",data.nextPage);
				//隐藏/显示：上/下一页
				if(data.totalPageNum == 1){
					$(".page .next").hide();
					$(".page .prev").hide();
				}else{
					if(data.pageNum == 1){
						$(".page .prev").hide();
						$(".page .next").show();
					}else if(data.pageNum == data.totalPageNum){
						$(".page .next").hide();
						$(".page .prev").show();
					}else{
						$(".page .next").show();
						$(".page .prev").show();
					}
				}
			} else {
				$("table").hide();
				$(".page").hide();
				$(".content").append("<p class='noCommodity'>没有找到商品！</p>");
			}

			//监听购买按钮
			$(".buy").click(function() {
				var id = $(this).parent().prevAll("#id").text();
				var numFromDB = $(this).parent().prevAll("#num").text();
				if (user == "") {
					alert("请先登录");
					return;
				} else {
					var num;
					while (true) {
						num = prompt("请输入购买的数量", "1");
						// alert(parseInt(num));

						if (num == null) {
							// 用户取消输入
							return;
						} else if ((isNaN(parseInt(num))) || parseInt(num) == 0
								|| parseInt(num) < 0) {
							// 输入非数字、空、小于0
							alert("请输入正确的购买数量");
							continue;
						} else if (parseInt(num) > parseInt(numFromDB)) {
							// 输入的数量不正确
							alert("抱歉，库存不足");
							continue;
						} else {
							break;
						}
					}
					var args = {"id":id, "num":num};
					$.getJSON("addToCart",args,function(data){
						if(data.addStatus == 1){
							alert("添加成功");
                            $(this).parent().prevAll("#num").text(numFromDB - num);
						}else{
							alert("添加失败");
						}
					});
				}
			});
		});
	}
	
	/**
	 * 监听翻页
	 */
	$(".page a").click(function() {
		searchCommodity($(".search :text").val(),$(this).val());
		return false;
	});
	
	/**
	 * 监听退出
	 */
	$(".quit").click(function() {
		$.getJSON("userLogout", function (data) {
			if (data.logoutStatus == 1){
                $(".nav2").hide();
                $(".nav1").show();
				alert("注销成功");
			}else{
                alert("注销失败");
			}
        });
	});

	/**
	 * 判断是否已经登录
	 */
	if (user != "") {
		$(".nav1").hide();
	} else {
		$(".nav2").hide();
	}
	
})
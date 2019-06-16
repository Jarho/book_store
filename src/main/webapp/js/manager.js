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
	function searchCommodity(id,pageNum){
		var id = {"id": id, "pageNum":pageNum};
		$("tbody").empty();
		$(".content .noCommodity").remove();
		$.getJSON("queryCommodity", id, function(data){
			if(data.list != "" && data.list != null){
				$(".noCommodity").hide();
				$("table").show();
                $(".page").show();
				for(var i = 0; i < data.list.length; i++){
					$("tbody").append("<tr>" +
							"<td id='id'>" + data.list[i].id +"</td>" +
							"<td id='name'>" + data.list[i].name +"</td>" +
							"<td id='price'>￥" + data.list[i].price +"</td>" +
							"<td id='num'>" + data.list[i].num +"</td>" +
							"<td><a class='alter'>修改</a></td>" +
							"<td><a class='delete'>删除</a></td>" +
					"</tr>");
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
				}				
			}else{
				$("table").hide();
				$(".page").hide();
				$(".content").append("<p class='noCommodity'>没有找到商品！</p>");
			}
			
			// 监听修改按钮
			$("tbody .alter").click(
					function() {
						var id = $(this).parent().prevAll("#id").text();
						var name = $(this).parent().prevAll("#name").text();
						var price = $(this).parent().prevAll("#price").text();
						var num = $(this).parent().prevAll("#num").text();
						window.open("alter_commodity.jsp?id=" + id + "&name="
										+ name + "&price=" + price + "&num=" + num,
										"_self");
						return false;
					});
			
			// 监听删除按钮
			$("tbody .delete").click(function() {
				var id = $(this).parent().prevAll("#id").text();
				var args = {"id":id};
				$.getJSON("deleteCommodity", args, function(data){
					if(data.deleteCommodityStatus == 1){
						alert("删除成功");
						searchCommodity("",1);
					}else{
						alert("删除失败");
					}
				});
				return false;
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
	
})
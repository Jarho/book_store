$(function() {
	
	/**
	 * 页面刚打开时查询所有商品
	 */
	showCart(1);
	
	/**
	 * AJAX获取并显示商品
	 */
	function showCart(pageNum){
		var args = {"pageNum":pageNum};
		$("tbody").empty();
		$.getJSON("queryCart", args, function(data){
			if(data.list != ""){
				var totalNum = 0;
				var totalPrice = 0.0;
				$(".noCommodity").hide();
				$("table").show();
                $(".page").show();
				for(var i = 0; i < data.list.length; i++){
					$("tbody").append("<tr>" +
							"<td id='id'>" + data.list[i].id +"</td>" +
							"<td id='name'>" + data.list[i].commodityName +"</td>" +
							"<td id='price'>￥" + data.list[i].commodityPrice +"</td>" +
							"<td id='buyNum'>" + data.list[i].buyNum +"</td>" +
                            "<td><a class='delete'>删除</a></td>"+

                        "</tr>");
					totalNum += data.list[i].buyNum;
					totalPrice += data.list[i].buyNum * data.list[i].commodityPrice;
				}
				$("tfoot .totalPrice").text("￥" + totalPrice);
				$("tfoot .totalNum").text(totalNum);
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
				
			}else{
				$("table").hide();
				$(".page").hide();
				$(".content").append("<p class='noCommodity'>购物车没有商品！</p>");
			}
			$(".buy").click(function () {
				while (true){
                    if(window.confirm('总价为'+totalPrice+","+"继续结算吗")){
                        //alert("确定");
                        var args = {"id":"1", "num":"1"};
                        $.getJSON("clearCart",args,function(data){
                            if(data.clearStatus == 1){
                                alert("结算成功");
                                showCart(1);
                            }else{
                                alert("结算失败");
                            }
                        });
                        return true;
                    }else{
                        //alert("取消");
                        return false;
                    }
				}
            });
			//监听删除按钮
            $(".delete").click(function() {
                var id = $(this).parent().prevAll("#id").text();
                var numFromDB = $(this).parent().prevAll("#buyNum").text();

                    var num;
                    while (true) {
                        num = prompt("请输入删除的数量", "1");
                        // alert(parseInt(num));
                        if (num == null) {
                            // 用户取消输入
                            return;
                        } else if ((isNaN(parseInt(num))) || parseInt(num) == 0
                            || parseInt(num) < 0) {
                            // 输入非数字、空、小于0
                            alert("请输入正确的数量");
                            continue;
                        } else if (parseInt(num) > parseInt(numFromDB)) {
                            // 输入的数量不正确
                            alert("抱歉，购物车数量不足");
                            continue;
                        } else {
                            break;
                        }
                    }
                    var args = {"id":id, "num":num};
                    $.getJSON("deleteFromCart",args,function(data){
                        if(data.deleteStatus == 1){
                            alert("删除成功");
                            $(this).parent().prevAll("#buyNum").text(numFromDB - num);
                            showCart(1);
                        }else{
                            alert("删除失败");
                        }
                    });

            });
		});
	}
	
	/**
	 * 监听翻页
	 */
	$(".page a").click(function() {
		showCart($(this).val());
		return false;
	});
	
})
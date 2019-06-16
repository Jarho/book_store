$(function() {
	
	$(".back").click(function(){
		window.open("manager.jsp","_self");
	});
	
	$(".submit").click(function() {
		var beforeId = $(".beforeId").val();
		var id = $(".id").val();
		var name = $(".name").val();
		var price = $(".price").val();
		var num = $(".num").val();
		
		// 价格格式正确，可以有一个小数点或没有，开头不能为0
		var priceReg = /^[1-9]\d{0,}(\.\d+)?$/g;
		// 数量格式正确，都是数字
		var numReg = /^(([1-9]\d*)|0)$/g;
		// id格式正确，都是数字
		var idReg = /^[0-9]*$/g;
		// 正确的商品名称,开头不能是空格
		var nameReg = /^\s+.*\s+$/g;
		$(".idInfo").empty();
		$(".nameInfo").empty();
		$(".priceInfo").empty();
		$(".numInfo").empty();
		if (id == "" || !idReg.test(id)) {
			$(".idInfo").text("请输入正确的商品编号");
			return false;
		} else if ((name == "") || (nameReg.test(name))) {
			$(".nameInfo").text("请输入正确的商品名称");
			return false;
		} else if ((price == "") || (!priceReg.test(price))) {
			$(".priceInfo").text("请输入正确的商品价格");
			return false;
		} else if ((num == "") || (!numReg.test(num))) {
			$(".numInfo").text("请输入正确的商品库存");
			return false;
		}
		
		var args = {"preId":beforeId, "commodity.id":id, "commodity.name":name, "commodity.price":price, "commodity.num":num};
		$.post("alterCommodity", args, function(data){
			if(data.alterCommodityStatus == 1){
                alert("修改成功");
                window.open("manager.jsp","_self");
			}else if(data.alterCommodityStatus == 2){
                $(".idInfo").text("商品编号已存在");
			}else{
                alert("修改失败");
            }
		},"JSON");
		return false;
	});
})
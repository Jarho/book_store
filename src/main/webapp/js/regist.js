$(function(){
	
	$(".back").click(function(){
		window.open("index.jsp","_self");
	});
	
	$(".submit").click(function(){
		// 先对提示信息初始化
		$(".nameInfo").empty();
		$(".passwordInfo").empty();

		var regName = /^[a-zA-Z][a-zA-Z0-9_]{1,9}$/g;
		var regPassword = /[\u4e00-\u9fa5]/g;
		var name = $(".userName").val();
		var password = $(".password").val();
		var password2 = $(".password2").val();

		if (name == "") {
			$(".nameInfo").text("请输入用户名");
			return false;
		} else if (!regName.test(name)) {
			$(".nameInfo").text("请输入大于1位以字母开头，和数字下划线的组合");
			return false;
		} else if (password == "") {
			$(".passwordInfo").text("请输入密码");
			return false;
		} else if (regPassword.test(password)) {
			$(".passwordInfo").text("请不要输入汉字或空格");
			return false;
		} else if (password != password2) {
			$(".passwordInfo").text("两次密码不一致");
			return false;
		}
		
		var args = {"name":name, "password":password, "role":1};
		$.getJSON("userRegister",args,function(data){
			if(data.registerStatus == 1){
				alert("注册成功");
				window.open("index.jsp","_self");
			}else if(data.registerStatus == 2){
				alert("用户名已存在");
			}else{
                alert("注册失败");
			}

		});
	});
})
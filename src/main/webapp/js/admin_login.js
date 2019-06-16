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

		if (name == "") {
			$(".nameInfo").text("请输入管理员账户");
			return false;
		} else if (!regName.test(name)) {
			$(".nameInfo").text("字母开头，字母数字或下划线组合");
			return false;
		} else if (password == "") {
			$(".passwordInfo").text("请输入密码");
			return false;
		} else if (regPassword.test(password)) {
			$(".passwordInfo").text("请不要输入汉字或空格");
			return false;
		}
		
		var args = {"name":name, "password":password, "role":2};
		$.getJSON("login",args,function(data){
            if (data.loginStatus == "1") {
                alert("登录成功");
                window.open("manager.jsp", "_self");
            } else if(data.loginStatus == "2"){
                $(".nameInfo").text("用户名错误");
            } else if(data.loginStatus == "3"){
                $(".passwordInfo").text("密码错误");
            }else{
                alert("登陆失败, 服务器内部错误");
            }
		});
	});
})
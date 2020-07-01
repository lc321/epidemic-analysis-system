<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
		<h1>表单登录</h1>
		<form action="${requestContext}/yiqing/login/huiguorou.do" method="post">
				
				用户名:<input type="text" name="userName">
				
				密码:<input type="password" name="userPwd">
				
				<button type="submit">登录</button>
				
		</form>
		<!-- jsp的el表达式 -->
		${info}
		
		
		<h1>ajax登录</h1>

				
				用户名:<input type="text" id="userName">
				
				密码:<input type="password" id="userPwd">
				
				<button type="button" onclick="login()">登录</button>
				<button type="button" onclick="zhuce()">注册</button>
				<span id="info" style="color:red"></span>
	
</body>
<script>
		
		function login(){
			//获取用户输入用户名文本值
			var name = $("#userName").val();
			//获取用户输入的密码的文本值
			var pwd = $("#userPwd").val();
			//定义ajax请求
			$.ajax({
				url:"${requestContext}/yiqing/login/loginAjax.do", //定义服务端地址
				type:"get",//定义请求类型
				data:{"userName":name,"userPwd":pwd},//定义的请求参数
				dataType:"text",//定义返回的数据类型
				success:function(data){
					//在浏览器的控制台打印服务端返回的数据类型
					console.log(data);
					if (data=="success"){
						$("#info").text("登录成功");
					}else{
						$("#info").text("登录失败");
					}
				}
			})
		}
		
		//跳转到 注册页面
		function zhuce(){
			window.location.href="${requestContext}/yiqing/regedit.jsp";
		}
		
	
</script>
</html>

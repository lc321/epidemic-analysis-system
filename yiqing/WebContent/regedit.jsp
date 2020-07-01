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
	
		<h1>注册</h1>

				
				用户名:<input type="text" id="userName">
				
				密码:<input type="password" id="userPwd">
				
				确认密码:<input type="password" id="surePwd">
				
				<button type="button" onclick="regedit()">注册</button>
				
	
</body>
<script>
		
		function regedit(){
			//获取用户输入用户名文本值
			var name = $("#userName").val();
			//获取用户输入的密码的文本值
			var pwd = $("#userPwd").val();
			//获取确认密码的文本值
			var surePwd = $("#surePwd").val();
			//判断密码和确认密码输入是否正确
			if (pwd == surePwd){
				//验证重名
				valReName(name,pwd);
			}else{
				alert("确认密码和输入密码不一致");
			}
			
		}
	
		//验证用户名是否重名
		function valReName(name,pwd){
			$.ajax({
				url:"${requestContext}/yiqing/login/valReName.do", //定义服务端地址
				type:"get",//定义请求类型
				data:{"userName":name},//定义的请求参数
				dataType:"json",//定义返回的数据类型
				success:function(data){
					//在浏览器的控制台打印服务端返回的数据类型
					console.log("下面打印的是boolean");
					console.log(data);
					//true 代表重名，false代表不重名
					if (data==true){
						alert("用户名重名");
					}else{
						//定义ajax请求
						$.ajax({
							url:"${requestContext}/yiqing/login/regedit.do", //定义服务端地址
							type:"get",//定义请求类型
							data:{"userName":name,"userPwd":pwd},//定义的请求参数
							dataType:"text",//定义返回的数据类型
							success:function(data){
								//在浏览器的控制台打印服务端返回的数据类型
								console.log(data);
								if (data=="success"){
									alert("注册成功");
									//跳转到登录页面
									window.location.href="${requestContext}/yiqing/index.jsp";
								}else{
									alert("注册失败");
								}
							}
						})
					}
				}
			})
		}
	
</script>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetFile</title>
</head>
<body>
	<h1>注册页面</h1>
	<script type="text/javascript">
		function addUser()
		{
			var form = document.getElementById("adduser");
			form.action="/SpringMVC_Spring_Hibernate_Final/user/addUser";
			form.method="post";
			form.submit();
		}
	</script>
	<br/>
	<div>
		<form id="adduser">
			<div>
				姓名：<input type="text" name="usersName"><br/>
				年龄：<input type="text" name="age"><br/>
			</div>
			<br/>
			<input type="button" onclick="addUser()" value="添加">
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetFile</title>
<script type="text/javascript" src="/SpringMVC_Spring_Hibernate_Final/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<h1>编辑界面</h1>
	<script type="text/javascript">
	</script>
	<form action="/SpringMVC_Spring_Hibernate_Final/user/updateUser" method="post">
		<input type="hidden" name="id" value="${user.id}"><br/>
		<input type="text" name="age" value="${user.age }"><br/>
		<input type="text" name="usersName" value="${user.usersName}"><br/>
		<input type="submit" >
	</form>
</body>
</html>
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
	<h1>查询界面</h1>
	<script type="text/javascript">
		
	function deleteUser(id)
	{
		$.get("/SpringMVC_Spring_Hibernate_Final/user/deleteUser?id="+id, function(data){
			var obj = jQuery.parseJSON(data);
			if("success" == obj.msg)
				{
					window.location.reload();
					alert("删除成功");
				}
			else
				{
					window.location.reload();
					alert("删除失败");
				}
			
		});
	}
	
	</script>
	<table border="1">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty userlist}">
				<c:forEach items="${userlist}" var="user">
					<tr>
						<td>${user.usersName }</td>
						<td>${user.age}</td>
						<td>
							<a href="/SpringMVC_Spring_Hibernate_Final/user/toedit?id=${user.id}">编辑</a>
							<a href="javascript:void(deleteUser('${user.id}'))">删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>
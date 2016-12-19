<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增信息</title>
</head>
<body>
新增信息
	<form action="addFilmServlet">
	<table border="1">
		<tr>
			<td>title</td>
			<td>description</td>
			<td>language</td>
		</tr>
		<tr>
			<td><input type="text" name="title"></td>
			<td><input type="text" name="description"></td>
			<td><select name="language">
			<option>English</option>
			<option>Italian</option>
			<option>Japanese</option>
			<option>Mandarin</option>
			<option>French</option>
			<option>German</option>
			</select></td>
		</tr>
		<tr>
		<td colspan="3" ><button type="submit">新增</button></td>
		</tr>
	</table>
	</form>
	<c:if test="${!empty message}">
		<script type="text/javascript">
			alert('${message}');
		</script>
	</c:if>
	若新增结束请点击返回回到功能菜单</br>
	<a href="index.jsp">返回</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>编辑信息</title>
</head>
<body>
	<h2>当前正在编辑的是Film_id为  ${param.id} 的电影信息.请确认编辑对象正确再进行修改.</h2></br>
	<form action="editServlet">
		<table border="1">
			<tr>
				<td>title</td>
				<td>description</td>
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
				<td colspan="3"><button type="submit">提交</button> <input
					type="hidden" name="id" value=${param.id }></td>
			</tr>
		</table>
	</form>
	<c:if test="${!empty message}">
		<script type="text/javascript">
			alert('${message}');
		</script>
	</c:if>
	若编辑结束请点击返回回到功能菜单
	</br>
	<a href="index.jsp">返回</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h4>显示File列表</h4>
	<form>
		<table border="1">
			<tr>
				<td>Film_id</td>
				<td>Film_title</td>
				<td>Description</td>
				<td>Langua</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${list}" var="cs" varStatus="vs">
				<tr>
					<td align="center">${cs.film_id}</td>
					<td align="center">${cs.title}</td>
					<td align="center">${cs.description}</td>
					<td align="center">English</td>
					<td align="center"><a href="edit.jsp?id=${cs.film_id}">编辑</a></td>
					<td align="center"><a href="deleteServlet?id=${cs.film_id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<c:if test="${!empty message}">
		<script type="text/javascript">
			alert('${message}');
		</script>
	</c:if>
</body>
</html>
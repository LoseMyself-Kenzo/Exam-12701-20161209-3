<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
	<form action="loginServlet" method='post'>
	<table>
		<tr>
		<td>用户名:</td><td><input name="userName"/>(不可为空，注意大小写)</td>
		</tr>
		<tr>
		<td>密     码:</td><td><input name="password" disabled="disabled" value="******"></td>
		</tr>
		<tr>
		<td align="center"><button type="submit">登陆</button></td><td align="center"><button type="reset" >重置</button></td>
		</tr>
	</table>
</form>
<c:if test="${!empty message}">
	<script type="text/javascript">
		alert("<%=request.getAttribute("message")%>");
	</script>
</c:if>
</body>
</html>
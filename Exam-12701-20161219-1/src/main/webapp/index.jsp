<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>功能选择界面</title>
</head>
<body>
	<c:if test="${empty LOGIN_USER}">
		您需要登录后方可使用本系统,点击登录后进入登录界面<br/>
		<a href="login.jsp">登录</a>
	</c:if>
	
	<c:if test="${!empty LOGIN_USER}">
		<%=request.getAttribute("LOGIN_USER")%>,你好.欢迎使用本系统.<br/>
		请选择你要使用的功能：<br/>
		<a href="showFilm">显示所有Film</a><br/>
		<a href="add.jsp">新增Film信息</a><br/>
	</c:if>
</body>
</html>
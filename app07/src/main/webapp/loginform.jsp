<%@page import="app07.component.NavComponent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 입력 폼</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<form action="loginprogress.jsp" method="post">
		<label>아이디 <input type="text" name="id"></label>
		<label>비밀번호 <input type="password" name="password"></label>
		<input type="submit">
	</form>
</body>
</html>
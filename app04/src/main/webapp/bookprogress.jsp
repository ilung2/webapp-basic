<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 책</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); // tomcat의 해석
		String title = request.getParameter("title");
	%>
<p>선택한 책은 <%= title %> 입니다.</p>
</body>
</html>
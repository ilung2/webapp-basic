<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 제거</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("cname", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	%>
	<p>쿠키 제거</p>
</body>
</html>
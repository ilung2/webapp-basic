<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 전용 페이지</title>
</head>
<body>
	<%
		String role = (String) session.getAttribute("role");
		if (role.equals("ADMIN")) {
	%>
	<nav>
		<a href="contentform.jsp">컨텐츠 작성</a>
		<a href="contentcontrol.jsp">컨텐츠 목록 및 삭제</a>
	</nav>
	<%
		} else {
	%>
	<p>권한이 없습니다.</p>
	<%
		}
	%>
</body>
</html>
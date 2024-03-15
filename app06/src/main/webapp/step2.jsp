<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int sum = (int) request.getAttribute("sum");
	System.out.println("이어지는 두번째 처름 흐름");
%>
<p>두번째 페이지의 출력이 flush 됩니다.</p>
<p>연산결과 : <%= sum %></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력값 처리페이지</title>
</head>
<body>
	<%
	// request 기본 객체
	String userinput = request.getParameter("userinput");
	if (userinput == null || userinput.trim().equals("")) {
		// response 기본 객체
		response.sendRedirect("numberform.html");
	} else {
		System.out.println("사용자의 입력값: " + userinput);

		int num = Integer.parseInt(userinput);
		if (num > 0) {
	%>
	<p>양수를 입력했습니다</p>
	<%
	} else if (num < 0) {
	%>
	<p>음수를 입력했습니다</p>
	<%
	} else {
	%>
	<p>0을 입력했습니다</p>
	<%
	}
	}
	%>
	<%-- 양수, 0, 음수 확인 후 동적 페이지 출력 --%>
</body>
</html>
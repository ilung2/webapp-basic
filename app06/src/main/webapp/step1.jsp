<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("사용자 요청 처리 흐름을 확인합니다");
	System.out.println("첫번째 처리 흐름");
	
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		sum += i;
	}
	
	request.setAttribute("sum", sum);
	
/*	request.getRequestDispatcher("step2.jsp")
		.forward(request, response); */
%>
<jsp:forward page="step2.jsp"></jsp:forward>
<p>해당 내용을 적어도 출력되지 않습니다.</p>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" isErrorPage="true" %>
    <!-- isErrorPage : 이 페이지가 에러페이지 전용으로 사용되는지의 여부 -->
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 지시자, Directive -->
	<%
	
		Random rnd = new Random();
		Calendar c = Calendar.getInstance();
	
		//일부러 에러내기
		int num = 0;
		int result = 100 / num;
		
		
		
	%>




</body>
</html>













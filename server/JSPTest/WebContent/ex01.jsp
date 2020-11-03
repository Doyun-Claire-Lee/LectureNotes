<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>현재 시간</h1>
	
	<% 
		//자바 영역 
		Calendar now = Calendar.getInstance();
	%>
	
	<p><%= String.format("%tF", now) %></p>


</body>
</html>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<%@ include file="inc/header.jsp" %>
	
	<!-- 구구단 만들기 -->
	<%
		Random rnd = new Random();
		int dan = rnd.nextInt(8) + 2;	
	%>
	<h1><%= dan %>단</h1>
	
	<% for(int i=1; i<10; i++) { %>
	<div><%= dan %> X <%= i %> = <%= dan * i %></div>
	<% } %>


	<%@ include file="inc/footer.jsp" %>





</body>
</html>
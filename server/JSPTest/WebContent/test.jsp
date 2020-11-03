<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
	int age = 20;





%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>

	<div>안녕하세요. 저는 <%= name %>입니다.</div>
	<div>제 나이는 <%= age %>살 입니다.</div>
	<% for(int i=0; i<=3; i++) { %>
		<div>숫자: <%= i %></div>
	<% } %>
	
	
	<!-- 
	
	브라우저 소스보기(결과)
		<div>안녕하세요. 저는 홍길동입니다.</div>
		<div>제 나이는 20살 입니다.</div>
	
	 -->
	
	<script>


	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<div class="container"> 
	
		<% int dan = 2; %>
		
		<h1>구구단</h1>
		
		<!-- HTML기반에서 자바를 삽입하는 형태 -->
		<% for (int i=1; i<=9; i++) { %>
		<div><%= dan %> X <%= i %> = <%= dan * i %></div>
		<% } %>
		
		<hr>
		
		<%
			//출력 버퍼(임시 페이지)에 쌓여 있는 내용을 지우고 다시 시작하라는 뜻
			//out.clear();
			
			//출력 버퍼(임시 페이지)에 쌓는 작업을 종료하라는 뜻
			//out.close();
		
		%>
		
		<h1>구구단</h1>
		
		<%
			//자바 기반에서 HTML을 삽입하는 형태(out객체 이용)
			for (int i=1; i<=9; i++) {
				out.println(String.format("<div>%d X %d = %d</div>", dan, i, dan*i));
			}
		%>
	</div>
	
	
	<script>


	</script>
</body>
</html>
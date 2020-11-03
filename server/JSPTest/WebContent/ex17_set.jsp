<%@page import="java.util.Calendar"%>
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
	
		<h1>세션값 저장하기</h1>
		<%
		
			session.setAttribute("color", "blue");
			session.setAttribute("data", "jsp");
			
			Calendar now = Calendar.getInstance();
			session.setAttribute("now", now);
					
		%>
		<a href="ex17_session.jsp">돌아가기</a>
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
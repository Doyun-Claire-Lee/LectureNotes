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
	
		<h1>첫번째 페이지</h1>
		<%
			String name = "홍길동";
			request.setAttribute("name", name);
			//pageContext.forward("ex19_forward_two.jsp");

		%>
		<!-- JSP 액션 태그 -->
		<jsp:forward page="ex19_forward_two.jsp"></jsp:forward>
	
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
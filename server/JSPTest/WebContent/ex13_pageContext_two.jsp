<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp"%>
<style>
</style>
</head>
<body>
	<div class="container">
		<h1>두번째 페이지</h1>
		
		
		<div><%= request.getAttribute("num") %></div>
		<div><%= request.getAttribute("name") %></div>
		<div><%= request.getAttribute("age") %></div>
		
		<!--
			response.sendRedirect로 페이지 이동한 경우 : 세가지 다 null
				- null값이 나오는 이유? 첫번째 페이지의 request객체는 첫번째 페이지가 끝나며 소멸되고,
				  두번째 페이지가 시작되며 새로운 request 객체가 만들어지기 때문. (문맥이 바뀌기 때문)
		 -->
		 
		 
		<div><%= pageContext.getAttribute("color") %></div>
		<!-- 
			pageContext객체에 담은 데이터 -> null값을 반환
			내장객체의 생명주기 때문		
		 -->


	</div>


	<script>
		
	</script>
</body>
</html>
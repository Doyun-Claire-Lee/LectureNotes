<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<h1>결과</h1>
		<c:forEach items="${filename}" var="name">
			<div>${name}</div>
		</c:forEach>
	
		<br>
	
		<c:forEach items="${orgfilename}" var="name">
			<div>${name}</div>
		</c:forEach>
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
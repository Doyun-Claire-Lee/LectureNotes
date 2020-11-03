<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과</h1>
	
	<h2>Result : ${result}</h2>
	
	<hr>
	<div>${name}</div>
	
	<hr>
	<div>${dto.seq} / ${dto.name} / ${dto.age} / ${dto.etc}</div>
	
	<hr>
	<ul>
		<c:forEach items="${names}" var="name">
			<li>${name}</li>
		</c:forEach>
	</ul>
	
	<hr>
		<c:forEach items="${list}" var="dto">
			<div>${dto.seq} / ${dto.name} / ${dto.age} / ${dto.etc}</div>
		</c:forEach>
	
	
	
</body>
</html>
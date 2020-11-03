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
	
	<div>${count}</div>

	<div>
		<div><a href="/spring/member.action">회원 전용</a></div>
		<div><a href="/spring/memberinfo.action">회원 전용 정보</a></div>
	</div>
	
	<hr>
	
	<!-- 로그인 여부에 따라 분기 -->
	<c:if test="${empty id}">
		<div><a href="/spring/login.action">로그인</a></div>
	</c:if>
	<c:if test="${!empty id}">
		<div><a href="/spring/logout.action">로그아웃</a></div>
	</c:if>
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내장 객체 : request, response, pagaContext, session, out
	
	//request 객체 : 클라이언트가 보낸 정보를 받아주는 역할
	//response 객체 : 페이지 이동하기
	
	//페이지 이동 수단
	//1. HTML
	// 	- <a> : 사람이 직접 링크 클릭, 활용이 제한되어 있음(자유도가 낮음)
	//2. JavaScript
	// 	- location.href : 자유도 높은 이동이 가능, 프로그램에서 제어가 가능
	//3. Servlet/JSP
	//	- response.sendRedirect() : 자유도 높은 이동 가능, 프로그램에서 제어 가능
	
	
	//페이지 세장을 가지고 하나의 업무를 하는 경우가 있음.
	//A -> B -> C
	//A : 폼 페이지(글쓰기 페이지)
	//B : 데이터를 오라클에 보내는 페이지, 업무 페이지(DB작업)
	//C : 완료메세지(결과) 전달 페이지 (B페이지와 합치는 경우도 있음.)
	//  ==> 보통 B페이지에 resonpse.sendRedirect 메소드를 적어 놓음.


	//response.sendRedirect("ex12_response_two.jsp");

%>
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
	
	
	
	</div>
	
	
	<script>
		location.href = "ex12_response_two.jsp";

	</script>
</body>
</html>
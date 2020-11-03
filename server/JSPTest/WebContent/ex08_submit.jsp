<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<!-- 
	
	#웹서버에 존재하는 페이지를 요청하는 방식
		- 다양한 방식이 존재한다
		1. 요청 행동
		2. 요청 규칙
		- 웹서버는 클라이언트의 모든 요청이 특정 방식을 통한 요청이라 생각함.
		
		a. 링크 : GET방식 요청(서블릿 -> doGet() 호출)
		b. URL 직접 입력: GET방식 요청
		c. 새로고침 : GET 방식 요청
		d. 자바스크립트 사용 :  GET방식 요청
		e. <form method="GET"> : GET방식 요청
		f. <form method="POST"> : POST방식 요청
		
	 -->
	<h1>두번째 페이지(ex08_action.jsp) 요청</h1>
	
	<h2>링크 사용</h2>
	<a href="/jsp/ex08.do">두번째 페이지 요청하기</a>
	
	<h2>자바스트립트 사용</h2>
	<button type="button" onclick="location/href='/jsp/ex08.do';">
		두번째 페이지 요청하기
	</button>
	
	
	<h2>폼 사용</h2>
	<form action="/jsp/ex08.do" method="GET">
		<input type="submit" value="두번째 페이지 요청하기">
	</form>
	<form action="/jsp/ex08.do" method="POST">
		<input type="submit" value="두번째 페이지 요청하기">
	</form>
	
	
	
	
	
	<script>


	</script>
</body>
</html>
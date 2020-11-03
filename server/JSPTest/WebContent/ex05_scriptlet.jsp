<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//페이지 출력과 관계 없는 코드는 주로 상단의 스크립틀릿에서 작성 
		//자바 영역
		int a = 10;
		int b = 20;
		int sum = a + b;	
		
	%>
	<div style="font-size:<%= sum %>px;">합 : <%= sum %></div>
	
	
</body>
</html>
<%@page import="com.test.jsp.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!	//전역 영역(클래스 영역)

	public int sum(int a, int b) {
		return a + b;
	} 
	


%>
<%	//메소드 지역 영역

	//메소드 선언 --> 안됨!, 이 영역 자체가 어떤 메소드의 영역임.
	/* public int sum(int a, int b) {
		return a + b;
	} */
	
	//지역 변수
	int a = 10;
	int b = 20;
	
	Util util = new Util();

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


</style>
</head>
<body>

	<div><%= a %> + <%= b %> =  <%= a + b %></div>	
	<div><%= a %> + <%= b %> =  <%= sum(a, b) %></div>	
	<div><%= a %> + <%= b %> =  <%= util.sum(a, b) %></div>	
	
	
	<script>


	</script>
</body>
</html>
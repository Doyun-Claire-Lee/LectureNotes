<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현재 상황
	//- 요청 ~ 응답 사이에 지속적으로 특정 데이터를 유지해야 하는 상황
	//- one -> two 페이지로 넘어가는 상황
	
	//1. 지역 변수 사용
	int a = 10;
	
	//3. pageContext 사용
	pageContext.setAttribute("c", 30);
	
	//4. request 사용 - pageContext.foward()를 함께 사용해야 값이 전달됨
	request.setAttribute("d", 40);
	
	
	//session, application은 생명주기가 길어서 부담스러워서 잘 사용하진 않음..
	//5. session 사용 
	session.setAttribute("e", 50);
	
	//6. application 사용
	application.setAttribute("f", 60);
	
	
	//request, session, application값이 충돌할 때 -> 나중에 수업하기 
	//어쩔수 없는 상황일 때
	request.setAttribute("name", "홍길동");
	
	
	
%>    
<%!
	//2. 멤버 변수 사용 
	 int b = 20;
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
		<a href="ex18_two.jsp">두번째 페이지</a>
	
	
	</div>
	
	
	<script>	
		//location.href = "ex18_two.jsp";

	</script>
	<%
		//response.sendRedirect("ex18_two.jsp");
		pageContext.forward("ex18_two.jsp");
		
		
	%>
</body>
</html>
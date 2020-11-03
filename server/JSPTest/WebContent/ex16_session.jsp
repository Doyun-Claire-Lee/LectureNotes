<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session 데이터
	session.setAttribute("name", "홍길동");
	application.setAttribute("age", 20);	


	int num2 = 1;
	num2 = num2 + 1;

	if (session.getAttribute("num") == null) {
		session.setAttribute("num", 1);	
 	} else {
 		session.setAttribute("num", (int)(session.getAttribute("num")) + 1);
 	}
	
	if (application.getAttribute("num") == null) {
		application.setAttribute("num", 1);	
 	} else {
 		application.setAttribute("num", (int)(application.getAttribute("num")) + 1);
 	}


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
	
		<h1>세션, session</h1>
		<div><%= session.getAttribute("name") %></div>
		<div>방문 카운트: <%= session.getAttribute("num") %></div> 
		
		<h1>어플리케이션, application</h1>
		<div><%= application.getAttribute("age") %></div>
		<div>방문 카운트: <%= application.getAttribute("num") %></div> 
		<!-- 
			브라우저를 종료해도 마지막 유저의 세션의 타이머가 종료되지 않으면 어플리케이션도 소멸되지 않음.
			마지막 세션의 타이머가 종료되고 세션이 소멸되면 그때서야 어플리케이션도 소멸됨.
			=> 리셋하고 싶은 경우 서버(톰캣)를 종료하면 됨.		
		 -->
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
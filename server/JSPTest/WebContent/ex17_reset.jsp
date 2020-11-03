<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
		<h1>세션 초기화</h1>
		<%
			//초기화: 세션을 접속 처음 시점의 상태로 되돌리는 작업
			
			//session.removeAttribute("color");
			//session.removeAttribute("data");
		
			session.invalidate();	//초기화 메소드
			//세션 아이디가 바뀜. 기존의 세션 객체를 소멸시킨 후 재생성 
			
		%>
		<a href="ex17_session.jsp">돌아가기</a>
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
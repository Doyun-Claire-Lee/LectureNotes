<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//웹은 보통 페이지 단위로 코딩이 이루어짐. 따라서 페이지가 넘어가면 이전 페이지의 자원을 사용할 수 없음.

	//location, response : 문맥이 끊기며 이동 (클라이언트 이동)
	//pageContext : 문맥이 연결된 상태로 이동 (서버 이동, one페이지에서 사용하던 자원(request, response ONLY)을 죽이지 않고 two페이지로 이동)
	//				실제로 페이지는 이동되었지만 브라우저(클라이언트)입장에서는 페이지가 변경된 것이 아니기 때문에 URL이 그대로 유지됨.
	

	//DB접속 -> 데이터 가져온 상황 
	String name = "홍길동";
	int age = 20;
	
	//request, session, pageContext, application : 내부에 사용자 데이터를 저장할 수 있는 Map이 있음. 
	request.setAttribute("num", 100);	//request변수라고 함.(정식 용어는 X) 
	
	//request에 변수를 저장함.
	request.setAttribute("name", name);
	request.setAttribute("age", age);
	
	pageContext.setAttribute("color", "yellow");

	//response.sendRedirect("ex13_pageContext_two.jsp");
	pageContext.forward("ex13_pageContext_two.jsp");














%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp"%>
<style>
</style>
</head>
<body>
	<div class="container">
		<h1>첫번째 페이지</h1>
		<%= request.getAttribute("num") %>




	</div>


	<script>
		
	</script>
</body>
</html>
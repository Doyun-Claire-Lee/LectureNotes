<%@page import="java.util.Enumeration"%>
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
		
		<h1>request 정보</h1>
		<table class="table table-bordered">
			<tr>
				<th>헤더명</th>
				<th>헤더값</th>
			</tr>	
			<% 
				
				//request객체 - 헤더 정보를 가지고 있음.
				// - 웹에서 페이지를 요청할 때 전달되는 여러가지 정보
				
				Enumeration<String> e = request.getHeaderNames();
			
				while (e.hasMoreElements()) {
					
					String name = e.nextElement();
					//System.out.println(name);
					//System.out.println(request.getHeader(name));
			
			%>
			<tr>
				<td><%= name %></td>
				<td><%= request.getHeader(name) %></td>
			</tr>
			<% } %>
		
		</table>
		
		<hr>
		<p>서버 도메인명: 		<%= request.getServerName() %></p>
		<p>포트 번호: 			<%= request.getServerPort() %></p>
		<p>요청 URL: 			<%= request.getRequestURL() %></p>
		
		http://localhost:8090/jsp/ex11_request.jsp?name=hong
		<!-- 물음표 뒤에 있는 데이터를 가져오고 싶을 때, GET 방식으로 넘어간 데이터만 가져오고 싶을 때  -->
		<p>요청 쿼리: 			<%= request.getQueryString() %></p>
		
		<!-- 0:0:0:0:0:0:0:1 -> 로컬 호스트인 경우, 보통은 본인 컴퓨터의 IP주소가 찍힘. -->
		<p>클라이언트 호스트: 	<%= request.getRemoteHost() %></p>
		<p>클라이언드 IP: 		<%= request.getRemoteAddr() %></p>
		<p>프로토콜: 			<%= request.getProtocol() %></p>
		
		<p>요청 방식: 			<%= request.getMethod() %> </p>
		<p>컨텍스트 경로: 		<%= request.getContextPath() %>	</p>
	
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
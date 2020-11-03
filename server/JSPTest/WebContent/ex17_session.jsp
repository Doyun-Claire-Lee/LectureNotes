<%@page import="java.util.Calendar"%>
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
	
		<h1>세션 정보 확인</h1>
		
		<div>
			Session ID: <%= session.getId() %>
			<!-- 
				Session ID
				ex) 8DB2F01F0B916F0C63FF0A80ECD9D78F
					- 세션에 자동으로 달라붙는 식별자
					- 32자리 영문+숫자 난수, 중복되지 않음
					- 개발할 때 세션이 잘 유지 되는지 확인 정도의 역할(개발자는 잘 안씀)		
			 -->
		</div>
		<div>Session Max Inactive Interval(세션 만료 시간(초)): <%= session.getMaxInactiveInterval() %> sec</div>
		<div>
			Session Creation Time: 
			<% 
				long tick = session.getCreationTime();
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(tick);
				
				out.write(String.format("%tF %tT", c, c));
				
				//유저가 사이트에 머물러있던 시간
				long gap = System.currentTimeMillis() - tick;
				out.write("<div>" + (gap/1000) + "초</div>");
			%>
		</div>
		<div>Session isNew: <%= session.isNew() %></div>
		
		<% if (session.getAttribute("color") != null) { %>
		<div>color: <%= session.getAttribute("color") %></div>
		<div>data: <%= session.getAttribute("data") %></div>
		<% } else { %>
		<div>데이터 없음</div>
		<% } %>
		<hr>
		
		<div><a href="ex17_set.jsp">세션값 저장하기</a></div>
		<div><a href="ex17_del.jsp">세션값 삭제하기</a></div>
		<div><a href="ex17_reset.jsp">세션 초기화</a></div>
		<div><a href="ex17_interval.jsp">세션 만료시간 지정</a></div>
	
	
	
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
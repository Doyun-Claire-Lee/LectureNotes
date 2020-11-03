<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL 참조 구문 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
		<!-- 주석의 종류 -->
		<!-- 브라우저에서 처리하는 주석, 브라우저에서 소스보기를 하면 남음 -->
		<%-- 톰캣에서 처리하는 주석, 브라우저에서 소스보기를 해도 찾을 수 없음. 톰캣이 구문을 처리하면서 주석처리를 하고 반환하지 않기 때문에--%>

		<h1>JSTL + EL</h1>
		
		<h2>변수 선언</h2>
		
		<%
			//자바로 만들기
			int a = 10;							//지역변수
			pageContext.setAttribute("b", 20);	//pageContext변수
		%>
		
		<!-- JSTL변수 선언 -->
		
		<div>a: <%= a %></div>
		<div>b: <%= pageContext.getAttribute("b") %></div>
		<div>b: ${b}</div>	<!--EL방식, 내장객체변수만 사용할 수 있는 방식 -->
		<c:set var="c" value="30"></c:set>	
		
		
		<%--<div>c: <%= c %></div> 자바 변수가 아님, 에러남--%>
		<div>c: ${c}</div>									<!-- EL 방식으로 결과 확인 가능 -->
		<div>c: ${c}</div>									<!-- EL 방식으로 결과 확인 가능 -->
		<div>c: <%= pageContext.getAttribute("c") %></div>	<!-- JSTL변수는 자동으로 PageContext의 요소가 됨.(EL을 사용하기 위해) -->
		
		<h2>변수 수정</h2>
		
		<!-- 변수 생성 구문하고 동일함. 값이 덮어쓰기됨(HashMap과 유사) -->
		<c:set var="c" value="300"></c:set>
		<div>c: ${c}</div>			
	
		<h2>변수 삭제</h2>
		
		<!-- 일반 변수는 삭제할 수 없지만(생명주기가 끝나면 사라짐) JSTL 변수는 삭제가 가능. HashMap에 들어있는 요소를 삭제하는 것이기 때문 -->
		<c:remove var="c"/>
		<div>c: ${c}</div>			<!-- 실제로는 null값이지만 아무것도 찍히지 않음. (화면에 보이지 않도록 추가 조작이 되어있음.) -->
		<div>c: ${ empty c }</div>	<!-- 비어있는 변수인지 t/f값을 반환해주는 명령어 -->
		<div>b: ${ empty b }</div>
		
		<%
			Random rnd = null;
		%>
		<c:set var="d"/>
		<div>rnd: <%= rnd %></div>
		<div>d: ${d}</div>
		
		<hr>
		
		<h2>조건문</h2>
		<c:set var="n" value="10"/>
		<div>n: ${n}</div>
			
		<c:if test="${n > 0}">
		<div>${n}은 양수입니다.</div>
		</c:if>
		
		<!-- 톰캣(서버)에서 처리할 때 조건을 만족하지 못하는 구문은 HTML로 돌려주지도 않음.(소스보기에서 확인 불가) -->
		<c:if test="${n < 0}">
		<div>${n}은 음수입니다.</div>
		</c:if>
		
		
		<!-- 다중 if문 -->
		<c:choose>
			<c:when test="${n > 0}">양수</c:when>
			<c:when test="${n < 0}">음수</c:when>
			<c:otherwise>0</c:otherwise>
		</c:choose>
		
		
		<h2>반복문(일반 for문 + 향상된 for문)</h2>
		
		<h3>일반 for문</h3>
		<c:forEach var="i" begin="1" end="10" step="1">	<!-- step값에 음수 사용 불가능!! -->
			<div>${11-i}</div>
		</c:forEach>
		
		<h3>향상된 for문</h3>
		
		<%
			String[] color = {"빨강", "노랑", "파랑", "검정", "하양"};
			
			//자바 자원을 JSTL로 접근하기? -> 자원이 내장 객체 안에 들어있어야 함. -> 자바 자원을 내장객체의 변수로 등록 
			pageContext.setAttribute("color", color);
		%>
		
		<!-- 자바 구문으로 구현하기 -->
		<ul>
		<% for (String name : color) { %>
			<li><%= name %></li>
		<% } %>
		</ul>
		
		<!-- JSTL로 구현하기 -->
		<ul>
			<c:forEach var="name" items="${color}">
				<li>${name}</li>
			</c:forEach>
		</ul>
		
		
	</div>
	
	
	<script>


	</script>
</body>
</html>
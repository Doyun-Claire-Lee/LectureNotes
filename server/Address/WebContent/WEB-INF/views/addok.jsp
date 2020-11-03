<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/inc/asset.jsp" %>
<style>

</style>

</head>
<body>
	<div class="container"> 
	
		<%@ include file="/inc/header.jsp" %>
		
		<div class="content">
		
			<!-- 결과메세지 출력 : HTML or JavaScript or X -->
			
			
			<c:if test="${result == 1}">
			<div>주소록 등록을 성공했습니다.</div>
			<div><a href="/address/list.do">목록보기</a></div>
			</c:if>
			
			<c:if test="${result == 0 || empty result}">
			<div>주소록 등록을 실패했습니다.</div>
			<div><a href="#" onclick="history.back();">돌아가기</a></div>
			</c:if>
		
		</div>
		
	</div>
	
	
	<script>


	</script>
</body>
</html>
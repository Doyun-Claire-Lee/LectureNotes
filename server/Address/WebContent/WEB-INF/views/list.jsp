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
		
			<%-- ${list.size()} --%>
			<%-- <ul>
				<c:forEach items="${list}" var="address">
				<li>${address.name}</li>
				</c:forEach>
			</ul> --%>
		
			<table class="table table-bordered list">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>주소</th>
					<th>등록일</th>
					<th>조작</th>
					
				</tr>
				<c:forEach items="${list}" var="address">
					<tr>
						<td>${address.seq}</td>
						<td>${address.name}</td>
						<td>${address.age}</td>
						<td>${address.address}</td>
						<td>${address.regdate}</td>
						<td>
							<button type="button" class="btn btn-primary" onclick="location.href='/address/edit.do?seq=${address.seq}';">수정</button>
																			  <!-- GET방식의 데이터 송신 : URL에 담기 -->
							<button type="button" class="btn btn-primary" onclick="location.href='/address/del.do?seq=${address.seq}';">삭제</button>
							
						</td>
						
					</tr>
				</c:forEach>
				
			</table>
		
				<div class="btns">
					<button type="button" class="btn btn-primary" onclick="location.href='/address/add.do';">쓰기</button>
				</div>
		</div>
		
	</div>
	
	
	<script>


	</script>
</body>
</html>
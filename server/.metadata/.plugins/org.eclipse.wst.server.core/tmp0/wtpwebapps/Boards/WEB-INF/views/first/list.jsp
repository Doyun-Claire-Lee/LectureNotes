<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		width: 1200px;
		margin: 30px auto;
		color: #333;
	}
	table {
		border: 1px solid #333;
		border-collapse: collapse;
		width: 100%;
		text-align: center;
	}
	table th {
		background-color: rgb(82, 82, 82);
		color: #eee;
	}
	table tr {
		height: 40px;
	}
	table tbody tr:hover {
		background-color: rgb(236, 192, 192);
		cursor: pointer;
	}
	table th, table td {
		border: 1px solid #333;
	}
	table td:nth-child(2) {
		text-align: left;
		padding-left: 10px;
	}
	table th:nth-child(1) {width: 8%;}
	table th:nth-child(2) {width: 56%;}
	table th:nth-child(3) {width: 12%;}
	table th:nth-child(4) {width: 17%;}
	table th:nth-child(5) {width: 7%;}
	
	.btn {
		border: 1px solid rgb(95, 95, 95);
		border-radius: 2px;
		color:rgb(95, 95, 95);
		background-color: rgb(236, 192, 192);
		height: 30px;
		width: 100px;
		text-align: center;
		float: left;
		padding-top: 5px;
		cursor: pointer;
	}
	.right {
		float: right;
	}
	span.search {
		color:rgb(202, 124, 124);
		font-weight:bold;
	}
	
</style>
</head>
<body>
	
	<div class="container">
		<h1>BOARD <small>List</small></h1>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr onclick="location.href='/boards/first/view?seq=${dto.seq}';">
						<td>${dto.seq}</td>
						<td>${dto.title}</td>
						<td>${dto.writer}</td>
						<td>${dto.regdate}</td>
						<td>${dto.viewcount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div style="width:100%; height:40px; margin-top:30px;">
			<div class="btn right" onclick="location.href='/boards/first/write.do?mseq=${mseq}';">글쓰기</div>
			<div class="btn right" onclick="location.href='/boards/first/list.do';">목록보기</div>
			
			<form method="GET" action="/boards/first/list.do" id="searchform">
				<div><input type="text" id="search" name="search" style="height:30px;" value="${search}"><div class="btn" onclick="document.getElementById('searchform').submit();">검색하기</div></div>
			</form>
		</div>
		<div id="pagebar"></div>
	</div>
	
	<script>


	</script>
</body>
</html>
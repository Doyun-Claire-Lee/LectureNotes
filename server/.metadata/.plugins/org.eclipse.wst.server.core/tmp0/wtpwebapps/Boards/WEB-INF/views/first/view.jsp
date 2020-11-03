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
	table th, table td {
		border: 1px solid #333;
		padding-left: 10px;
	}
	table th {
		background-color: rgb(82, 82, 82);
		color: #eee;
	}
	table tr {
		padding: 10px;
		height: 40px;
	}
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
	.btn.right {
		float: right;
	}
	
</style>
</head>
<body>
	<div class="container"> 
		<h1>BOARD <small>view</small></h1>
		<table>
			<tr>
				<th style="width: 15%;">글쓴이</th>
				<td style="width: 15%;">${dto.writer}</td>
				<th style="width: 15%;">작성일</th>
				<td style="width: 25%;">${dto.regdate}</td>
				<th style="width: 15%;">조회수</th>
				<td style="width: 15%;">${dto.viewcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="5" style="text-align: left;">${dto.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5" style="text-align: left; padding: 30px;">${dto.content}</td>
			</tr>
		</table>
		<br>
		<div style="width:100%; height:40px;">
			<div class="btn" onclick="location.href='/boards/first/list.do';">목록보기</div>
			<div class="btn right" onclick="location.href='/boards/first/delete.do?seq=${dto.seq}';">삭제하기</div>
			<div class="btn right">수정하기</div>
			<div style="clear: both;"></div>
		</div>

	</div>
	
	
	<script>


	</script>
</body>
</html>
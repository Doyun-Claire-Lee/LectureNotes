<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	table th, table td {
		border: 1px solid #333;
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
	.right {
		float: right;
	}
	input, textarea {
		border: 0px;
		outline: none;
		font-family: "맑은 고딕";
		font-size: 16px;
	
	}
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>Board <small>Write</small></h1>
		<form method="POST" action="/boards/first/writeok.do" id="writeform">
			<table>
				<tr>
					<th style="width: 15%;">제목</th>
					<td style="width: 85%;"><input type="text" name="title" style="width: 95%;"></td>
				</tr>
				<tr>
					<th style="height: 300px;">내용</th>
					<td style="padding:30px;"><textarea name="content" id="content" cols="100" rows="20" style="width: 95%;"></textarea></td>
				</tr>
			</table>
			<input type="hidden" name="mseq" value="${mseq}">
			<div style="height: 40px; margin-top:30px;">
				<div class="btn" onclick="location.href='/boards/first/list.do';">목록보기</div>
				<div class="btn right" onclick="document.getElementById('writeform').submit();">등록하기</div>
			</div>
		</form>
	
	
	</div>
	
	
</body>
</html>
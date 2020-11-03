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
	
		<h1>다중 파일 업로드</h1>
	
		<form method="POST" enctype="multipart/form-data" action="/jsp/ex23_formok.do">
		
			<div>제목: <input type="text" name="subject"></div>
			<div>이름: <input type="text" name="name"></div>
			
			
			<div>첨부파일: <input type="file" name="attach1"></div>
			
			<div id="filelist"></div>
			<br>
			<input type="button" value="첨부파일 추가하기" id="btnAdd">
			
			<hr>
			<button>등록하기</button>
		
		</form>
	
	
	</div>
	
	
	<script>
	
		var no = 2;
		$("#btnAdd").click(function () {
			
			$("#filelist").append("<div>첨부파일: <input type=\"file\" name=\"attach" + no + "\"></div>");
			no++;
		})

	</script>
</body>
</html>
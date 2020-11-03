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
		
		<h1>업로드 결과</h1>
		
		<div>제목: ${subject}</div>
		<div>이름: ${name}</div>
		<div>첨부파일명: ${filename}</div>
		<div>첨부파일명: ${orgfilename}</div>
		
		<hr>
		
		<a href="/jsp/files/${filename}" download>다운로드</a>
		<!-- a태그 안에 download 속성을 넣어주면 첨부파일이 자동으로 열리지 않고 다운로드됨. -->
	
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
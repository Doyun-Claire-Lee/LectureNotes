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
	
		<h1>파일 업로드</h1>
		
		
		
			<!-- 
				파일을 첨부하게 되면 2진법으로 변환되어(바이너리) 전송됨. 
				따라서 라이브러리를 사용해서 파일 업로드/다운로드를 관리함.
				cos.jar -> 아파치 재단에서 관리, 무료(보통 유료 라이브러리를 많이 사용함.)
					- 무료, 파일 업로드 라이브러리				
				
				1. 반드시 <form method="POST">를 사용한다.(GET방식은 짤리게됨)
				2. enctype 속성을 명시한다. (encoding type)
					- enctype="multipart/form-data"					-> 설정해야 하는 값(전송값이 바이러니 데이터일때 인코딩 하는 방식)
					- enctype="application/x-www-form-urlencoded"	-> 기본값(전송값이 문자열일때 인코딩 하는 방식)
				
			 -->
			 
		<form method="POST" enctype="multipart/form-data" action="/jsp/ex22_formok.do">
		
			<div>제목: <input type="text" name="subject"></div>
			<div>이름: <input type="text" name="name"></div>
			<div>첨부파일: <input type="file" name="attach"></div>
			<hr>
			<button>등록하기</button>
		
		</form>
	
	
	</div>
	
	
	<script>


	</script>
</body>
</html>
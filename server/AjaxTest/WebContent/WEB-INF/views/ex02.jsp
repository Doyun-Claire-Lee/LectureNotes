<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

	.container {
		width: 900px;
	}
	
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>Ajax</h1>
		
		<!-- 
		
		[기본 방식] 
		-> 페이지가 바뀜. (ex02.do -> ex02.jsp -> ex02ok.do -> ex02.do -> ex02.jsp)
		
		1. 버튼을 누른다
		2. 입력값을 서버로 전송한다
		3. 서버> 입력값을 DB값을 더한 후 반환한다.
		4. 반환된 값을 화면에 출력한다.		
		 	
		 	=> 문제점 : 페이지가 바뀌며 브라우저가 깜빡임. 작업 상황을 유지하지 못하게 됨(********)
		
		-->
		
		<form method="POST" action="/ajax/ex02ok.do">
			<input type="text" name="txt1" id="txt1">
			<input type="submit" value="버튼" id="btn1">
			<div id="result1">결과: <span>${result}</span></div>
		</form>	

		<hr>			
		다른 작업: <input type="text">
	
	
	</div>
	
	
	
	<script>


	</script>
</body>
</html>
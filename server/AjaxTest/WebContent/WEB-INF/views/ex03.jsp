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
		
		<form>
			<input type="text" name="txt1" id="txt1">
			<input type="button" value="버튼" id="btn1">
			<div id="result1">결과: <span></span></div>
		</form>	

		<hr>			
		다른 작업: <input type="text">
	
	
	</div>
	
	
	
	<script>
		/*
		
		Ajax
	
		1. 순수 자바스크립트로 구현
		2. 각종 라이브러리 사용
		
		*/
	
		$("#btn1").click(function() {
			
			//1. 서버에 데이터 보내기
			//2. 서버로부터 데이터 받기
		
			//var xhr = new XMLHttpRequest(); 	//ajax 객체, 순수 자바스크립트로 구현했을때의 모습
			//$.ajax();							//jquery로 구현, 전역 함수같은 느낌 
			
			$.ajax({		//요청의 주체 : 브라우저가 아닌 Ajax!!, 따라서 데이터를 돌려받을때도 Ajax가 받아야 함.
				
				//페이지 요청
				type: "POST",
				url: "/ajax/ex03ok.do",
				
				//동기 vs 비동기
				// - ajax는 비동기(true) 방식을 주로 씀. (99%)
				async : false,
				
				
				//페이지 요청 + 데이터 전달하기
				data: "txt1=" + $("#txt1").val(),
				
				//요청  + 결과 반환(응답)
				success: function(result) {
					//alert(result);
					$("#result1 > span").text(result);				
				},
				
				//ajax 에러 처리
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
		});
	

	</script>
</body>
</html>
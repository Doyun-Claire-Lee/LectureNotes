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
		
		<h1>Ajax 응답 데이터</h1>
		
		<!-- 용도가 정해져 있지는 않고 쓰고싶은 걸로 쓰면 됨. -->
		
		
		<h2>Text</h2>
		<button type="button" id="btn1">클릭</button>
		<div id="result1" class="well"></div>
		
		
		<h2>XML</h2>
		<button type="button" id="btn2">클릭</button>
		<div id="result2" class="well"></div>

		
		<h2>JSON</h2>
		<button type="button" id="btn3">클릭</button>
		<div id="result3" class="well"></div>
		
		<h2>다량의 데이터(text)</h2>
		<button type="button" id="btn4">클릭</button>
		<div id="result4" class="well"></div>
		
		<h2>다량의 데이터(xml)</h2>
		<button type="button" id="btn5">클릭</button>
		<div id="result5" class="well"></div>
	
		<h2>다량의 데이터(json)</h2>
		<button type="button" id="btn6">클릭</button>
		<div id="result6" class="well"></div>
	
	
	</div>
	
	
	<script>
	//ajax를 이용하여 총 게시물 수를 수신함.

	//text로 수신
	$("#btn1").click(function() {
			
		$.ajax({
			//요청 정보
			type: "GET",
			url: "/ajax/ex04ok.do",
			
			//전송 데이터
			data: "type=1",
			
			//수신할 데이터의 형식 
			dataType: "text",
			
			//수신 데이터
			//성공하면 해당 함수가 실행되고, result에 데이터를 받아온다
			success: function(result) {
				$("#result1").text(result);
				
			},
			
			//예외처리
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});

	//xml로 수신
	$("#btn2").click(function() {
			
		$.ajax({
			type: "GET",
			url: "/ajax/ex04ok.do",
			data: "type=2",
			dataType: "xml",
			success: function(result) {
				//result -> 단순한 객체가 아닌 XML Document 객체임. (문서 객체 -> 소스를 모두 가지고 있는 객체!)
				$("#result2").text($(result).find("item").text());
			
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});

	//json으로 수신
	$("#btn3").click(function() {
			
		$.ajax({
			type: "GET",
			url: "/ajax/ex04ok.do",
			data: "type=3",
			dataType: "json",
			success: function(result) {
				//result = {"result":"111"} 과 같은 형태로 들어있음.
				$("#result3").text(result.result);
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});
	
	//많은 데이터 반환하기 (실제로 text 형식으로는 잘 쓰지 않음..)
	$("#btn4").click(function() {
		
		$.ajax({
			type: "GET",
			url: "/ajax/ex04ok.do",
			data: "type=4",
			dataType: "text",
			success: function(result) {
				
				//텍스트로 결과를 받아와서 엔터로 잘라 배열에 넣어줌
				var lines = result.split("\n");
				
				//받아준 배열에서 콤마단위로 잘라서 출력해줌
				lines.forEach(function(item, index) {
					
					console.log(item);
					var column = item.split(",")
					$("#result4").append("<div>(" + column[0] + ")" +  column[1] + "[" +  column[2] + "]</div>");
					
				});
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});

	//많은 데이터 반환하기(xml) 
	$("#btn5").click(function() {
		
		$.ajax({
			type: "GET",
			url: "/ajax/ex04ok.do",
			data: "type=5",
			dataType: "xml",
			success: function(result) {
				$(result).find("item").each(function(index, item) {
					$("#result5").append("<div>" + $(item).find("seq").text()+ "." + $(item).find("subject").text() + "</div>");
				})			
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});
	
	$("#btn6").click(function() {
		
		$.ajax({
			type: "GET",
			url: "/ajax/ex04ok.do",
			data: "type=6",
			dataType: "json",
			success: function(result) {
				//result = [{}, {}, {}] 와 같은 형태로 결과를 받아옴.
				$(result).each(function(index, item){
					$("#result6").append("<div>" + item.seq + "." + item.subject + "</div>");
				});
						
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		})
	});
	</script>
</body>
</html>
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

.item {
	margin: 10px;
	padding: 5px;
	text-align: right;
	border-left: 7px solid #ccc;
	padding-right: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
}
</style>
</head>
<body>
	<div class="container">

		<h1>설문조사(결과)</h1>

		<div class="panel panel-default">
			<div class="panel-heading">Q. ${dto.question}</div>
			<div class="panel-body">
				<div class="item bg-info" id="item1">
					${dto.item1} <span class="badge">${dto.cnt1}</span>
				</div>
				<div class="item bg-success" id="item2">
					${dto.item2} <span class="badge">${dto.cnt2}</span>
				</div>
				<div class="item bg-warning" id="item3">
					${dto.item3} <span class="badge">${dto.cnt3}</span>
				</div>
				<div class="item bg-danger" id="item4">
					${dto.item4} <span class="badge">${dto.cnt4}</span>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				또 다른 내용
			</div>
			<div class="panel-body">
				<input type="text" class="form-control">
			</div>
		</div>
	
	<script>
		
		$("#item1").css("width", "${dto.cnt1 * 40}px");	
		$("#item2").css("width", "${dto.cnt2 * 40}px");	
		$("#item3").css("width", "${dto.cnt3 * 40}px");	
		$("#item4").css("width", "${dto.cnt4 * 40}px");	
		
		/*
		//DB에서 변경된 사항을 페이지에도 새로 반영하기 위해 5초 간격으로 새로고침 해주기 위하여 타이머를 설정해줌.
		//그러나 다른 요소들이 한 페이지에 있을 경우 그 요소도 같이 새로고침되어 사용자에게 불편을 야기함.. 
		// -> 이 불편을 해결하기 위해 Ajax 사용!
		setTimeout(function() {
			location.reload();		
		}, 5000);
		*/
		
		setInterval(function () {
			
			$.ajax ({
				
				type: "POST",
				url: "/ajax/ex01ok.do",
				data: "seq=1",				//가져올 설문조사 번호
				success: function(result) {
					//받고 싶은 데이터 : 투표수 4개
					//7,10,2,5	--CSV 형태로 받아오기
					
					var item = result.split(",");
					
					item.forEach(function(item, index) {
						$("#item" + (index+1)).css("width", (item * 40) + "px");	
					});
					
				},
				error: function(a, b, c) {
					console.log(a, b, c);
				}
			});
			
		}, 5000);
		

	</script>
</body>
</html>
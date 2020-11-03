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
		
		<h1>우편 번호 검색하기</h1>
		<table class="table table-bordered">
			<tr>
				<th>주소 검색</th>
				<td>
					<input type="text" name="search" id="search" class="form-control">
					<button type="button" id="btnSearch" class="btn btn-default">검색</button>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<select name="address1" id="address1" class="form-control"></select>
				</td>
			</tr>
			<tr>
				<th>상세 주소</th>
				<td>
					<input type="text" name="address2" id="address2" class="form-control">
				</td>
			</tr>
		</table>
	
	
	</div>
	<script>
	
		
		$("#btnSearch").click(search);
		$("#search").keyup(function(evt) {
			if (evt.keyCode == 13) {
				search();
			}
		});
		
		function search() {
			//검색어를 서버로 전송하고, DB작업을 통해 목록을 반환받고, select태그에 출력하기
			//화면 깜빡임 없이! -> ajax로 구현
			
			$.ajax({
			
				type: "GET",
				url: "/ajax/ex06ok.do",
				data: "search=" + $("#search").val(),
				dataType: "json",
				success: function(result) {
					//목록 수신 + 처리
					//result -> 객체 배열
					
					//목록 처리 전 셀렉트박스의 내용 지우기(초기화)
					$("#address1").html("");
					
					//목록 추가하기
					$(result).each(function(index, item) {
						
						$("#address1").append("<option>[" + item.zipcode + "]" + item.sido + " " + item.gugun + " " + item.dong + " " + item.bunji + "</option>");
					});
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
			});
		}
		
		//주소를 선택하면 상세주소 박스로 포커스 옮기기
		$("#address1").change(function() {
			$("#address2").focus();
		});
		
	</script>
</body>
</html>
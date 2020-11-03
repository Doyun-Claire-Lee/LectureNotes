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
	.result td:nth-child(1) { width: 170px;}
	.result td:nth-child(2) { width: auto;}
	.result td:nth-child(3) { width: 130px;}
	.result td:nth-child(4) { width: 140px;}
	.result td:nth-child(5) { width: 150px;}
	
</style>
</head>
<body>
	<div class="container"> 
		
		<!-- 
		
		오픈 API, Application Programming Interface
		- 프로그램을 만들 때 제공되는 여러가지 기능
		- 개발하는 데 필요한 라이브러리에 가까운 개념
		- 오픈 : 웹 혹은 네트워크 환경에서 언제 어디서든 접근해서 기능을 사용할 수 있다는 의미
		
		=> 정해진 표준이 없기 때문에 열심히 공부할 필요는 없다..
		
		 -->
	
		<h1>네이버 도서 검색</h1>
		
		<div class="well">
			<input type="text" name="word" id="word" class="form-control" placeholder="검색어를 입력하세요.">
		</div>
		<hr>
		<table class="result table table-bordered">
			<thead>
				<tr>
					<th>표지</th>
					<th>제목</th>
					<th>저자</th>
					<th>가격</th>
					<th>출판사</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<hr>
		<input type="button" value="다음 10권 보기" id="btnNext" class="btn btn-warning">
	
	</div>
	
	
	<script>
		
		
		var start = 1;	//페이징을 위한 전역변수, 시작값
	
		$("#word").keyup(search);
		
		$("#btnNext").click(function() {
			start += 10;
			search(1);
		});
		
		function search(n) {
			
			var word= $("#word").val();
			
			if (n == 1 || event.keyCode == 13) {
				
				if (word.trim().length > 0) {
					
					//기존 검색결과 초기화
					$(".result tbody").html("");
					
					$.ajax({

						type:"GET",
						//url: "https://openapi.naver.com/v1/search/book.json", -> 에러나며 안됨, 클라이언트(로컬호스트)와 API 서비스 주체(네이버)의 도메인이 다르기 때문?
						url: "/ajax/ex10ok.do",
						data: "query=" + word + "&start=" + start,
						dataType: "json",
						success: function(result) {
							$(result.items).each(function(index, item) {
								console.log(item.title);
								var temp = "";
								temp += "<tr>";
								temp += "<td><img src='" + item.image + "' style='width: 80px; display: block; margin: 5px auto;'></td>";
								temp += "<td>" + item.title + "</td>";
								temp += "<td>" + item.author + "</td>";
								temp += "<td><s>" + item.price + "원</s><br> " + item.discount + "원</td>";
								temp += "<td>" + item.publisher + "</td>";
								temp += "</tr>";
								$(".result tbody").append(temp);								
							});
						},
						error: function(a,b,c) {
							console.log(a,b,c);
						}
						
					});	//ajax 끝
				}
			}
		}
	</script>
</body>
</html>
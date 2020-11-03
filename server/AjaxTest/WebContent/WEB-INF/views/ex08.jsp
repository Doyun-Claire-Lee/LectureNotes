<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		width: 600;
	}
	
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>게시판 목록보기</h1>
	
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto" >
				<tr>
					<td>${dto.seq}</td>
					<td>${dto.subject}</td>
					<td>${dto.name}</td>
					<td>${dto.regdate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div>
			<button type="button" id="btnMore">더보기</button>
		</div>
	
	</div>
	<script>
	
		var begin = ${map.begin + 10};
		var end = ${map.end + 10};
	
		$("#btnMore").click(function() {
			
			$.ajax({
			
				type: "GET",
				url: "/ajax/ex08ok.do",
				data: "begin=" + begin + "&end=" + end,
				dataType: "json",
				success: function(result) {
										
					//데이터 받아와서 가공처리
					$(result).each(function(index, item) {
						var temp = "";
						temp += "<tr>";
						temp += "<td>"+ item.seq + "</td>";
						temp += "<td>"+ item.subject + "</td>";
						temp += "<td>"+ item.name + "</td>";
						temp += "<td>"+ item.regdate + "</td>";
						temp += "</tr>";
						$("table > tbody").append(temp);
					});
					
				},
				error: function(a,b,c) {
					
					//더이상 가져올 페이지가 없을 경우 원래는 ok페이지에서 list.size가 0일 경우 그에 맞는 json 형식을 만들어서 돌려줘야 함.
					alert("더이상 가져올 게시물이 없습니다.");
					$("#btnMore").attr("disabled", true);
					
					console.log(a,b,c);
				}
			});	//ajax
			
			
			begin += 10;
			end += 10; 
		});

	</script>
</body>
</html>
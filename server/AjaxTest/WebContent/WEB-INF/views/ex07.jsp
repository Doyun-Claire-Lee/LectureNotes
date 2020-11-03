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
<script src="/ajax/js/jquery-ui.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

	.container {
		width: 900px;
	}
	
</style>
</head>
<body>
	<div class="container"> 
		
		<img src="/ajax/images/catty01.png" id="cat1" class="cat">
		<img src="/ajax/images/catty02.png" id="cat2" class="cat">
		<img src="/ajax/images/catty03.png" id="cat3" class="cat">
		
	
	
	</div>	
	
	 
	<script>
		$(".cat").draggable({
			stop: function(event, ui) {
				//사용자가 드래그를 멈추면 좌표값을 서버로 전송하기
				$.ajax({
					
					type:"GET",
					url: "/ajax/ex07ok.do",
					data: "catid=" + this.id + "&x=" + ui.position.left + "&y=" + ui.position.top,
					success: function(result) {
						//데이터베이스 성공 여부를 반환받기
						if (result == 0) {
							alert("고양이 정보 저장에 실패했습니다.");
						}
					},
					error: function(a,b,c) {
						console.log(a,b,c);
					}
				});	
			}
			
		});
		
		<c:forEach items="${list}" var="dto">
		$("#${dto.catid}").css({
			"left": "${dto.x}px",
			"top": "${dto.y}px"
		});
		</c:forEach> 
	</script>
</body>
</html>
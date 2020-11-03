<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/inc/asset.jsp" %>
<style>

</style>

</head>
<body>
	<div class="container"> 
	
		<%@ include file="/inc/header.jsp" %>
		
		<div class="content">
		
			<form method="POST" action="/address/addok.do">
				<table class="table table-bordered add">
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" id="name" class="form-control short" required="required"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="number" name="age" id="age" class="form-control short" required="required"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="address" id="address" class="form-control" required="required"></td>
					</tr>
				</table>
				<div class="btns">
					<button type="submit" class="btn btn-primary">쓰기</button>
					<button type="button" class="btn btn-default" onclick="history.back();">돌아가기</button>
				</div>
				
				
			
			
			
			</form>
		
		
		
		</div>
		
	</div>
	
	
	<script>
	
		function dummy() {
			$("#name").val("홍길동");			
			$("#age").val("20");			
			$("#address").val("서울시 강동구 명일동");			
		}
		dummy();
	</script>
</body>
</html>
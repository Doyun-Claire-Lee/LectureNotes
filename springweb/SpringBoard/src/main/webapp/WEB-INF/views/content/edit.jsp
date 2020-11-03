<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.table th {width:150px;}
	.table td {width:650px;}
	.table textarea[name='content'] {height:300px;}
	.filename {
		text-align: left;
		margin:	5px 0px 0px 5px;
	}

</style>
    
<div class="content">
	
	<form method="POST" action="/spring/editok.action" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" class="form-control" required value="${dto.subject}"}></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" class="form-control" required>${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>언어</th>
				<td>
					<select name="cseq" class="form-control" id="cseq">
						<c:forEach items="${clist}" var="cdto">
							<option value="${cdto.seq}">${cdto.name}</option>	
						</c:forEach>				
					</select>
					
					
				</td>
			</tr>
			<tr>
				<th>코드</th>
				<td>
					<input type="file" name="attach" class="form-control" required>
					<div class="filename">첨부 파일 : ${dto.filename}</div>
					<!-- 파일을 새로 업로드 할 수도, 아닐 수도 있음. 경우의 수가 많기 때문에 기존 파일이름을 넘겨줌 -->
					<input type="hidden" name="filename" value="${dto.filename}">
				</td>
			</tr>		
		</table>
		<div class="btns">
			<input type="submit" value="수정하기" class="btn btn-default">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/view.action?seq=${dto.seq}';">
		</div>
		<input type="hidden" name="seq" value="${dto.seq}">
	</form>
	
	
</div>
<script>
	document.getElementById("cseq").value = "${dto.cseq}";
</script>
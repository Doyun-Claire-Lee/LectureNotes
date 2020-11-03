<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<style>
	.right {
		float: right;
	}
	.container {
		width: 1000px;
	}
	table {
		font-size : 0.6em;
	}
	table thead th {
		background-color: #555;
		color: #eee;
		text-align: center;
	}
	table tbody td { 
		text-align: center;
	}
	table tbody td:nth-child(4) {
		text-align: left;
	}

</style>
<div id="content">
	<div class="container">
		<h1>직원 조회</h1>
		<div>
			<input type="button" class="btn btn-default right" value="+ 직원 추가" onclick="location.href='/erpos/hr/addemployee.action';">
		</div>
		<table class="table table-bordered table-hover">
			<thead>
			<tr>
				<th>이름</th>
				<th>직급</th>
				<th>연락처</th>
				<th>주소</th>
				<th>상세보기</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.name}</td>
						<td>${dto.position}</td>
						<td>${dto.tel}</td>
						<td>${dto.address}</td>
						<td><input type="button" class="btn btn-default" value="상세보기" onclick="location.href='/erpos/hr/viewemployee.action?seq=${dto.seq}';"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>
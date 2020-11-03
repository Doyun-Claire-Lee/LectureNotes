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
	input[type='date'] {
		width: 200px;
		display: inline;
		
	}
	.period-box {
		height: 55px;
		background-color: #eee;
		width: 100%;
		margin: 10px auto;
		border-radius: 5px;
		font-size: 0.8em;
		vertical-align: middle;
		padding-top: 10px;
		padding-left: 10px;
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
		<h1>출퇴근 기록 조회</h1>
		
		<div class="period-box">
			기간 검색 : 
			<input type="date" class="form-control"> ~ 
			<input type="date" class="form-control">
			<input type="button" class="btn btn-default" value="조회" >
		</div>
		<table class="table table-bordered table-hover">
			<thead>
			<tr>
				<th>이름</th>
				<th>직급</th>
				<th>출근시각</th>
				<th>확인</th>
				<th>퇴근시각</th>
				<th>확인</th>
			</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
	</div>
	
</div>
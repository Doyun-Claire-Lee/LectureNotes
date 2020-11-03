<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/spring/resources/css/prism.css">
<script src="/spring/resources/js/prism.js"></script>
<style>
	.table th {width:150px;}
	.table td {width:650px; text-align:left;}
	.table textarea[name='content'] {height:300px;}
	pre {width: 630px;}


</style>
    
<div class="content">

	<table class="table table-bordered">
		<tr>
			<th>글번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<tr>
			<th>언어</th>
			<td>${dto.cname}</td>
		</tr>
		<tr>
			<th>코드</th>
			<td><pre class="line-numbers" data-src="/spring/files/${dto.filename}" data-download-link><code class="language-${dto.ctype}">${code}</code></pre></td>
		</tr>		
	</table>
	<div class="btns">
		<input type="button" value="수정하기" class="btn btn-default" onclick="location.href='/spring/edit.action?seq=${dto.seq}';">
		<input type="button" value="삭제하기" class="btn btn-default" onclick="location.href='/spring/delete.action?seq=${dto.seq}';">
		<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/spring/list.action';">
	</div>
	
	
</div>
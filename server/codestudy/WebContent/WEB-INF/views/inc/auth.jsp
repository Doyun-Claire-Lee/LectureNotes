<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 로그인을 했는지? 안했는지? -->
<c:if test="${not empty id}">

	<div class="login panel panel-default">
		<div class="panel-heading">
			인증 <small>Auth</small>
		</div>
		<div class="panel-body">
			<div class="pic" style="background-image: url('/codestudy/pic/${pic}');"></div>
			<div class="itemlist">
				<div class="item">${name}(${id})</div>
				<div class="item">${email}</div>
				<div class="item">${regdate}</div>
				<div class="item">게시물(${map.bcnt}), 댓글(${map.ccnt})</div>
			</div>
		</div>
	</div>
</c:if>

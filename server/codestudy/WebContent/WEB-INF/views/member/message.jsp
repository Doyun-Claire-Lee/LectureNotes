<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CodeStudy::Register</title>

<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/codestudy/css/register.css">

<style>

	.message th:nth-child(1) {width: 60px;}
	.message th:nth-child(2) {width: 90px;}
	.message th:nth-child(3) {width: auto;}
	.message th:nth-child(4) {width: 170px;}
	
	.message th, .message td {text-align: center;}
	.message td:nth-child(3) {text-align: left;}
	
</style>
</head>

<body>

	<!-- ########## 상단 헤더 시작 -->
	<%
		//원래 서블릿은 삽입이 안되는데 억지로 삽입하려고 작성한 코드 
		out.flush();
	    RequestDispatcher dheader = request.getRequestDispatcher("/inc/header.do");
	    dheader.include(request, response);
	%>
	<!-- ########## 상단 헤더 끝 -->


	<!-- ########## 본문 시작 -->
	<div class="main">

		<!-- ########## 좌측 시작 -->
		<div class="menu col-sm-12 col-md-3">
			<!-- ########## 메뉴 시작 -->
			<%
				out.flush();
			    RequestDispatcher dmenu = request.getRequestDispatcher("/inc/menu.do");
				dmenu.include(request, response);
			%>
			<!-- ########## 메뉴 끝 -->

			<!-- ########## 인증 시작 -->
			<%
				out.flush();
			    RequestDispatcher dauth = request.getRequestDispatcher("/inc/auth.do");
			    dauth.include(request, response);
			%>
			<!-- ########## 인증 끝 -->

			<!-- ########## 채팅 시작 -->
			<%
				out.flush();
			    RequestDispatcher dchat = request.getRequestDispatcher("/inc/chat.do");
				dchat.include(request, response);
			%>
			<!-- ########## 채팅 끝 -->
		</div>
		<!-- ########## 좌측 끝 -->



		<!-- ########## 내용 시작 -->
		<div class="content col-sm-12 col-md-9">
			<div>
				<h1>쪽지 <small>Message</small></h1>
                
                <table class="table table-bordered message">
                	<thead>
                		<tr>
                			<th>삭제</th>
                			<th>보낸회원</th>
                			<th>내용</th>
                			<th>날짜</th>
                		</tr>
                	</thead>
                	<tbody>
                		
                		<c:forEach items="${list}" var="dto">
                			<tr>
                				<td><input type="checkbox" class="cbDelete" name="cbDelete" value="${dto.seq}"></td>
                				<td>${dto.sname}</td>
                				<td>
                					<c:if test="${dto.state == 1}">
    	            					<a href="/codestudy/member/view.do?seq=${dto.seq}"><b>${dto.content}</b></a>
                					</c:if>
                					<c:if test="${dto.state == 2}">
	                					<a href="/codestudy/member/view.do?seq=${dto.seq}">${dto.content}</a>
                					</c:if>
               					</td>
                				<td>${dto.regdate}</td>
                			</tr>
                		</c:forEach>
                		<c:if test="${list.size() == 0}">
                			<tr>
                				<td colspan="4">받은 쪽지가 없습니다.</td>
                			</tr>
                		</c:if>
                	</tbody>
                </table>

				<div class="btns">
					<button type="button" class="btn btn-default" onclick="deleteMessage();">삭제하기</button>
					<button type="button" class="btn btn-default" onclick="location.href='/codestudy/member/send.do';">쪽지 보내기</button>
				</div>               
				
				<div style="clear:both;">
                
			</div>
		</div>
		<!-- ########## 내용 끝 -->

	</div>
	<!-- ########## 본문 끝 -->


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	<script>
	
    	function deleteMessage() {
    		//데이터를 어떻게 넘겨야 하는가..?
    		//cbDelete=1&cbDelete=2와 같은 형식으로..
    		// -> req.getParameterValues("cbDelete") -> {1, 2}
    				
    		//jQuery 메소드 사용
    		//serialize : 직렬화, 객체나 데이터 구조를 1줄의 문자열로 만드는 작업
    		console.log($(".cbDelete").serialize());
    		
    		if($(".cbDelete:checked").length > 0) {
	    		location.href="/codestudy/member/delete.do?" + $(".cbDelete").serialize();
    		} else {
    			alert("삭제할 쪽지를 선택하세요.")
    		}
    	}
	
	
    </script>
</body>

</html>
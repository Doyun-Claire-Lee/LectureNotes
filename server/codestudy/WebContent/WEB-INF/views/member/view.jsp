<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CodeStudy::Register</title>

<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/codestudy/css/register.css">

<style>

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
                
                <table class="table table-bordered">
					<tr>
						<th style="width:150px;">보낸사람</th>
						<td>${dto.sname}</td>
					</tr>
					<tr>
						<th>보낸날짜</th>
						<td>${dto.regdate}</td>
					</tr>
					<tr>
						<th>쪽지내용</th>
						<td>${dto.content}</td>
					</tr>
                </table>

				<div class="btns">
					<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='/codestudy/member/message.do';">
				</div>               
				
				<div style="clear:both;"></div>
                
			</div>
		</div>
	
		<!-- ########## 내용 끝 -->

	</div>
	<!-- ########## 본문 끝 -->


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	<script>
    	
	
	
    </script>
</body>

</html>
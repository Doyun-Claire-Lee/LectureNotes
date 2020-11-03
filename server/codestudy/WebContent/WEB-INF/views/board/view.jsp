<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CodeStudy::Board</title>

<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/codestudy/css/board.css">

<style>

</style>
</head>

<body>

	<!-- ########## 상단 헤더 시작 -->
	<%
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
				<h1>자유 게시판 <small>Board</small></h1>
                
                <table class="table view">
                    <tr>
                        <td>
                            <span class="seq">${dto.seq}.</span>
                            <span class="subject">${dto.subject}</span>
                            <span class="readcount">읽음(${dto.readcount})</span>
                            <span class="date">${dto.regdate}</span>
                            <span class="name">${dto.name}(${dto.id})</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="content">
                        	${dto.content}
                        </td>
                    </tr>
                    <!-- 
                    <tr>
                        <td>
                            <span class="glyphicon glyphicon-floppy-disk"></span> test.zip
                        </td>
                    </tr>
                     -->
                    <tr>
                        <td>
                            <button type="button" class="btn btn-default <c:if test="${dto.heart == 1}">active</c:if>" onclick="location.href='/codestudy/board/heart.do?seq=${dto.seq}'"<%-- <c:if test="${dto.heart == 1}">disabled</c:if> --%>>
                                <span class="glyphicon glyphicon-thumbs-up"></span>
                                추천
                            </button>
                        </td>
                    </tr>
                </table>


                <div class="btns btn-group">
                	<!-- 검색 중 글을 확인하러 들어왔을 때 다시 검색 목록으로 돌아가도록 search값을 받아 전달해줌 -->
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/list.do?search=${search}&sort=${sort}';">
                        <span class="glyphicon glyphicon-th-list"></span>
                        목록
                    </button>
                    
                    <c:if test="${id == dto.id}">
                    <!-- 세션 안에 있는 아이디와 dto 안에 있는 아이디가 같은지 -->
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/edit.do?seq=${dto.seq}';">
                        <span class="glyphicon glyphicon-minus"></span>
                        수정
                    </button>
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/delete.do?seq=${dto.seq}';">
                        <span class="glyphicon glyphicon-remove"></span>
                        삭제
                    </button>
                    </c:if>
                    
                    <!-- 로그인한 사람에게만 답변버튼 보이도록 -->
                    <c:if test="${!empty id}">
	                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/write.do?reply=y&thread=${dto.thread}&depth=${dto.depth}';">
	                        <span class="glyphicon glyphicon-share-alt"></span>
	                        답변
	                    </button>
                    </c:if>
                    
                </div>
                <div style="clear:both;"></div>


				<!-- ####댓글 -->
                <table class="table comment">
					<c:forEach items="${clist}" var="cdto">
                    <tr>
                        <td>
                            <span class="comment">${cdto.commentContent}</span>
                            <span class="date">${cdto.regdate}</span>
                            <span class="name">${cdto.name}(${cdto.id})</span>
                            <c:if test="${seq == cdto.mseq}">
                            	<!-- 삭제할 댓글 번호와, 삭제 후 돌아오기 위해 해당 글번호를 같이 넘김 -->
                            	<span class="delete" onclick="location.href='/codestudy/board/deletecomment.do?seq=${cdto.seq}&bseq=${dto.seq}';">[삭제]</span>
                        	</c:if>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
 				
 				<!-- 로그인한 사람에게만 댓글쓰는창 보이도록 -->
 				<c:if test="${!empty id}">
	 				<form method="POST" action="/codestudy/board/comment.do">
		                <div class="commentbox panel panel-default">
		                    <div class="panel-body">
		                        <input type="text" class="form-control" placeholder="comment" name="commentContent" required>
		                    </div>
		                </div>
		                <input type="hidden" name="bseq" value="${dto.seq}">
	                </form>
                </c:if>
                
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
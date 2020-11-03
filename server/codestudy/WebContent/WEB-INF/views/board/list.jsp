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
				
				<c:if test="${!empty search}">
	                <div class="message well well-sm">
	                    '${search}'(으)로 ${list.size()}건의 게시물을 검색했습니다.
	                </div>
                </c:if>
                 <!-- 가끔 사용하는 GET방식의 form태그 -->
                 <form method="GET" action="/codestudy/board/list.do" id="seachForm">
	                <div class="input-group search">
	                    <input type="text" class="form-control" value="${search}" aria-describedby="basic-addon2" name="search" id="search" required>
	                    <span class="input-group-addon" id="basic-addon2" style="cursor:pointer;" onclick="$('#searchForm').submit();"><span class="glyphicon glyphicon-search"></span></span>
	                </div>
                </form>
                <div style="clear:both;"></div>
                
                
                
 				<!-- 페이징을 위한 방법1 -->
 				<!--  
 				<select name="pagebar" id="pagebar" onchange="movePage()">
 					<c:forEach var="i" begin="1" end="${totalPage}">
 					<option value="${i}">${i}page</option>
 					</c:forEach>
 				</select>
                -->
                
                <table class="table table-hover list">
                    <thead>
                        <tr>
                            <th>추천</th>
                            <th>제목</th>
                            <th>이름</th>
                            <th>날짜</th>
                            <th>읽음</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    	<!-- 검색 결과가 없을때 -->
	                    <c:if test="${!empty search and list.size() == 0}">
	                    	<tr>
	                    		<td colspan="5">검색 결과가 없습니다.</td> 
	                    	</tr>
	                    </c:if>
	                    
	                    <!-- 검색한 것은 아니지만 작성된 글이 없을 때 -->
   	                    <c:if test="${empty search and list.size() == 0}">
	                    	<tr>
	                    		<td colspan="5">작성된 게시물이 없습니다.</td> 
	                    	</tr>
	                    </c:if>
                    
                    	<c:forEach items="${list}" var="dto">
	                        <tr>
	                            <td>${dto.heart}</td>
	                            
	                            <!-- 제목 -->
	                            <td>
	                            	<!-- 내용의 검색어 강조를 위해 검색어까지 같이 넘겨줌. -->
	                            	<a href="/codestudy/board/view.do?seq=${dto.seq}&search=${search}&sort=${sort}" style="margin-left:${dto.depth*20}px;"><c:if test="${dto.depth >0}"><span class="glyphicon glyphicon-share-alt"></span></c:if>${dto.subject}</a>
	                            	<!-- 댓글이 1개 이상일때만 출력 -->
	                            	<c:if test="${dto.commentcount > 0}">
	                            	<span class="badge">${dto.commentcount}</span>
	                            	</c:if>
	                            	<!-- 글이 작성된지 1시간 이내일 때만 -->
	                            	<c:if test="${dto.gap < 1}">
	                            	<span class="label label-danger">new</span>
	                            	</c:if>
	                            </td>
	                            
	                            <td>${dto.name}</td>
	                            <td>${dto.regdate}</td>
	                            <td>${dto.readcount}</td>
	                        </tr>
   						</c:forEach>
                    </tbody>
                </table>

				<!-- 정렬 변경하는 아이콘 -->
                <div class="btn-group fbtns" role="group" aria-label="...">
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/list.do?sort=thread'"><span class="glyphicon glyphicon-th-list"></span></button>
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/list.do?sort=heart'"><span class="glyphicon glyphicon-thumbs-up"></span></button>
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/list.do?sort=readcount'"><span class="glyphicon glyphicon-heart"></span></button>
                </div>
 				

				<!-- ###페이지 네비게이션 바 -->
				<!-- 서블릿으로 만들어서 출력 -->
				${pagebar}


                <div style="clear:both;"></div>

                <div class="btns btn-group">
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/list.do';">
                        <span class="glyphicon glyphicon-th-list"></span>
                        목록
                    </button>
                    
                    <!-- 로그인한 사람에게만 쓰기 버튼이 보이도록 -->
                    <c:if test="${!empty id}">
                    <button type="button" class="btn btn-default" onclick="location.href='/codestudy/board/write.do?reply=n';">
                        <span class="glyphicon glyphicon-plus"></span>
                        쓰기
                    </button>
                    </c:if>
                    
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
	
		var index = 0;

		if ("${sort}" == "seq") {
			index = 0;
		} else if  ("${sort}" == "heart") {
			index = 1;
		} else if ("${sort}" == "readcount") {
			index = 2;
		}
    	$(".fbtns").children().eq(index).addClass("active");
	
		function movePage() {
			location.href = "/codestudy/board/list.do?page=" + event.srcElement.value;
		}
		$("#pagebar").val(${page});
	
	
    </script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CodeStudy::Plan</title>

<%@include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="/codestudy/css/plan.css">

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
				<h1>스터디 일정 <small>Plan</small></h1>

				<table style="margin:15px 0px; width:100%;"> 
					<tr>               
	                	<td><button type="button" id="prevMonth" class="btn btn-default" onclick="location.href='/codestudy/plan/index.do?year=${prevYear}&month=${prevMonth}';">이전달</button></td>
	                	<td style="text-align:center; font-size:2em; font-weight:bold;">
	                		${year}.<fmt:formatNumber minIntegerDigits="2" value="${month + 1}"></fmt:formatNumber>
	                	</td>
	                	<td style="text-align:right;"><button type="button" id="nextMonth" class="btn btn-default"  onclick="location.href='/codestudy/plan/index.do?year=${nextYear}&month=${nextMonth}';">다음달</button></td>
                	</tr>
                </table>
                
                <table class="calendar">
                    <thead>
                        <tr>
                            <th>SUN</th>
                            <th>MON</th>
                            <th>TUE</th>
                            <th>WED</th>
                            <th>THU</th>
                            <th>FRI</th>
                            <th>SAT</th>
                        <tr>
                    </thead>
                    <tbody>
                        
                        ${txtCal}
                        
                        <%-- 자바로 작업해서 만들기!!
                        <tr>
		                    <c:forEach var="i" begin="1" end="31">
	                            <td><div class="date">${i}</div></td>
								
								<!-- 토요일마다 <tr> 처리하기 -->
								<c:if test="${i mod  7 == 0}">
									</tr>
									<tr>
								</c:if>

		                    </c:forEach>
                        </tr>
                        --%>
                         
                    </tbody>
                </table>
                
                <div style="clear:both;"></div>

				<c:if test="${not empty id}">
                <div class="btns btn-group">
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
                        <span class="glyphicon glyphicon-plus"></span>
                        등록
                    </button>
                </div>
				</c:if>
                <div style="clear:both;"></div>
			</div>
		</div>
		<!-- ########## 내용 끝 -->

	</div>
	<!-- ########## 본문 끝 -->
	
	
	<!-- ########## Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
      	
      	<form method="POST" action="/codestudy/plan/add.do">
	        <div class="modal-content">
	            <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	            <h4 class="modal-title" id="myModalLabel">일정</h4>
	            </div>
	            <div class="modal-body">
		                <ul class="list-group">
		                    <li class="list-group-item">
		                        <input type="date" class="form-control" id="itemDate" name="regdate" required>
		                    </li>
		                    <li class="list-group-item">
		                        <input type="text" class="form-control" id="itemText" name="content" required placeholder="일정 내용을 입력하세요.">
		                    </li>
		                    <li class="list-group-item">
		                        <input type="text" class="form-control" id="itemUser" value="${name}">
		                    </li>
		                </ul>
	            </div>
	            <div class="modal-footer">
	                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-disk"></span> 저장</button>
	                <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span> 삭제</button>
	                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-ok"></span> 닫기</button>                    
	            </div>
	        </div>
        </form>
        
        </div>
    </div>
    <!-- ########## Modal -->


	<!-- ########## 하단 시작 -->
	<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	<!-- ########## 하단 끝 -->
	
	<script>
		$('#myModal').on('show.bs.modal', function (e) {
	        //console.log(e.relatedTarget.innerText);
	        if (e.relatedTarget.nodeName == "DIV") {
	            $("#itemText").val(e.relatedTarget.innerText.substr(2));
	        } else {
	            console.log((new Date()).toDateString());
	            $("#itemDate").val((new Date()).toDateString());
	            $("#itemText").val("");
	        }
	    })
	    
	    function setData(regdate, name) {
			$("#itemDate").val(regdate);
			$("#itemUser").val(name);
			
		}
    </script>
</body>

</html>
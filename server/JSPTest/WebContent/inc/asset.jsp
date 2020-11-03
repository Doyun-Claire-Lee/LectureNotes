
<!-- 자원을 찾을 때 경로를 표시하는 방법

1. 절대 경로
	- /로 시작함.	
2. 상대 경로
	- ./로 시작함. (생략도 가능)

/Context Root(=/jsp) -> WebContent 폴더

##inc 폴더 내의 파일(조각 페잊지)에서는 되도록 절대 경로를 사용하는 것이 좋음.

 -->
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.css">
<script src="<%= request.getContextPath() %>/js/jquery-1.12.4.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.js"></script>



<!-- 상대 경로일 경우 -->
<!-- <link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/bootstrap.js"></script>
 -->

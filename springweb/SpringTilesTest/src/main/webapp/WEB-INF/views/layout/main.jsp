<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 조각페이지 붙여넣기 위한 taglib -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- include 태그와 동일한 작업을 해줌 -->
<tiles:insertAttribute name="asset"></tiles:insertAttribute>


</head>
<body>

	<main>
		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>
		<tiles:insertAttribute name="submenu"></tiles:insertAttribute>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</main>	

</body>
</html>
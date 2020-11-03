<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 조각페이지 붙여넣기 위한 taglib -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- include 태그와 동일한 작업을 해줌 -->
<tiles:insertAttribute name="asset"></tiles:insertAttribute>
<style>


</style>

</head>
<body>

	<main>
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</main>	

<script>

	var height = window.innerHeight;
	var footerheight = $("#footer").height();
	console.log(height);
	$("#menu").css("height", height);
	$("#content").css("height", height-footerheight);
	
	
</script>

</body>

</html>
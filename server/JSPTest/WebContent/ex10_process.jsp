<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터 받아오기
	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String background = request.getParameter("background");
	String foreground = request.getParameter("foreground");
	String fontsize = request.getParameter("fontsize");
	String isBorder = request.getParameter("isBorder");
	String borderWidth = request.getParameter("borderWidth");
	String borderColor = request.getParameter("borderColor");
	String borderStyle = request.getParameter("borderStyle");
	String borderRadius = request.getParameter("borderRadius");
	
	int count = Integer.parseInt(request.getParameter("count"));







%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp" %>
<style>
	.btn {
		width: <%= width %>px;
		height: <%= height %>px;
		background-color: <%= background %>;
		color: <%= foreground %>;
		font-size: <%= fontsize %>px;
		
		<% if(isBorder.equals("y")) { %>
		
		border: <%= borderWidth %>px <%= borderStyle %> <%= borderColor %>;
		border-radius: <%= borderRadius %>%;
		<% } %>
		
		margin: 10px;
		
	}
</style>
</head>
<body>
	<div class="container"> 
		
		<h1>결과</h1>

		<% for(int i=0; i<count; i++) { %>	
		<button class="btn">Button</button>
		<%  }%>	
	</div>
	
	
	<script>
		

	</script>
</body>
</html>
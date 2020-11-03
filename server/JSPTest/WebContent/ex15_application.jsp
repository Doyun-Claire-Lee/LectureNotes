<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<div class="container"> 
	
		<h1>Application</h1>
		<!-- 
		
			서블릿과 JSP는 사용하는 컨테이너에 따라 달라진다.
			- 톰캣의 버전에 따라 서블릿과 JSP의 버전이 달라진다.
			
			톰캣 v8.X -> 서블릿 3.1
			
		
		
		
		 -->
		
		
		
		<div>서블릿 버전: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %></div>
		<div>
			컨테이너 정보: <%= application.getServerInfo() %>
			<br>
			컨텍스트 루트: <%= application.getContextPath() %>, <%= request.getContextPath() %>
			<br>
			<!-- 
				application.getRealPath()
				상대 경로를 파일 절대 경로로 변환함. 서버측의 실제 경로를 반환(***)
				D:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest
				톰캣이 관리 차원에서 소스를 복사해서 위의 경로에 두고 이용함.   
			 -->
			프로젝트의 절대 경로: <%= application.getRealPath(".") %>
			<br>
			현재 프로젝트 이름: <%= application.getServletContextName() %>
		</div>
		<div>
			JSP버전: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>	
		</div>


	
		<!-- ex16_session에서 저장된 데이터 -->
		<div><%= session.getAttribute("name") %></div>
		<div>방문 카운트: <%= session.getAttribute("num") %></div>
	</div>
	
	
	<script>


	</script>
</body>
</html>
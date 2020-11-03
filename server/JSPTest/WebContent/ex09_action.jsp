<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//1. 클라이언트(브라우저) 인코딩: UTF-8
	//2. 데이터 전송
	//3. 인터넷(WEB)의 인코딩: ISO-8859-1	---> 이것 때문에 한글이 깨짐!
	//4. 서버(수신) 인코딩: UTF-8
	request.setCharacterEncoding("UTF-8");	//가장 첫줄에 적어야 함! (데이터를 받기 전에 인코딩을 변경해 주어야 하기 때문)
	
	//데이터 수신하기
	//request??? -> 서블릿에서 넘어온 매개변수, 우리눈에 안보일 뿐 서블릿으로 변환될 때 자동으로 처리됨.
	String name = request.getParameter("name");	//해당 컨트롤의 name 속성값을 기재
	String age = request.getParameter("age");
	
	//텍스트 박스
	String txt1 = request.getParameter("txt1");
	
	//암호 박스
	String pw1 = request.getParameter("pw1");
	
	//다중 라인 텍스트 박스
	String txt2 = request.getParameter("txt2");
	txt2 = txt2.replace("\n", "<br>");	//개행처리
	
	//체크 박스
	// - 체크 O : "on" 반환(value값이 생략된 경우), value값
	// - 체크 X : null
	String cb1 = request.getParameter("cb1");

	String cb2 = request.getParameter("cb2");
	String cb3 = request.getParameter("cb3");
	String cb4 = request.getParameter("cb4");
	
	String temp = "";
	
	for(int i=2; i<=4; i++) {
		temp += request.getParameter("cb" + i) + ", ";
	}
	
	String[] cb = request.getParameterValues("cb");
	
	//단일데이터 : request.getParameter()
	//다중데이터 : request.getParaneterValues()

	//라디오 버튼
	String[] rb = request.getParameterValues("rb");
	System.out.println(Arrays.toString(rb));
	
	//라디오버튼의 특성상 버튼이 여러개여도 단일값이 전송됨. 굳이 배열을 쓸 필요X
	String rb2 = request.getParameter("rb");
	System.out.println(rb2);
	
	//셀렉트
	String sel1 = request.getParameter("sel1");
	System.out.println(sel1);
	
	//달력
	String date1 = request.getParameter("date1");
	
	//범위
	String range1 = request.getParameter("range1");
	
	//자바스크립트(히든 태그)
	String jvalue = request.getParameter("jvalue");
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		margin-bottom: 15px;
	}
</style>
</head>
<body>
	
	
	
	<h1>데이터 수신하기</h1>
	<div>이름: <%= name %></div>
	<div>나이: <%= age %></div>
	
	
	<h1>폼 데이터 수신하기</h1>

	<div>텍스트박스: <%= txt1 %></div>

	<div>암호 상자: <%= pw1 %></div>
	<!--  소스 상에는 엔터가 있지만 브라우저가 공백으로 치환해버림. -->
	<div>다중 라인: <%= txt2 %></div>
	
	<div>체크 박스: <%= cb1 %></div>
	<div>체크 박스: <%= cb2 %></div>
	<div>체크 박스: <%= cb3 %></div>
	<div>체크 박스: <%= cb4 %></div>
	
	<!-- 체크 박스 여러개 -->	
	<div>체크 박스: <%= temp %></div>
	<div>체크 박스: <%= Arrays.toString(cb) %></div>
	
	<div>라디오 버튼: <%= rb2 %></div>
	
	<div>셀렉트: <%= sel1 %></div>	
	
	<div>달력: <%= date1 %></div>	
	
	<div>범위: <%= range1 %></div>	
	
	<div>자바스크립트(히든 태그): <%= jvalue %></div>	
	
	<script>


	</script>
</body>
</html>
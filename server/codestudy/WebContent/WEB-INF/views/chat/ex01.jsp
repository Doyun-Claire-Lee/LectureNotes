<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<div class="container"> 
		
		<h1>WebSocket</h1>
		<!-- 
		여러가지 흐름을 만들 수 있는 도구 
		
		웹클라이언트 <-> (통신) <-> 웹서버일 때의 통신 방식
		
		1. 브라우저 <-> 서버
			- 일반적인 요청 + 응답
			- 링크, <form> 등등..
		
		2. 자바스크립트 객체 <-> 서버
			- Ajax (나온지 오래됨)
			- WebSocket (나온지 얼마 안됨)
				- Ajax의 대체품은 아님.
				- 제대로된 socket을 배우고 싶으면 java쪽 socket, thread를 배울 것
				
		-->
		
		<input type="button" id="btn1" value="클릭">
		<div id="output"></div>
	
		<hr>
		<input type="button" id="btn2" value="연결하기">
		<input type="button" id="btn3" value="종료하기" disabled>
		<br>
		<input type="text" id="message" disabled>
		<div id="output2"></div>

	
	</div>
	
	
	<script>
		$("#btn1").click(function() {
			
			//웹소켓 - 서버와 통신
			//1. 소켓 생성
			//2. 서버 접속
			//3. 통신
			//4. 서버 접속 종료
			
			//웹소켓 테스트용 서버
			var url = "ws://echo.websocket.org";
			
			//웹소켓 생성
			var ws = new WebSocket(url);
			
			//비동기(이벤트)
			// - 서버랑 실제적으로 접속이 될 때 발생하는 이벤트 함수
			// - 클라이언트 -> 서버
			ws.onopen = function(evt) {
				console.log("서버와 연결되었습니다.");
				ws.send("Hello");
			};
			
			// - 서버 -> 클라이언트
			ws.onmessage = function(evt) {
				console.log("서버측에서 클라이언트에게 메세지를 보냈습니다.");
				console.log(evt.data);	//돌려받은 메세지
			// - 소켓 연결 종료
				ws.close();
			};
			
			// - 접속 종료시 해야 할 이벤트
			ws.onclose = function(evt) {
				console.log("서버와 연결이 종료되었습니다.");
			};
			
			// - 예외처리 이벤트
			ws.onerror = function(evt) {
				console.log("error", evt.data);
			};
			
		});
		
		var url = "ws://echo.websocket.org";
		var ws;
		
		function print(msg) {
			$("#output2").append("<div>[" + (new Date().toLocaleTimeString()) + "]" + msg + "</div>");
		}
		
		$("#btn2").click(function() {
			//웹소켓 + 서버 접속
			ws = new WebSocket(url);
			
			ws.onopen = function(evt) {
				print("연결되었습니다.");
				$("#btn2").attr("disabled", true);
				$("#btn3").attr("disabled", false);
				$("#message").attr("disabled", false);
			};
			
			ws.onclose = function(evt) {
				print("종료되었습니다.");
				$("#btn3").attr("disabled", true);
				$("#btn2").attr("disabled", false);
				$("#message").attr("disabled", true);
			};
			
			ws.onmessage = function(evt) {
				print("응답받은 데이터: " + evt.data);
			};
			
			ws.onerror = function(evt) {
				console.log("error", evt.data);
			};
		});
		
		$("#btn3").click(function() {
			ws.close();
		});
		
		$("#message").keyup(function() {
			if(event.keyCode == 13) {
				ws.send($(this).val());		//메세지 보내기
				$(this).val("");			//메세지 보낸 후 텍스트박스 초기화
			}
			
		});
		
		

	</script>
</body>
</html>
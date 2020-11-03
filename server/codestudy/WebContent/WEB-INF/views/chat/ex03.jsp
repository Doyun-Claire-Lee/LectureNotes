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
	
		<h1>1:1 채팅</h1>
		<table class="table table-bordered" style="width:500px;">
			<tr>
				<td>
					<input type="text" name="user" id="user" class="form-control" placeholder="유저명">
				</td>
				<td>
					<button type="button" id="btnConnect">접속하기</button>
					<button type="button" id="btnDisconnect" disabled>종료하기</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="output" style="height: 300px; width:100%; padding:20px; overflow: auto;"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" name="message" id="message" placeholder="대화내용을 입력하세요." class="form-control" disabled>
				</td>
			</tr>
		</table>
	
	
	</div>
	
	
	<script>

		//서버 주소
		//방화벽 열어야함. 방화벽-고급설정-인바운드규칙-새규칙-포트-TCP
		var url = "ws://localhost:8090/codestudy/ex03server";
		var ws;
		
		
		//연결하기
		$("#btnConnect").click(function() {
			
			//유저명 입력되었는지 확인
			if ($("#user").val().trim().length != 0) {
				
				//서버와 소켓 연결하기
				ws = new WebSocket(url);
				
				//소켓에 이벤트 매핑하기
				ws.onopen = function() {
					print($("#user").val(), "연결되었습니다.");
					$("#user").attr("disabled", true);
					$("#btnConnect").attr("disabled", true);
					$("#btnDisconnect").attr("disabled", false);
					$("#message").attr("disabled", false);
				};
				
				ws.onclose = function() {
					print($("#user").val(), "종료되었습니다.");
				};				
				
				ws.onerror = function(evt) {
					console.log(evt.data);
				};				
				
				//서버로부터 메세지를 수신한 경우
				ws.onmessage = function(evt) {
					
					//evt.data = "아무개#안녕하세요"의 형식으로 넘어옴.
					var index = evt.data.indexOf("#");
					var user = evt.data.substring(0, index);
					var txt = evt.data.substring(index + 1);
					
					print(user, txt);	//서버가 클라이언트에게 전달한 메세지를 찍음. (서버가 전달한 다른 유저가 보낸 메세지)
					
					$("#output").scrollTop($("#output").prop("scrollHeight"));	//항상 최신 메세지를 보이도록 스크롤 조정
					
				};				
				
			} else {
				alert("유저명을 입력하세요.");
			}
			
			
		});
		
		//종료하기
		$("#btnDisconnect").click(function() {
			
			ws.close();	//소켓 연결 끊기
			
		});
		
		//메세지 전송하기
		$("#message").keyup(function() {
			
			if(event.keyCode == 13) {
				
				//서버에 메세지 전달 
				ws.send($("#user").val() + "#" + $(this).val());	//홍길동#안녕하세요
				
				print($("#user").val(), $(this).val());
				$(this).val("");
				
				$("#output").scrollTop($("#output").prop("scrollHeight"));	//항상 최신 메세지를 보이도록 스크롤 조정
					
			}
			
		});
		
		$("#user").keydown(function() {
			if (event.keyCode == 13) {
				$("#btnConnect").click();
			}  
		});
		
		
		

		function print(user, txt) {
			
			var temp = "";
			temp += "<div>";
			temp += "[" + user + "]";
			temp += txt;
			temp += "<span style='font-size:11px; color:#777;'>" + (new Date().toLocaleTimeString()) + "</span>";
			temp += "</div>";
			
			$("#output").append(temp);
		}
		
		
	</script>
</body>
</html>
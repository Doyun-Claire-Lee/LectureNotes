package com.test.codestudy.chat;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//WebSocket서버
@ServerEndpoint("/server")
public class Ex02Server {

	//대기를 하고 있다가 클라이언트가 연결을 요청하면 응답해야 함.
	
	
	@OnOpen
	public void handleOpen() {
		//클라이언트가 연결 버튼 눌러 연결 요청 -> 서버(지금 페이지)에서 받아 연결 요청 확인 -> 클라이언트에게 응답 -> 클라이언트가 연결 되었음을 확인
		System.out.println("클라이언트가 접속했습니다.");
	}
	
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트가 접속을 종료했습니다.");
	}
	
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	//에코 서버 구현 
	@OnMessage
	public String handleMessage(String message) {
		
		System.out.println("클라이언트가 메시지를 전달했습니다. : " + message);
		return "(응답)" + message;
	
	}
	
}

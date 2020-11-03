package com.test.codestudy.chat;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ex03server")
public class Ex03Server {
	
	//현재 서버에 접속한 클라이언트의  WebSocket Session 목록을 저장하는 리스트
	private static ArrayList<Session> list = new ArrayList<Session>();	//유저가 접속할때마다 서버가 새로 생성되기 때문에(?) static 변수로 만들어줘야 함.

	//웹소켓 서버
	
	//클라이언트(브라우저)가 연결을 요청 + 접속
	@OnOpen
	public void handleOpen(Session userSession) {	//접속할 때 세션이 자동으로 만들어져 넘어옴.
		
		System.out.println("클라이언트 접속 성공");
		list.add(userSession);
		
		for (Session session : list) {
			if (session != userSession) { //현재 접속한 사람의 세션과 리스트에서 가져온 세션이 다를 경우 (새로운 사람이 접속한 경우, 다른 사람의 세션인 경우)
				
				try {
					session.getBasicRemote().sendText("다른 유저가 접속했습니다.");	//다른 사람의 세션의 클라이언트 웹소켓과 연결할 수 있음.
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			
			}
		}
		
	}
	
	//클라이언트(브라우저)가 연결 종료를 요청 + 해제
	@OnClose
	public void handleClose(Session userSession) {
		
		System.out.println("클라이언트 접속 해제");
		
		//접속을 종료할 때 해당 유저의 세션 정보 리스트에서 삭제하기
		list.remove(userSession);
	}

	//통신 중 에러 발생하는 경우0
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	//클라이언트(브라우저)가 서버에게 메세지를 전달했을 때 발생(서버가 메세지를 수신할 경우)
	@OnMessage
	public void handleMessage(String message, Session userSession) {
		
		int index = message.indexOf("#");
		String user = message.substring(0, index);
		String txt = message.substring(index + 1);
		
		System.out.println(user);
		System.out.println(txt);
		
		//한사람이 보낸 메세지를 다른 사람에게 전달하기 
		
		for (Session session: list) {
			if(session != userSession) {
				try {
					session.getBasicRemote().sendText(message);	//받았던 메세지를 그대로 리턴(아무개#안녕하세요)
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}

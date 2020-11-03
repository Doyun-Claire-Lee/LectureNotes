package com.test.codestudy.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/message.do")
public class Message extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//메세지 목록 받아오기
		HttpSession session = req.getSession();
		String seq = session.getAttribute("seq").toString();
		
		MemberDAO dao = new MemberDAO();
		
		//쪽지 상태 바꾸기
		dao.updateState(seq);
		
		//쪽지 목록 가져오기
		ArrayList<MessageDTO> list = dao.listMessage(seq);
		dao.close();
		
		
		//내용이 너무 길면 짤라서 보여주기
		for (MessageDTO dto : list) {
			String content = dto.getContent();
			if(content.length() > 40) {
				content = content.substring(0, 40) + "...";	
				dto.setContent(content);
			}
		}
		
		req.setAttribute("list", list);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/message.jsp");
		dispatcher.forward(req, resp);
	
		
	}
	
	
}

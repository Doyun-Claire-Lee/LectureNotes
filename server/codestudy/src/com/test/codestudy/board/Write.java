package com.test.codestudy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write.do")
public class Write extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//새글인지 답변글인지 확인
		//1. 데이터 가져오기(reply, thread, depth)
		//2. 가져온 값 넘기기 + jsp 호출
		
		//1.
		String reply = request.getParameter("reply");
		String thread = request.getParameter("thread");
		String depth = request.getParameter("depth");
	
		
		//2.
		request.setAttribute("reply", reply);
		request.setAttribute("thread", thread);
		request.setAttribute("depth", depth);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
		dispatcher.forward(request, response);
		
	}

}


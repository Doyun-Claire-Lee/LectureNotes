package com.test.codestudy.history;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history/index.do")
public class Index extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. DB작업 -> select
		//2. 결과 전달 + JSP 호출하기
		
		//1.
		HistoryDAO dao = new HistoryDAO();
		HistoryDTO dto = dao.get();
		
		request.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/history/index.jsp");
		dispatcher.forward(request, response);
		
	}

}

package com.test.codestudy.history;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history/history.do")
public class History extends HttpServlet {

	//1. 데이터 가져오기(content)
	//2. DB작업
	//3. index.do로 돌아가기
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.
		req.setCharacterEncoding("UTF-8");
		String content = req.getParameter("content");
	
		//2.
		HistoryDAO dao = new HistoryDAO();
		dao.edit(content);
		
		//3.
		resp.sendRedirect("/codestudy/history/index.do");
	
	
	}
	
	
	
}

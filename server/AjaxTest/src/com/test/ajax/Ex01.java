package com.test.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01.do")
public class Ex01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//설문조사 현황을 불러와서 화면에 출력하기
		AjaxDAO dao = new AjaxDAO();
		
		String seq = "1";	//설문 번호
		
		//설문 1건 반환받기
		ResearchDTO dto = dao.getResearch(seq);
		dao.close();
	
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex01.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

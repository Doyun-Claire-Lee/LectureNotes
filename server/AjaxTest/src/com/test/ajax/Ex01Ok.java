package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01ok.do")
public class Ex01Ok extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//설문조사 현황을 불러와서 화면에 출력하기
		AjaxDAO dao = new AjaxDAO();
		
		String seq = req.getParameter("seq");	//설문 번호
		
		//설문 1건 반환받기
		ResearchDTO dto = dao.getResearch(seq);
		dao.close();
		
		PrintWriter writer = resp.getWriter();
		writer.printf("%d,%d,%d,%d", dto.getCnt1(), dto.getCnt2(), dto.getCnt3(), dto.getCnt4());
		writer.close();
		
	
	}
	
	
	
}

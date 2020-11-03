package com.test.codestudy.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//1. 데이터 가져오기(쪽지번호)
		//2. DB작업 (select)
		//3. 결과 반환 + JSP 호출하기
		
		String seq = req.getParameter("seq");
		
		MemberDAO dao = new MemberDAO();
		
		dao.updateRead(seq);	//1(안읽음) -> 2(읽음) 상태로 변경하기
		
		MessageDTO dto = dao.getMessage(seq);
		dao.close();
		
		
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/view.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}

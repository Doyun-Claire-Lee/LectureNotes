package com.test.codestudy.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(seq)
		// -edit.do?seq=5
		
		//2. DB작업 -> select where seq
		
		//3. 결과 반환 + JSP 호출하기
	
		
		//1.
		String seq = req.getParameter("seq");
		
		
		//2.글번호를 가지고 모든 내용 가져오기 
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto2 = new BoardDTO();
		dto2.setSeq(seq);
		
		BoardDTO dto = dao.get(dto2);
		
		dao.close();
		
		//3. 
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
		dispatcher.forward(req, resp);
		
	
	}
	
	
}

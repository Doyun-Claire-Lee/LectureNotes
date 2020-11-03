package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/deleteok.do")
public class DeleteOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		//1. 데이터 받아오기(seq)
		//2. DB 작업(delete)
		//3. 결과 처리
		
		String seq = req.getParameter("seq");
		
		BoardDAO dao = new BoardDAO();
		
		
		//result 
		// - 0: 삭제 실패
		// - 1: 삭제 성공
		// - 2: 잘못된 접근(작성자가 아님)
		
		int result = 0;
		HttpSession session = req.getSession();
		
		//로그인한 아이디와 글번호를 DTO에 담음
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setId((String)session.getAttribute("id"));
		
		//해당 글번호의 글쓴이 ID와 로그인한 ID가 동일한지 판단하기 
		if (dao.isOwner(dto)) {
			result = dao.delete(seq);
			
		} else {
			result = 2;
		}
		
		
		dao.close();
		
		
		if (result == 1) {
			//삭제 성공
			resp.sendRedirect("/codestudy/board/list.do");
			
		} else if (result==0) {
			//삭제 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed'); history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
				
		} else if (result == 2) {

			//작성자가 삭제 시도한 것이 아님
			
			//한글을 HTML로 작성할때
			//1. 인코딩 처리
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			
			//2. head-meta태그 삽입
			writer.print("<head>");
			writer.print("<meta charset='UTF-8'>");
			writer.print("</meta>");
			writer.print("</head>");
		
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('글쓴이가 아닙니다.'); history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}
		
	
	
	
	
	
	
	
	}
	
	
	
}

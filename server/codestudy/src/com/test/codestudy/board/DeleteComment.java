package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/deletecomment.do")
public class DeleteComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 가져오기
		//2. DB작업 -> delete
		//3. 결과처리
		
		
		//1. 
		String seq = req.getParameter("seq");		//댓글번호	
		String bseq = req.getParameter("bseq");		//글번호
	
		//2. 
		BoardDAO dao = new BoardDAO();
		
		int result = dao.deleteComment(seq);
	
		
		
		
		//3. 
		if (result == 1) {
			//댓글삭제 성공
			//글보기 페이지 재전달받기
			resp.sendRedirect("/codestudy/board/view.do?seq=" + bseq);
			
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed'); history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}
	
	
	}
	
	
}

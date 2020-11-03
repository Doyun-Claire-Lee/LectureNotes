package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/comment.do")
public class Comment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
	
		//1. 데이터 받아오기
		//2. DB작업 -> insert
		//3. 결과처리
		
		//1.
		String commentContent = req.getParameter("commentContent");
		String bseq  = req.getParameter("bseq");
		
		//2. 
		BoardDAO dao = new BoardDAO();
		CommentDTO dto = new CommentDTO();
		
		dto.setCommentContent(commentContent);
		dto.setBseq(bseq);
		dto.setMseq((String)session.getAttribute("seq"));	//로그인한 회원번호

		
		int result = dao.writeComment(dto);
	
		
		
		if (result == 1) {
			//댓글쓰기 성공
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

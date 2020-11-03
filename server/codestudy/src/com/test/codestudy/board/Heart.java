package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/heart.do")
public class Heart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 받아오기(글번호, 로그인한 회원의 회원번호)
		//2. DB작업 -> insert
		//3. 결과 처리
		
		
		//1. 
		HttpSession session = req.getSession();
		String seq = (String)session.getAttribute("seq");	//추천인 회원번호
		String bseq = req.getParameter("seq");				//추천 글번호
		
		//DAO에 넘기기 위헤 상자안에 포장하기 
		HeartDTO dto = new HeartDTO();
		dto.setMseq(seq);
		dto.setBseq(bseq);
		

		//2. 
		BoardDAO dao = new BoardDAO();
		int result = 0;

		//이미 추천 했는지 안했는지 확인하기
		
		
		
		
		if(dao.checkHeart(dto)) {
			result = dao.addHeart(dto);			
		} else {
			result = dao.removeHeart(dto);
		}
		
		
		//3.
		
		if (result == 1) {
			//성공시
			//view로 다시 이동
			resp.sendRedirect("/codestudy/board/view.do?seq=" + bseq);
			
		} else {
			//실패시
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

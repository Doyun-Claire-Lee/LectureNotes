package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/editok.do")
public class EditOk extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(수정할 값들)
		//2. DB작업(update)
		//3. 결과 처리
		
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String seq = req.getParameter("seq");
		
		//2. 수정
		BoardDAO dao = new BoardDAO();
		
		//상자에 담기
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setSeq(seq);
	
		//result 
		// - 0: 삭제 실패
		// - 1: 삭제 성공
		// - 2: 잘못된 접근(작성자가 아님)
		
		int result = 0;
		HttpSession session = req.getSession();
		
		//로그인한 아이디와 글번호를 DTO에 담음
		BoardDTO dto2 = new BoardDTO();
		dto2.setSeq(seq);
		dto2.setId((String)session.getAttribute("id"));
		
		//해당 글번호의 글쓴이 ID와 로그인한 ID가 동일한지 판단하기 
		if (dao.isOwner(dto2)) {
			
			//같으면 글 수정
			result = dao.edit(dto);
			
		} else {
			
			//다른 경우
			result = 2;
		}
		
		dao.close();
		
		if (result == 1) {
			//수정 성공 -> 어디론가 이동시키기
			resp.sendRedirect("/codestudy/board/view.do?seq=" + seq);
			
		} else if (result==0) {
			//수정 실패
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

			//작성자가 수정 시도한 것이 아님
			
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

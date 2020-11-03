package com.test.codestudy.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/view.do")
public class View extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		//1. 데이터 가져오기
		//2. DB작업 -> select
		//3. 결과 반환 + jsp 호출하기
		
		
		//1.
		String seq = request.getParameter("seq");
		String search = request.getParameter("search");
		String sort = request.getParameter("sort");	//정렬 상태 유지를 위해 값을 받아놓음.
		
		//2.
		// - 글번호 전달하여 레코드 1개(BoardDTO) 반환받기
		
		BoardDAO dao = new BoardDAO();
		
		BoardDTO dto2 = new BoardDTO();
		dto2.setSeq(seq);
		dto2.setMseq((String)session.getAttribute("seq"));
		
		
		BoardDTO dto = dao.get(dto2);
		

		//작성자가 읽은 것도 조회수에 포함시키기
		//세션에 read값이 없거나(리스트를 거치지 않았거나) read값이 false인 경우에만
		if (session.getAttribute("read") == null || (boolean)session.getAttribute("read") == false) {
			
			dao.updateReadcount(seq);
			session.setAttribute("read", true);
			
		}
		
		String content = dto.getContent();
		
		//반환받은 데이터 가공하기
		//a. 개행 문자 처리
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);
		
		//b. 검색어 부각시키기
		if(search != null && search !="") {	//검색중일때만
			
			content = content.replace(search, "<span style='font-weight:bold; color:tomato;'>"+ search +"</span>");
			dto.setContent(content);
			
		}
		
		
		//글 번호 넘겨서 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq);
		
		
		
		//3. 반환받은 DTO를 출력하기 위해 JSP로 전달하기
		request.setAttribute("dto", dto);
		request.setAttribute("search", search);
		request.setAttribute("clist", clist);
		request.setAttribute("sort", sort);	//목록 정렬 상태유지를 위해 jsp로 sort값을 넘겨줌
		dao.close();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
		dispatcher.forward(request, response);
		
	}

}


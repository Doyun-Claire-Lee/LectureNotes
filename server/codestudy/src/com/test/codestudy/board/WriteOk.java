package com.test.codestudy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/writeok.do")
public class WriteOk extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기(subject, content)
		//2. DB작업 -> insert
		//3. 결과 처리
		
		
		/*
		 
		  답변하기
		  - thread, depth컬럼(number)
		  1. 새글 쓰기
		  	a. 게시물 중 가장 큰 thread를 찾아서 그 값에 +1000한 값을 새글의 thread 값으로 사용한다. (단, 첫글은 이전 글이 없기 때문에 1000을 사용한다.)
		  	b. 새글의 depth는 무조건 0을 넣는다.
		  
		  2. 답변글 쓰기
		  	a. 게시물의 모든 thread값 중 답변글의 부모글 thread보다 작고, 이전 새글의 thread값보다 큰 글들을 모두 찾아 thread - 1을 한다.
		  	b. 답변글의 thread 값은 부모글의 thread - 1을 사용한다.
		  	c. 답변글의 depth 값은 부모글의 depth + 1을 사용한다.

		 */
		
		
		//1
		HttpSession session = req.getSession();
		req.setCharacterEncoding("UTF-8");
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String mseq = (String)session.getAttribute("seq");
		
		String reply = req.getParameter("reply");
		
		//2. DB작업 - 위임하기
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setMseq(mseq);
		
		
		//답변글 구현용 컬럼 값 계산을 위해 우선 변수 선언해주기
		int thread = 0;
		int depth = 0;
		
		//새글인지 답변인지에 따라 값을 계산하기
		if(reply.equals("n")) {
			//새글쓰기
			//a. 게시물 중 가장 큰 thread를 찾아서 그 값에 +1000한 값을 새글의 thread 값으로 사용한다. (단, 첫글은 이전 글이 없기 때문에 1000을 사용한다.)
			thread = dao.getThread();
			//b.새글의 depth는 무조건 0을 넣는다.
			depth = 0;
			
		} else {
			//답변글 쓰기
		  	//a. 게시물의 모든 thread값 중 답변글의 부모글 thread보다 작고, 이전 새글의 thread값보다 큰 글들을 모두 찾아 thread - 1을 한다.
			
			//부모의 thread, depth값 얻어내기(view.do에서부터 넘어옴)
			int parentThread = Integer.parseInt(req.getParameter("thread"));
			int parentDepth = Integer.parseInt(req.getParameter("depth"));
			
			//이전 새글의 thread값 알아내기 (이전 새글의 1000단위값 알아내기....)
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;
			
			HashMap<String,Integer> map = new HashMap<String, Integer>();
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			dao.updateThread(map);
		
	
		  	//b. 답변글의 thread 값은 부모글의 thread - 1을 사용한다.
			thread = parentThread - 1;
			
		  	//c. 답변글의 depth 값은 부모글의 depth + 1을 사용한다.
			depth = parentDepth + 1;
			
		}
		
		//계산된 값을 넣어주기
		dto.setThread(thread);
		dto.setDepth(depth);
		
		
		
		
		//새글 쓰고 결과값 받아오기
		int result = dao.write(dto);
		
		//DB닫기
		dao.close();
		
		//3.
		
		if (result == 1) {
			//글쓰기 성공
			resp.sendRedirect("/codestudy/board/list.do");
			
			
		} else {
			//글쓰기 실패
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

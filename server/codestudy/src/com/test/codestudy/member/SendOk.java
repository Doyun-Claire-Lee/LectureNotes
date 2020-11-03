package com.test.codestudy.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/sendok.do")
public class SendOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		//1. 데이터 가져오기
		//2. DB작업 -> insert
		//3. 결과 처리
		
		//1. 

		HttpSession session = req.getSession();
				
		req.setCharacterEncoding("UTF-8");
		String[] mseq = req.getParameterValues("mseq");
		String content = req.getParameter("content");
		
		//2.
		MemberDAO dao = new MemberDAO();
		MessageDTO dto = new MessageDTO();
		
		dto.setContent(content);
		dto.setSmseq(session.getAttribute("seq").toString());
		dto.setRmseq(mseq);
	
		int result = dao.send(dto);
		
		dao.close();
		
		//3. 
		if (result == mseq.length) {
			//전송 성공
			resp.sendRedirect("/codestudy/member/message.do");
			
			
		} else {
			//전송 실패
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

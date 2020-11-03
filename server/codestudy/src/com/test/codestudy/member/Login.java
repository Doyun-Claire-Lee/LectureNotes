package com.test.codestudy.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/login.do")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 가져오기(pw, id)
		//2. DB작업 -> select
		//3. 결과 받아서 반환 -> 로그인 성공/실패 처리
		
		
		//1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//DB작업 -> DAO에게 위임
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPw(pw);

		int result = dao.login(dto);
		
		if (result == 1) {
			//로그인 성공
			// - 인증(Authentication): 우리 고객이 맞는지 확인하는 작업 
			// - 허가(Authorization):     
			
			//인증 티켓 발급 작업
			// - 개인용, 전역적이어야 함 -> session에게 담기 
			
			//세션 얻어오기
			HttpSession session = req.getSession();
			
			//얻어온 세션에 아무값이나 넣기(보통은 id값을 넣음) -> 인증 티켓
			session.setAttribute("id", dto.getId());
			
			//회원객체에 나머지 정보를 넣기
			MemberDTO dto2 = dao.getMember(dto.getId());
			
			//세션에 필요한 정보 넣기
			session.setAttribute("name", dto2.getName());
			session.setAttribute("pic", dto2.getPic());
			session.setAttribute("regdate", dto2.getRegdate());
			session.setAttribute("email", dto2.getName());
			session.setAttribute("seq", dto2.getSeq());
			
			dao.close();
			
			resp.sendRedirect("/codestudy/index.do");
			
		} else {
			//로그인 실패
			
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

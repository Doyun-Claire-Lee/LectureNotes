package com.test.codestudy.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/send.do")
public class Send extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();		
		String seq = session.getAttribute("seq").toString();
		
		//로그인한 회원을 뺀 회원 명단 가져오기 
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> mlist = dao.listMember(seq);
		dao.close();
		
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("mlist", mlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/member/send.jsp");
		dispatcher.forward(req, resp);
	
	}
	
}

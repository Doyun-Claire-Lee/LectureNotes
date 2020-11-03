package com.test.codestudy.inc;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.codestudy.member.MemberDAO;

@WebServlet("/inc/auth.do")
public class Auth extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		String seq = (String)session.getAttribute("seq");
		
		//로그인한 사람의 글수, 댓글수 카운트하기
		//1. db접속 -> select count
		//2. 결과 전달 + jsp 호출하기
			
		//1. MemberDAO
		
		MemberDAO dao = new MemberDAO();
		
		
		//2.
		HashMap<String, Integer> map = dao.getCount(seq);
		dao.close();
	
		//3.
		request.setAttribute("map", map);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/inc/auth.jsp");
		dispatcher.include(request, response);
				
	}

}

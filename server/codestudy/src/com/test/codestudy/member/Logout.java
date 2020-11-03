package com.test.codestudy.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class Logout extends HttpServlet {
	
	
	//로그아웃 span태그를 눌러서 이 페이지로 왔기 때문에 doGet()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 인증 티켓 제거하기
		//2. 첫 화면으로 이동하기
		

		HttpSession session = req.getSession();
		session.removeAttribute("id"); 	//로그아웃
		session.invalidate();			//모든 세션 정보를 지울때
			
		resp.sendRedirect("/codestudy/index.do");
	}
	
	
	
	
	
}

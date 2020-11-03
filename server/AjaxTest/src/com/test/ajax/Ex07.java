package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07.do")
public class Ex07 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. DB에서 데이터 받아오기
		//2. 고양이 위치 정보 반환하기 + JSP 호출하기
		
		//1.
		AjaxDAO dao = new AjaxDAO();
		ArrayList<CatDTO> list = dao.catlist();
		dao.close();
		
		//2.
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex07.jsp");
		dispatcher.forward(req, resp);
	
	}
}

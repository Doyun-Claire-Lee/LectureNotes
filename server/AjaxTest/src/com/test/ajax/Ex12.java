package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex12.do")
public class Ex12 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//1. DB작업(부서명 가져오기)
		//2. 결과 전달 + JSP 호출
		
		//1.
		AjaxDAO dao = new AjaxDAO();
		ArrayList<String> list = dao.buseolist();
		dao.close();
		
		
		//2.
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex12.jsp");
		dispatcher.forward(req, resp);
	
	}

}

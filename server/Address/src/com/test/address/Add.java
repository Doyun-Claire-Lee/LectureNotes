package com.test.address;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//할일? 
		//1. 글쓰기 페이지를 보려고 부른 페이지
		//2. 할일은 없음. JSP가 필요 
				
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/add.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

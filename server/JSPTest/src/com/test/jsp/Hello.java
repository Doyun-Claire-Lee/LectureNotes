package com.test.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//JDBC 작업 + 업무 등등...
		//이후의 PrintWriter 업무 -> JSP 페이지로 이동시키기
		
		String name = "Hong";
		
		
		//페이지 이동만 하고 문맥이 끊김. (데이터를 넘기면서 호출하지 못함)
		//resp.sendRedirect("hello.jsp");	
		
		//데이터를 넘기면서 페이지 호출
		req.setAttribute("name", name);
		
		// pageContext는 jsp에서만 예약어로 사용할 수 있는 객체임. 
		// pageContext.forward("hello.jsp");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/hello.jsp");
		dispatcher.forward(req, resp);	//request와 response 객체를 가지고 이동, URL은 서블릿 주소가 남음.
		
		
		
	}
	

}

package com.test.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Document");
		writer.println("</body>");
		writer.println("</html>");
		
		
		
		//test.jsp -> test.java 변환 과정
		String name = "홍길동";
		int age = 20;
//		<div>안녕하세요. 저는 <%= name %>입니다.</div>
		writer.println("<div>안녕하세요. 저는 " + name +"입니다.</div>" );
		
		writer.close();
		
		
	
	
	
	}

}

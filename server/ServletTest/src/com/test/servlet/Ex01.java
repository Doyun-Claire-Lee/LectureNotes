package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 자격 부여
public class Ex01 extends HttpServlet {

	//2. doGet, doPost
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//3. PrintWriter
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		//4. 페이지 작성
		// - 구구단 출력하기(랜덤)
		
		Random rnd = new Random();
		int dan = rnd.nextInt(8) + 2;	//2~9 사이의 값 
		
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>" + dan + "단</h1>");
		for(int i=1; i<10; i++) {
			writer.printf("<div>%d X %d = %d</div>", dan, i, dan * i);
		}
		writer.println("</body>");
		writer.println("</html>");
	
		writer.close();
		
	}

}

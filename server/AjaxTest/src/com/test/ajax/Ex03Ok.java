package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex03ok.do")
public class Ex03Ok extends HttpServlet {

	
	//get, post 둘중 아무거나 상관 없음
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		int txt1 = Integer.parseInt(req.getParameter("txt1"));
		int db = 123;
		int result = txt1 * db;
		
		//ex03ok.do 서블릿에서 하는 작업이 고비용일 경우(10초 소요)
		try {
			Thread.sleep(10000);	//10초간 일시중지 
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//ajax객체는 브라우저와 달라 HTML 언어를 해석하지 못함. 따라서 결과만 적어주어야 함.
		PrintWriter writer = resp.getWriter();
		writer.println(result);

	
	
	}
	
	
}

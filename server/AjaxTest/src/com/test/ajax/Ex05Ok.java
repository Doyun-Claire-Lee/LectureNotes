package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05ok.do")
public class Ex05Ok extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 받아오기(id)
		//2. DB작업(중복 확인)
		//3. 결과 반환
		
		//1.
		String id = req.getParameter("id");
		
		//2. 
		AjaxDAO dao = new AjaxDAO();
		int result= dao.check(id);		//중복이면 1, 아니면 0
		
		dao.close();
		
		//3.
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		writer.print("{");
		writer.printf("\"use\": %d", result);
		writer.print("}");
		writer.close();
	
	
	}
	

}

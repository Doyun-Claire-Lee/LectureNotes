package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07ok.do")
public class Ex07Ok extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 받아오기(고양이 정보)
		//2. DB작업(update)
		//3. 결과처리
	
		
		//1.
		String catid = req.getParameter("catid");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		
		//고양이 정보를 상자에 넣어줌
		CatDTO dto = new CatDTO();
		dto.setCatid(catid);
		dto.setX(x);
		dto.setY(y);
		
		//2. 
		AjaxDAO dao = new AjaxDAO();
		int result =  dao.editCat(dto);
		dao.close();
		
		//3.
		PrintWriter writer = resp.getWriter();
		writer.print(result);
		writer.close();
	
	}
	
}

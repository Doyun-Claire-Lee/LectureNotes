package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex06ok.do")
public class Ex06Ok extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 가져오기(search)
		//2. DB작업 (Select)
		//3. 결과 반환 -> ajax로 돌려주기
		
		//1.
		req.setCharacterEncoding("UTF-8");
		String search = req.getParameter("search");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		ArrayList<ZipcodeDTO> list = dao.ziplist(search);
		dao.close();
		
		//3.
		//돌려줄 형식
		/*
			[
			{
				"seq": "10",
				"zipcode": "120-120",
				"sido": "서울시",
				"gugun": "강남구",
				"dong": "역삼동",
				"bunji": "100"
			},
			{
				"seq": "10",
				"zipcode": "120-120",
				"sido": "서울시",
				"gugun": "강남구",
				"dong": "역삼동",
				"bunji": "100"
			}
			]
		*/
		resp.setCharacterEncoding("UTF-8");			//인코딩
		resp.setContentType("application/json");	//보낼 자료형 
	
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		temp += "[";
		
		for(ZipcodeDTO dto : list) {
			
			temp += "{";
			temp += String.format("\"seq\": \"%s\",", dto.getSeq());
			temp += String.format("\"zipcode\": \"%s\",", dto.getZipcode());
			temp += String.format("\"sido\": \"%s\",", dto.getSido());
			temp += String.format("\"gugun\": \"%s\",", dto.getGugun());
			temp += String.format("\"dong\": \"%s\",", dto.getDong());
			temp += String.format("\"bunji\": \"%s\"", dto.getBunji() == null ? "" : dto.getBunji());
			temp += "}";
			temp += ",";
		}
		
		temp = temp.substring(0, temp.length()-1);
		temp += "]";
		
		writer.print(temp);
		writer.close();
	}
}

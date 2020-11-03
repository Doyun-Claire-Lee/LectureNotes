package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/ex12ok.do")
public class Ex12Ok extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 가져오기(buseo)
		//2. DB작업(select)
		//3. 결과 반환 > JSON 반환

		
		//1.
		req.setCharacterEncoding("UTF-8");
		String buseo = req.getParameter("buseo");
		
		
		//2. 
		AjaxDAO dao = new AjaxDAO();
		ArrayList<BuseoDTO> list = dao.jikwilist(buseo);
		dao.close();
		
		//3.
		/*
			{
				"name": "부장",
				"cnt" : "10",
			}
		
		*/
	
		JSONArray arr = new JSONArray();
		
		for(BuseoDTO dto : list) {
			
			JSONObject obj = new JSONObject();
			//하이차트의 데이터와 형식을 맞춰주려고 property이름을 변경함.
			obj.put("name", dto.getJikwi());
			obj.put("y", Integer.parseInt(dto.getCnt()));	//json에서 숫자를 넘기면 따옴표를 생략해줌!
			arr.add(obj);
			
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		writer.print(arr);
		writer.close();
		
	}
	
}

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

@WebServlet("/ex09ok.do")
public class Ex09Ok extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 받아오기
		//2. DB작업 -> select
		//3. 결과 반환 -> JSON list 반환
		
		//1.
		req.setCharacterEncoding("UTF-8");
		String word = req.getParameter("word");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		ArrayList<String> list = dao.searchlist(word);
		dao.close();
		
		//3.
		
		/*
		json-simple-1.1.1.jar 라이브러리
		 - json 오브젝트 : HashMap과 똑같은 자료구조
		 - json 어레이
		
		JSONObject o1 = new JSONObject();
		o1.put("name", "홍길동");
		o1.put("age", "20");
		System.out.println(o1);		//{"name":"홍길동","age":"20"}
		
		JSONObject o2 = new JSONObject();
		o2.put("name", "아무개");
		o2.put("age", "25");
		System.out.println(o2);		//{"name":"아무개","age":"25"}

		JSONArray arr = new JSONArray();
		arr.add(o1);
		arr.add(o2);
		System.out.println(arr);	//[{"name":"홍길동","age":"20"},{"name":"아무개","age":"25"}]
		*/
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		PrintWriter writer = resp.getWriter();
		
		JSONArray arr = new JSONArray();
		
		for (String item : list) {
			//데이터가 하나씩밖에 없기 때문에 굳이 객체안에 넣지 않았음.
			arr.add(item);
		}
		
		writer.print(arr);
		writer.close();
		
	}
	
}

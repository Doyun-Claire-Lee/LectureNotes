package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04ok.do")
public class Ex04Ok extends HttpServlet {
	
	//ajax 객체의 요청을 받아서 응답하는 서블릿
	// - 브라우저를 상대하는 서블릿이 아님.
	// - 브라우저 -> HTML 문서를 반환함, ajax -> 데이터를 반환함 (HTML(X))
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		if (type.equals("1")) {
			//text 요청
			m1(req, resp);	
		} else if (type.equals("2")) {
			//xml 요청
			m2(req, resp);
		} else if (type.equals("3")) {
			//json 요청
			m3(req, resp);
		} else if (type.equals("4")) {
			//많은 데이터 요청(text) 
			m4(req, resp);
		
		} else if (type.equals("5")) {
			//많은 데이터 요청 (xml)
			m5(req, resp);
		
		} else if (type.equals("6")) {
			//많은 데이터 요청 (json)
			m6(req, resp);
		
		}
		
		
		
		
		
	
	}

	private void m6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AjaxDAO dao = new AjaxDAO();
		ArrayList<BoardDTO> list = dao.list();
		dao.close();
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		temp += "[";

		for (BoardDTO dto : list) {
			temp += "{";
			temp += String.format("\"seq\":\"%s\"", dto.getSeq());
			temp += ",";
			temp += String.format("\"subject\":\"%s\"", dto.getSubject());
			temp += ",";
			temp += String.format("\"regdate\":\"%s\"", dto.getRegdate());
			temp += "}";
			temp += ",";
			
		}
		temp = temp.substring(0, temp.length()-1);	//마지막  콤마(,)를 지워주기 위해 뒤에서 한글자를 짤라줌
		temp += "]";
		
		writer.print(temp);
		writer.close();	
	}	
		
	private void m5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AjaxDAO dao = new AjaxDAO();
		ArrayList<BoardDTO> list = dao.list();
		dao.close();
		
		//ajax에게 게시물 반환
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/xml");
		
		PrintWriter writer = resp.getWriter();
		writer.print("<?xml version='1.0' encoding='UTF-8' ?>");
		writer.print("<list>");
		
		for (BoardDTO dto : list) {
			writer.print("<item>");
			
			writer.print("<seq>");
			writer.print(dto.getSeq());
			writer.print("</seq>");
			writer.print("<subject>");
			writer.print(dto.getSubject());
			writer.print("</subject>");
			writer.print("<regdate>");
			writer.print(dto.getRegdate());
			writer.print("</regdate>");
			
			writer.print("</item>");
		}
		
		
		writer.print("</list>");
		writer.close();
		

		
	}

	private void m4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AjaxDAO dao = new AjaxDAO();
		ArrayList<BoardDTO> list = dao.list();
		dao.close();
		
		//ajax에게 게시물 반환
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		//CSV 형식으로 반환
		for (BoardDTO dto : list) {
			writer.printf("%s,%s,%s\n", dto.getSeq(), dto.getSubject(), dto.getRegdate());
		}
				
		
	}

	private void m3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//JSON요청
		//JSON(JavaScript Object Notation) -> 자바 표기법을 사용한 객체 표현 방식
		/*
			#JavaScript 객체 생성 방법
			var obj = {
				name: "홍길동",
				age: 20,
				address: "서울시"	
			};
			
			#JSON 표기 방법
			무조건 쌍따옴표를 적어야 함!!!!!
			{
				"name": "홍길동",
				"age": "20",			//숫자일 때 따옴표는 생략해도 됨.
				"address": "서울시"		
			}
		*/
		int count = 111;
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("{");
		writer.printf("\"result\": \"%d\"", count);
		writer.print("}");
		writer.close();
		
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//xml 요청
		// -> ajax에게 돌려주는 데이터를 XML 형식으로 만들어서 반환
		// -> writer로 작성하는 데이터가 XML 문법의 출력물이면 된다.
		
		int count = 250;
		
		//MIME(브라우저에게 현재 전달되는 데이터가 XML 형식의 데이터라고 알려주는 역할, 생략하면 HTML이라고 인식하게됨..
		resp.setContentType("text/xml");	//writer보다 먼저 적어줘야 함. 
		
		//돌려주는 데이터에 한글이 있으면 인코딩을 해주어야 함.
		resp.setCharacterEncoding("UTF-8"); 	//돌려줄때는 resp.setChar... 가져올때는 req.setChar...
		
		
		//XML도 id와 class를 붙일 수 있음. 수신쪽에서 id와 class를 통해 찾을 수도 있음. 
		PrintWriter writer = resp.getWriter();
		writer.print("<?xml version='1.0' encoding='UTF-8' ?>");	//XML 선언문 먼저 작성, 한글자라도 틀리면 오타남.
		writer.print("<item>");
		writer.print(count);
		writer.print("</item>");
		
	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//TEXT요청일때
		//DB에 다녀왔다 침.(select count(*) from ...)
		int count = 175;
		
		//ajax에게 text 방식으로 반환하기 -> PrintWriter 사용!
		// -> 화면을 소스보기로 봤을 때 175라는 텍스트 이외에 아무것도 없음!
		PrintWriter writer = resp.getWriter();
		writer.print(count);
		writer.close();
		
		
	}
	
	
	

}

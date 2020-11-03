package com.test.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@로 시작 -> 어노테이션(Annotation) : 기능이 있는 주석, 실제 프로그래밍 구문
@WebServlet("/ex22_form.do")		//이 구문을 넣으면 따로 web.xml에 가상 주소를 등록하지 않아도 됨.
public class Ex22_Form extends HttpServlet {

	//JSP 모델2(MVC)로 작업하다 보면 나타나는 에러의 종류
	//1. 404 File not found: 100% URL 틀림
	//	- servlet 주소를 틀리는 경우: 주소창 URL이 틀림, annotation 수정
	//	- jsp 주소를 틀리는 경우 : 에러메세지 본문에 나타남, dispatcher 수정
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ex22_form.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

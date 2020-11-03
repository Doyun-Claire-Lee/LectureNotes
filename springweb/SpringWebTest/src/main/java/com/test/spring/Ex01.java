package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//기존의 서블릿 역할을 하는 클래스
// - 그러나 서블릿은 아님
// - Servlet/JSP MVC 구조 : 서블릿 (컨트롤러 역할)

//컨트롤러 선언
//1. Cotroller 인터페이스 구현	: DispatcherServlet에 의해서 호출 당할 수 있는 자격을 가지게 된다.
//2. @Controller 어노테이션 사용 
public class Ex01 implements Controller {
	
	
	//handleRequest
	// - doGet/doPost 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//비즈니스 코드 구현(업무 구현)
		int count = 10; //DB에서 받아왔다 가정
		String name = "hong";
		
		//request로 넘기기
		request.setAttribute("count", count);
		
		
		//JSP 호출하기
		// - RequestDispatcher 사용 X -> ModelAndView 사용
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);		//request.setAttribute와 같은 메소드, request에 담는 역할을 함
		
		mv.setViewName("ex01");
		
		return mv;
	}

}

package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//1. 컨트롤러 선언
public class Ex03Controller implements Controller {
	
	private TestDAO dao;
	
	//생성자를 통한 주입도구를 만들 땐 기본생성자도 만들어주는 것이 좋음.
	//기본 생성자
	public Ex03Controller() {
		this.dao = null;
	}
	//주입도구 생성자 
	public Ex03Controller(TestDAO dao) {
		this.dao = dao;
	}
	
	//2. 요청 메소드
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//3. 업무 구현
//		TestDAO dao = new TestDAO();	//의존 객체 -> 주입해주기
		int count = dao.getCount();
		
		
		//4. JSP 호출하기
		ModelAndView mv = new ModelAndView();	//뷰를 호출하는 작업 + 데이터를 전달하는 작업
		mv.addObject("count", count);			//request.setAttribute와 동일
		mv.setViewName("ex03");					//단축 경로 표현(JSP 호출)
			
		return mv;
	}
	
}

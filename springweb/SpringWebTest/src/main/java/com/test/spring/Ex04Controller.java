package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현 방법
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용

@Controller
@RequestMapping(value="/ex04.action")	//servlet-context.xml에 <bean>을 만드는 것 대신
public class Ex04Controller {
	
	//요청메소드 > handleRequest -> 인터페이스 상속을 하지 않았기 때문에 굳이 이렇게 만들 필요가 없음
	// -> 맘대로 만들어도 됨, RequestMapping 어노테이션 달기 
	
	@RequestMapping		// = doGet(), doPost()
	public String test() {
		
		//업무 구현
		
		//JSP 호출하기
		return "ex04";	//WEB-INF/views/ex04.jsp를 뜻함. ViewResolver가 경로를 만들어줌.

	}

	
	
}

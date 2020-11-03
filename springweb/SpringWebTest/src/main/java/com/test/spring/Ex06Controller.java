package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Ex06Controller {
	
	@RequestMapping(value="/ex06.action")
	public String call() {
		
		return "ex06";
	}

	
	//기본적으로 GET, POST의 요청 모두에 응답
	//GET, POST를 구분지어 요청받기 -> method= {RequestMethod.XXX} 추가
	//@RequestMapping(value="/ex06ok.action", method={RequestMethod.GET})
	@RequestMapping(value="/ex06ok.action", method={RequestMethod.POST})
	public void callok() { 
		
		System.out.println("호출됨");
	}
	
}

package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/list.action")
public class BoardController {
	
	//글 목록 보기
	@RequestMapping(value="/list.action")
	public String list() {
	
		return "list";
	}
	
	//글쓰기
	@RequestMapping(value="/add.action")
	public String add() {
		
		return "add";
	}
	
	@RequestMapping(value="/addok.action")
	public void addok() {
		//PrintWriter로 출력해주는 작업 구현
	}
	
	//글보기
	@RequestMapping(value="/view.action")
	public String view() {
		
		return "view";
	}
	
}

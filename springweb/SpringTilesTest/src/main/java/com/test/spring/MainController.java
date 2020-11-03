package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	//회원 > 정보
	@RequestMapping(value = "/member/info.action", method = { RequestMethod.GET })
	public String info(HttpServletRequest request, HttpServletResponse response) {

		//기존 ViewResolver -> jsp 페이지를 찾는다.
		//return "member/info";
		
		//Tiles ViewResolver : tiles.xml <definition>의 name 속성값을 찾는다.
		return "member.info";
	}
	
	@RequestMapping(value = "/member/point.action", method = { RequestMethod.GET })
	public String point(HttpServletRequest request, HttpServletResponse response) {
		
		return "member.point";
	}
	
	@RequestMapping(value = "/member/board.action", method = { RequestMethod.GET })
	public String board(HttpServletRequest request, HttpServletResponse response) {
		
		return "member.board";
	}
	
	@RequestMapping(value = "/admin/log.action", method = { RequestMethod.GET })
	public String log(HttpServletRequest request, HttpServletResponse response) {
		
		return "admin.log";
	}
	
	@RequestMapping(value = "/admin/chart.action", method = { RequestMethod.GET })
	public String chart(HttpServletRequest request, HttpServletResponse response) {
		
		return "admin.chart";
	}
	
	@RequestMapping(value = "/admin/member.action", method = { RequestMethod.GET })
	public String member(HttpServletRequest request, HttpServletResponse response) {
		
		return "admin.member";
	}
	
}

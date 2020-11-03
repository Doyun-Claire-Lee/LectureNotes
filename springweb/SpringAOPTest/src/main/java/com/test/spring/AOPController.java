package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {
	
	//의존관계
	//AOPController - Service - DAO - SqlSessionTempalte(MyBatis) 
	
	@Autowired
	private IService service;
	
	//주업무
	@RequestMapping(value = "/index.action", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, HttpServletResponse response) {

		//시작 페이지
		int count = service.getCount();
		request.setAttribute("count", count);

		return "result";
	}
	
	//로그인
	@RequestMapping(value = "/login.action", method = { RequestMethod.GET })
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		//인증 티켓 발급
		session.setAttribute("id", "hong");
		

		return "result";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout.action", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		//인증 티켓 소멸
		session.removeAttribute("id");

		return "result";
	}
	
	//회원전용
	@RequestMapping(value = "/member.action", method = { RequestMethod.GET })
	public String member(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		//보조 업무 추가 > 로그인 안한 사람들 쫓아내기
		// -> 	주 업무에 간섭하지 않기 위해 Auth에서 생성하기!
		//		보통은 보조업무 하나당 클래스 하나를 만드는 편
		
		return "member";
	}
	
	//회원전용2
	@RequestMapping(value = "/memberinfo.action", method = { RequestMethod.GET })
	public String memberinfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		//보조 업무 추가 > 로그인 안한 사람들 쫓아내기
		// -> 	주 업무에 간섭하지 않기 위해 Auth에서 생성하기!
		//		보통은 보조업무 하나당 클래스 하나를 만드는 편
		
		return "member";
	}
	
	
}

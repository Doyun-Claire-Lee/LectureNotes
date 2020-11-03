package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//보조업무를 떼어내고 싶을 때 -> 더이상 보조 업무 객체가 아니도록 만들면 됨!! 아래 두 어노테이션 주석달기
@Aspect
@Component
public class Logger {
	
	@Pointcut("execution(public String AOPController.member*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()")
	public void log(JoinPoint joinPoint) {
		
		//로그 기록
		//1. 누가(유저)
		//2. 언제(시간)
		//3. 어디를(어떤 페이지를 방문했는지)
		
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse)joinPoint.getArgs()[1];
		HttpSession session = (HttpSession)joinPoint.getArgs()[2];
		
		//기록하기
		System.out.printf("[log] %tF %tT\n", Calendar.getInstance(), Calendar.getInstance());
		System.out.println("[log] " + session.getAttribute("id"));
		System.out.println("[log] " + request.getRequestURL());
		
		
		
	}

}

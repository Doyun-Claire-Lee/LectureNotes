package com.test.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무 객체
@Aspect		//보조업무 객체의 자격
@Component	//의존 주입 자격 (@Service, @ Repository와 같은 역할)
public class Cross {
	
	//주업무 메소드를 지정 > Point cut 생성
	@Pointcut("execution(public int com.test.spring.Service.getCount())")
	public void pc1() {
		//내부에 아무것도 적지 않음. 적어도 실행되지 않음.
	}
	
	//보조 업무
	@Before("pc1()")	//주업무인 getCount()가 실행되기 전에 Before Advice로 해당 메소드를 지정함.
	public void m1() {
		System.out.println("보조업무가 실행되었습니다.");
	}
	
	
	
	
}

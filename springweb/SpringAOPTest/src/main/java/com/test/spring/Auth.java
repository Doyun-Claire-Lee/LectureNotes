package com.test.spring;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조업무 객체
@Aspect
@Component
public class Auth {
	
	//주업무 메소드 > 포인트컷
//	@Pointcut("execution(public String AOPController.member(..))")	-> 보조업무를 실행할 수업무가 하나일 경우
	@Pointcut("execution(public String AOPController.member*(..))")	//해당 패키지의 member로 시작하는 모든 메소드에서 보조업무가 실행됨. 
	public void pc1() {												//웬만하면 패키지를 따로 만들어서 해당 패키지 내의 모든 메소드에 적용되도록 하는것을 권장!!
		
	}
	
	//Weaving -> 보조업무와 주업무를 엮는 과정
	@Before("pc1()")
	public void check(JoinPoint joinPoint) {
		
		//현재 주업무를 발생시킨 유저가 로그인 상태인지? -> Session을 확인해야 하는데..
		//어떻게 Session을 받아오는지?
		//JoinPoint가 주 업무 메소드의 참조를 받아올 수 있음.
		
		//joinPoint.getArgs();	//주업무메소드의 매개변수를 Object배열로 가져옴!!
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse)joinPoint.getArgs()[1];
		HttpSession session = (HttpSession)joinPoint.getArgs()[2];
		
		if (session.getAttribute("id") == null) {
			
			System.out.println("로그인X");
			//로그인 안한 유저 쫓아내기!!
			//1. response.sendRedirect() ->  말없이
			//2. alert + locaion.href
			
			try {
				
				response.setCharacterEncoding("UTF-8");
				PrintWriter writer = response.getWriter();
				
				writer.print("<html>");
				writer.print("<head>");
				writer.print("<meta charset='UTF-8'>");
				writer.print("</head>");
				writer.print("<body>");
				writer.print("<script>");
				writer.print("alert('로그인 하세요.');");
				writer.print("location.href='/spring/index.action';");
				writer.print("</script>");
				writer.print("</body>");
				writer.print("</html>");
			
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("로그인");
		}
		
		System.out.println("인증을 확인합니다.");
	}
	
	
}

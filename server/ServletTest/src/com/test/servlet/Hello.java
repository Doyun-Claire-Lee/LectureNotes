package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//1. 서블릿 클래스 선언(동적 웹페이지를 생성할 수 있는 자격 획득)
public class Hello extends HttpServlet {
	
	
	//2. 메소드 선언
	//2-a. 매개변수 작성
	//2-b. 예외 미루기
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//3. 동적 HTML문서 구현
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Time</h1>");
		writer.println("<p>");
		writer.printf("%tF %tT", Calendar.getInstance(), Calendar.getInstance());
		writer.println("</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		//모든 입출력 도구는 사용 후 반드시 닫아야 함.(닫지 않으면 페이지가 안만들어짐)
		writer.close();
		
		System.out.println("브라우저 요청에 따른 동적 페이지 제작 완료");
		
		//개발자가 실행하는것이 아닌 브라우저가 요청하여 실행되도록 해야함. -> web.xml파일 수정하기 

			
		
	}
//	public void doPost() { }
}

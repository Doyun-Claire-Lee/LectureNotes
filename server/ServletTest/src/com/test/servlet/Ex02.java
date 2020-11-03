package com.test.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		//test.html읽기
//		File file = new File("test.html");
//		System.out.println(file.getAbsolutePath());	//C:\eclipse\test.html
		
		
		//JDBC 데이터 반환 가정
		String subject = "광고 메일입니다.";
		String sender = "쿠팡";
		String receiver = "";
		String time = "";
		
		
		
		Scanner scan = new Scanner(new FileReader("D:\\class\\server\\ServletTest\\test.html"));
		
		while(scan.hasNext()) {
//			System.out.println(scan.nextLine());

			//요즘은 안쓰는 방식 
			String line = scan.nextLine();
			line = line.replace("{1}", subject);
			line = line.replace("{2}", sender);
			line = line.replace("{3}", receiver);
			line = line.replace("{4}", time);
			
			System.out.println(line);
			writer.println(line);
		}
	
	
	
	}
	
	
	
	
}

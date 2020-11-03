package com.test.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

//요청에 따라 웹페이지를 동적으로 만들어주는 역할 
public class Test {

	public static void main(String[] args) {
		
		//내 받은편지함 페이지 만들기
		//상황 : 유저가 브라우저를 통해 메일 사이트에 접속
		//		 받은편지함 페이지에 접속
		//		 http://mail.naver.com/받은편지함.html
		//		 동적으로 페이지를 생성하라고 요청(ctrl + f11)
		//		
		
		
		
		
		String html ="";
		
		html += "<html>";
		html += "<head>";
		html += "<meta charset='UTF-8'>";
		html += "<title>받은 편지함</title>";
		html += "</head>";
		html += "<body>";
		html += "<h1>받은 편지함</h1>";
		html += String.format("<p>메일이 도착했습니다. - %tT</p>", Calendar.getInstance());
		html += "</body>";
		html += "</html>";
		
		try {
			
//			BufferedWriter writer = new BufferedWriter(new FileWriter("mail.html"));	//파일이 루트에 생김
			BufferedWriter writer = new BufferedWriter(new FileWriter("WebContent\\mail.html"));
			writer.write(html);
			writer.close();
			System.out.println("html created");

		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		
	}
	
	
	
	
	
}

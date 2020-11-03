package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02ok.do")
public class Ex02Ok extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 받아오기(txt1)
		//2. DB작업결과 + 1번
		//3. 반환
		
		int num = Integer.parseInt(req.getParameter("txt1"));
	
		//db 다녀왔다 치고
		int db = 10;
	
		//결과
		int result = num + db;
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<script>");
		writer.printf("location.href='/ajax/ex02.do?result=%d';", result);
		writer.println("</script>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
		
	}
}

package com.test.address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOk extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//AddOk.java
		//1. 데이터 가져오기
		//2. DB작업 -> insert
		//3. 결과 반환(JSP 호출하기)
		
		
		//데이터 가져오기
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		
		//DB작업
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		
		try {
			
		
			DBUtil util = new DBUtil();
			conn = util.open();
		
			String sql = "insert into tblAddress(seq, name, age, address, regdate) values (SEQADDRESS.nextval, ?, ?, ?, default)";
			stat = conn.prepareStatement(sql);
			
			stat.setString(1, name);
			stat.setString(2, age);
			stat.setString(3, address);
			
			int result = stat.executeUpdate();
			//jsp에게 결과를 전송하기 위해 req에 저장
			req.setAttribute("result", result);
			
			
			conn.close();
			util.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addok.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

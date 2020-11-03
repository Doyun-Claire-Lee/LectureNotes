package com.test.address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//삭제
		//1. 데이터 가져오기(seq)
		//2. DB 작업
		//3. 결과 반환(JSP 호출)
		
		//1. 
		String seq = req.getParameter("seq");
		
		//2. 
		Connection conn = null;
		PreparedStatement stat = null;
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			String sql = "delete from tblAddress where seq = ?";
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			int result = stat.executeUpdate();
			
			stat.close();
			conn.close();
			
			req.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/del.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

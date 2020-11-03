package com.test.address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Edit extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 넘어몬 데이터 가져오기(seq)\
		//2. DB작업 -> select 해서 나머지 정보 가져오기
		//3. JSP로 데이터 전달하고 호출하기 
		
		//1.
		
		String seq = req.getParameter("seq");
		
		//2. 
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		Address address = new Address();
		
		try {
	
			conn = util.open();
			
			String sql = "select * from tblAddress where seq = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, seq);
			
			rs = stat.executeQuery();
			
			if (rs.next()) {
				address.setSeq(rs.getString("seq"));
				address.setName(rs.getString("name"));
				address.setAge(rs.getString("age"));
				address.setAddress(rs.getString("address"));
				address.setRegdate(rs.getString("regdate"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			//3.
			req.setAttribute("address", address);
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/edit.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}

package com.test.address;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//목록 보기
		//1. DB 작업 > select
		//2. 반환 테이블을 JSP에 넘기기 
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		try {
			
			String sql = "select * from tblAddress order by seq desc";

			conn = util.open();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			//rs를 jsp로 넘기기 위해 ArrayList에 저장하기 
			//rs -> ArrayList<DTO>
			
			ArrayList<Address> list = new ArrayList<Address>(); 
			
			while(rs.next()) {
				
				Address address = new Address();
				
				address.setSeq(rs.getString("seq"));
				address.setName(rs.getString("name"));
				address.setAge(rs.getString("age"));
				address.setAddress(rs.getString("address"));
				address.setRegdate(rs.getString("regdate"));
				
				list.add(address);
			
			}
			
			//jsp에 넘길 req객체에 데이터 담기
			req.setAttribute("list", list);

			stat.close();
			conn.close();
		
		} catch (Exception e) {
			
			e.printStackTrace();
					
		}
		
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	
}
